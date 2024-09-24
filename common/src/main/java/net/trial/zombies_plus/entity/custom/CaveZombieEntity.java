package net.trial.zombies_plus.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.sound.ModSounds;
import net.trial.zombies_plus.util.ModTags;
import org.jetbrains.annotations.Nullable;
import org.joml.Random;

public class CaveZombieEntity extends AbstractZombieEntity {



    private LivingEntity target;
    private int lightCheckCounter = 0;
    private final float maxSpeed = 0.23F;
    private final float minSpeed = 0.12F;

    private final double maxAttack = 5.0D;
    private final double minAttack = 1.0D;

    private ResourceLocation variantTexture;

    public CaveZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        if (ModMainCommon.modConfigInstance.tissouZombiePackDetails) {
            int variantIndex = new Random().nextInt(VARIANT_TEXTURES.length);
            this.variantTexture = VARIANT_TEXTURES[variantIndex];
        } else {
            this.variantTexture = new ResourceLocation(ModMainCommon.MOD_ID, getCustomTexturePath());
        }
    }


    private static final ResourceLocation[] VARIANT_TEXTURES = {
            new ResourceLocation(ModMainCommon.MOD_ID, "textures/entity/cave_zombie/variants/variant_1.png"),
            new ResourceLocation(ModMainCommon.MOD_ID, "textures/entity/cave_zombie/variants/variant_2.png"),
    };


    @Override
    protected ResourceLocation getCustomTexture() {
        return this.variantTexture;
    }

    @Override
    protected String getCustomTexturePath() {
        return "textures/entity/cave_zombie/cave_zombie.png";
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.23F).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);

    }


    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.6D, false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    public static boolean checkEntitySpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
        boolean surroundingCheck = Monster.checkMonsterSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource);
        BlockState belowState = serverLevelAccessor.getBlockState(blockPos.below());

        boolean blockCheck = belowState.is(ModTags.Blocks.CAVE_ZOMBIE_SPAWNABLE);

        boolean yLevelCheck = blockPos.getY() <= 70;

        return surroundingCheck && yLevelCheck && blockCheck;
    }

    @Override
    public void tick() {
        super.tick();
        lightCheckCounter++;

        if (lightCheckCounter >= 40) {
            lightCheckCounter = 0;

            int lightLevel = this.level().getMaxLocalRawBrightness(this.blockPosition());


            float speedRange = maxSpeed - minSpeed;
            double attackDamageRange = maxAttack - minAttack;

            float lightFactor = lightLevel / 15.0F;
            float newSpeed = maxSpeed - (speedRange * lightFactor);
            double newAttack = maxAttack - (attackDamageRange * lightFactor);

            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(newSpeed);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(newAttack);
        }
    }


    @Override
    public void setTarget(@Nullable LivingEntity livingEntity) {
        super.setTarget(livingEntity);
        if (this.target != livingEntity){
             this.level().playSeededSound(null, this.getX(), this.getY(), this.getZ(),
                    ModSounds.CAVE_ZOMBIE_YELL.get(), SoundSource.HOSTILE, 2.5f, 1f, 0);
             this.target = livingEntity;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.HUSK_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.HUSK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HUSK_DEATH;
    }

}
