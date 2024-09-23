package net.trial.zombies_plus.entity.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.trial.zombies_plus.ModMainCommon;

public class CrawlerZombieEntity extends AbstractZombieEntity {

    public CrawlerZombieEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.refreshDimensions();
    }

    @Override
    protected String getCustomTexturePath() {
        return "textures/entity/crawler_zombie/crawler_zombie.png";
    }


     public static AttributeSupplier.Builder createAttributes() {
      return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ATTACK_DAMAGE, 2.5D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE).add(Attributes.MAX_HEALTH, 15D);
   }
   @Override
   protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
       return 0.75f;
   }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        if (ModMainCommon.modConfigInstance.useBetterAnimations){
            return EntityDimensions.scalable(0.9f, 0.7f);
        }
        return EntityDimensions.scalable(0.8f, 1.2f);
    }

}
