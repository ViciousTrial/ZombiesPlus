package net.trial.zombies_plus.entity.custom;

import net.minecraft.core.particles.ShriekParticleOption;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
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
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.ai.ShriekerZombieAttackGoal;

public class ShriekerZombieEntity extends AbstractZombieEntity {

    public final AnimationState shriekAnimationState = new AnimationState();

    private static final EntityDataAccessor<Boolean> SHRIEKING =
            SynchedEntityData.defineId(ShriekerZombieEntity.class, EntityDataSerializers.BOOLEAN);


    public int shriekAnimationTimeout = 0;

    public ShriekerZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.refreshDimensions();
    }

   @Override
    protected String getCustomTexturePath() {
        return "textures/entity/shrieker_zombie/shrieker_zombie.png";
    }

     public static AttributeSupplier.Builder createAttributes() {
      return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 1.0D);
   }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        return EntityDimensions.scalable(DEFAULT_BB_WIDTH, 2f);
    }

    @Override
    protected void addBehaviourGoals() {
      this.goalSelector.addGoal(2, new ShriekerZombieAttackGoal(this, 1.0D, false));
      this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
      this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
   }

   @Override
   protected void setupAnimationStates() {
       super.setupAnimationStates();

       if(this.isShrieking() && shriekAnimationTimeout <= 0) {
        shriekAnimationTimeout = 100; // Length in ticks of your animation
        shriekAnimationState.start(this.tickCount);
    } else {
        --this.shriekAnimationTimeout;
    }

    if(!this.isShrieking()) {
        shriekAnimationState.stop();
    }
   }

   public void startShriekAnimation() {
        this.entityData.set(SHRIEKING, true);
     
        if (this.isShrieking()){
            Level pLevel = this.level();
            if (pLevel instanceof ServerLevel){
                ((ServerLevel) pLevel).sendParticles(
                    new ShriekParticleOption(0), 
                    this.getX() + 0.5, this.getY() + 1, this.getZ() + 0.5,
                    1,
                    0.5,
                    0.5,
                    0.5,
                    0.01
        );
    
    
            }
        }
   }
   public void stopShriekAnimation() {
        this.entityData.set(SHRIEKING, false);
   }

   @Override
   protected void defineSynchedData() {
       super.defineSynchedData();
       this.entityData.define(SHRIEKING, false);
   }

   public boolean isShrieking() {
    return this.entityData.get(SHRIEKING);
   }
}
