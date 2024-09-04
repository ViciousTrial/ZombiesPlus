package net.trial.zombies_plus.entity.client.models;

import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Zombie;
import net.trial.zombies_plus.entity.custom.crossbowZombieEntity;
public class crossbowZombieModel<T extends Zombie> extends ZombieModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "brutezombie"), "main");

	public crossbowZombieModel(ModelPart root) {
		super(root);
		
	}
	private static final float f = 1.0f;

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {
		crossbowZombieEntity entity = (crossbowZombieEntity) pEntity;
		AbstractIllager.IllagerArmPose armPose = entity.getArmPose();
			if (armPose == AbstractIllager.IllagerArmPose.BOW_AND_ARROW) {
			this.rightArm.yRot = -0.1F + this.head.yRot;
			this.rightArm.xRot = (-(float)Math.PI / 2F) + this.head.xRot;
			this.leftArm.xRot = -0.9424779F + this.head.xRot;
			this.leftArm.yRot = this.head.yRot - 0.4F;
			this.leftArm.zRot = ((float)Math.PI / 2F);
		} else if (armPose == AbstractIllager.IllagerArmPose.CROSSBOW_HOLD) {
			AnimationUtils.animateCrossbowHold(this.rightArm, this.leftArm, this.head, true);
		} else if (armPose == AbstractIllager.IllagerArmPose.CROSSBOW_CHARGE) {
			AnimationUtils.animateCrossbowCharge(this.rightArm, this.leftArm, entity, true);
		} else if (armPose == AbstractIllager.IllagerArmPose.CELEBRATING) {
			this.rightArm.z = 0.0F;
			this.rightArm.x = -5.0F;
			this.rightArm.xRot = Mth.cos(pAgeInTicks * 0.6662F) * 0.05F;
			this.rightArm.zRot = 2.670354F;
			this.rightArm.yRot = 0.0F;
			this.leftArm.z = 0.0F;
			this.leftArm.x = 5.0F;
			this.leftArm.xRot = Mth.cos(pAgeInTicks * 0.6662F) * 0.05F;
			this.leftArm.zRot = -2.3561945F;
			this.leftArm.yRot = 0.0F;
		}

		//new headRot().headRotation(f, entity, pNetHeadYaw, pHeadPitch, this.head);

		headRotation(f, entity, pNetHeadYaw, pHeadPitch);

		this.rightLeg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount / f;
		this.leftLeg.xRot = Mth.cos(pLimbSwing * 0.6662F + (float)Math.PI) * 1.4F * pLimbSwingAmount / f;
		
		//super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
	}

	@Override
	public boolean isAggressive(T pEntity) {
		return pEntity.isAggressive();
	}

		public void headRotation(float f, Entity entity, float netHeadYaw, float headPitch){
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

				if (entity instanceof crossbowZombieEntity) {
					crossbowZombieEntity customZombie = (crossbowZombieEntity) entity;

			boolean flag = customZombie.getFallFlyingTicks() > 4;
			boolean flag1 = customZombie.isVisuallySwimming();
			this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (flag) {
			this.head.xRot = (-(float)Math.PI / 4F);
			} else if (customZombie.getSwimAmount(f) > 0.0F) {
			if (flag1) {
				this.head.xRot = customZombie.rotlerpRad(customZombie.getSwimAmount(f), this.head.xRot, (-(float)Math.PI / 4F));
			} else {
				this.head.xRot = customZombie.rotlerpRad(customZombie.getSwimAmount(f), this.head.xRot, headPitch * ((float)Math.PI / 180F));
			}
			} else {
			this.head.xRot = headPitch * ((float)Math.PI / 180F);
			}

		}
	}

}