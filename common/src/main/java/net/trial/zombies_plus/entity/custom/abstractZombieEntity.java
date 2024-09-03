package net.trial.zombies_plus.entity.custom;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;

public abstract class abstractZombieEntity extends Zombie {
    
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private boolean hasSetupAnim = false;
    private boolean leftArmVisible = true;
    private boolean rightArmVisible = true;

    private static boolean isAggro = false;

    public abstractZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.refreshDimensions();
    }
    
    public ResourceLocation getTexture(){
        return new ResourceLocation("minecraft", "textures/entity/zombie/zombie.png");
    }
    
   public static boolean getAggressiveState(){
    return isAggro;
   }

   @Override
   public boolean isAggressive() {
        isAggro = super.isAggressive();
        return isAggro;
   }

   @Override
   protected boolean convertsInWater() {
       return false;
   }

   public float rotlerpRad(float pAngle, float pMaxAngle, float pMul) {
    float f = (pMul - pMaxAngle) % ((float)Math.PI * 2F);
    if (f < -(float)Math.PI) {
       f += ((float)Math.PI * 2F);
    }

    if (f >= (float)Math.PI) {
       f -= ((float)Math.PI * 2F);
    }

    return pMaxAngle + pAngle * f;
 }


    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    protected void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void setBaby(boolean pChildZombie) {
        
    }

    
    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    protected int getAnimationIdleTimeout(){
        return idleAnimationTimeout;
    }

    public boolean getHasSetupAnim(){
        return hasSetupAnim;
    }

    public void setHasSetupAnim(boolean value){
        hasSetupAnim = value;
    }

    public void setLeftArmVisible(boolean value, ModelPart arm) {
        arm.visible = value;
        leftArmVisible = value;
    }
    public void setRightArmVisible(boolean value, ModelPart arm) {
        arm.visible = value;
        leftArmVisible = value;
    }

    public boolean getLeftArmVisible(){
        return leftArmVisible;
    }
    public boolean getRightArmVisible(){
        return rightArmVisible;
    }

    public static boolean canSpawnDuringDay(ServerLevelAccessor pLevel, BlockPos pPos, RandomSource pRandom) {
        DimensionType dimensiontype = pLevel.dimensionType();
        int i = dimensiontype.monsterSpawnBlockLightLimit();
        if (i < 15 && pLevel.getBrightness(LightLayer.BLOCK, pPos) > i) {
            return false;
        } else {
            int j = pLevel.getLevel().isThundering() ? pLevel.getMaxLocalRawBrightness(pPos, 10) : pLevel.getMaxLocalRawBrightness(pPos);
            return j <= dimensiontype.monsterSpawnLightTest().sample(pRandom);
        }
    }

    public static boolean checkDaytimeSpawnRules(EntityType<? extends Monster> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.getDifficulty() != Difficulty.PEACEFUL && canSpawnDuringDay(pLevel, pPos, pRandom) && checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom);
    }


    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        return EntityDimensions.scalable(DEFAULT_BB_WIDTH, 2f);
    }
}
