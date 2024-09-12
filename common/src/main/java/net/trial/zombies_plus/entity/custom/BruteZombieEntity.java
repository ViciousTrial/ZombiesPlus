package net.trial.zombies_plus.entity.custom;

import net.trial.zombies_plus.ModMainCommon;
import org.joml.Random;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class BruteZombieEntity extends AbstractZombieEntity {

    private ResourceLocation variantTexture; 

    public BruteZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.refreshDimensions();

        if (ModMainCommon.modConfigInstance.zombieTextureOverride) {
            int variantIndex = new Random().nextInt(VARIANT_TEXTURES.length);
            this.variantTexture = VARIANT_TEXTURES[variantIndex];
        } else {
            this.variantTexture = new ResourceLocation(ModMainCommon.MOD_ID, "textures/entity/brute_zombie/brute_zombie.png");
        }
    }

    private static final ResourceLocation[] VARIANT_TEXTURES = {
        new ResourceLocation(ModMainCommon.MOD_ID, "textures/entity/brute_zombie/variants/variant_1.png"),
        new ResourceLocation(ModMainCommon.MOD_ID, "textures/entity/brute_zombie/variants/variant_2.png")
    };


    @Override
    public ResourceLocation getTexture(){
        return this.variantTexture;
    }
     public static AttributeSupplier.Builder createAttributes() {
      return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.17F).add(Attributes.ATTACK_DAMAGE, 5D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE).add(Attributes.MAX_HEALTH, 40D);
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

   @Override
   protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
       return 2.1f;
   }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        return EntityDimensions.scalable(1.23f, 2.4f);
    }

}
