package net.trial.zombies_plus.entity.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.trial.zombies_plus.modMainCommon;

public class bowZombieEntity extends abstractZombieEntity implements RangedAttackMob {
    public bowZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.populateDefaultEquipmentSlots(random, null);
    }

   // private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(bowZombieEntity.class, EntityDataSerializers.BOOLEAN);


    @Override
    public ResourceLocation getTexture(){
        if (modMainCommon.modConfigInstance.zombieTextureOverride){
            return super.getTexture();
        }
        return new ResourceLocation(modMainCommon.MOD_ID, "textures/entity/bow_zombie/bow_zombie.png");
    }

     public static AttributeSupplier.Builder createAttributes() {
      return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
   }

   @Override
   protected void registerGoals() {
        this.goalSelector.addGoal(0, new RangedBowAttackGoal<>(this, 1.2D, 20, 15.0F));
       super.registerGoals();
   }


   @Override
   public boolean canFireProjectileWeapon(ProjectileWeaponItem pProjectileWeapon) {
       return pProjectileWeapon == Items.BOW;
   }
    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
       this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }

    public void performRangedAttack(LivingEntity livingEntity, float f) {
        ItemStack itemStack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
        AbstractArrow abstractArrow = this.getArrow(itemStack, f);
        double d = livingEntity.getX() - this.getX();
        double e = livingEntity.getY(0.3333333333333333) - abstractArrow.getY();
        double g = livingEntity.getZ() - this.getZ();
        double h = Math.sqrt(d * d + g * g);
        abstractArrow.shoot(d, e + h * 0.20000000298023224, g, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractArrow);
     }

   protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
    return ProjectileUtil.getMobArrow(this, pArrowStack, pVelocity);
 }
}
