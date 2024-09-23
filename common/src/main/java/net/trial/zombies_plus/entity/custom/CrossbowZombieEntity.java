package net.trial.zombies_plus.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.trial.zombies_plus.ModMainCommon;

public class CrossbowZombieEntity extends AbstractZombieEntity implements CrossbowAttackMob {

    public CrossbowZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.populateDefaultEquipmentSlots(random, null);

    }

    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(CrossbowZombieEntity.class, EntityDataSerializers.BOOLEAN);


    @Override
    protected String getCustomTexturePath() {
        return "textures/entity/crossbow_zombie/crossbow_zombie.png";
    }

     public static AttributeSupplier.Builder createAttributes() {
      return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
   }

   @Override
   protected void registerGoals() {
       super.registerGoals();
       this.goalSelector.addGoal(0, new RangedCrossbowAttackGoal<>(this, 1.5D, 8.0F));

   }

   @Override
   protected void defineSynchedData() {
    super.defineSynchedData();
    this.entityData.define(IS_CHARGING_CROSSBOW, false);
   }

   @Override
   public boolean canFireProjectileWeapon(ProjectileWeaponItem pProjectileWeapon) {
       return pProjectileWeapon == Items.CROSSBOW;
   }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.performCrossbowAttack(this, 1.6F);
    }

    @Override
    public void setChargingCrossbow(boolean pChargingCrossbow) {
        this.entityData.set(IS_CHARGING_CROSSBOW, pChargingCrossbow);
    }

    @Override
    public void shootCrossbowProjectile(LivingEntity pTarget, ItemStack pCrossbowStack, Projectile pProjectile,
            float pProjectileAngle) {
            this.shootCrossbowProjectile(this, pTarget, pProjectile, pProjectileAngle, 1.6F);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
       this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));
    }

    @Override
    public void onCrossbowAttackPerformed() {
       this.noActionTime = 0;
    }

    private boolean isChargingCrossbow() {
        return this.entityData.get(IS_CHARGING_CROSSBOW);
     }

     public AbstractIllager.IllagerArmPose getArmPose() {
        if (this.isChargingCrossbow()) {
           return AbstractIllager.IllagerArmPose.CROSSBOW_CHARGE;
        } else if (this.isHolding(is -> is.getItem() instanceof net.minecraft.world.item.CrossbowItem)) {
           return AbstractIllager.IllagerArmPose.CROSSBOW_HOLD;
        } else {
           return this.isAggressive() ? AbstractIllager.IllagerArmPose.ATTACKING : AbstractIllager.IllagerArmPose.NEUTRAL;
        }
    }
}
