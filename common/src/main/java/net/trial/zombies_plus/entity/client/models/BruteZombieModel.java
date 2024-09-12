package net.trial.zombies_plus.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.animations.RunnerZombieModelAnimation;
import net.trial.zombies_plus.entity.custom.BruteZombieEntity;

public class BruteZombieModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "brutezombie"), "main");
	private final ModelPart rig;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart headwear;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	//private boolean alreadySetup = false;

	public BruteZombieModel(ModelPart root) {
		this.rig = root.getChild("rig");
		this.body = rig.getChild("body");
		this.head = body.getChild("head");
		this.headwear = head.getChild("headwear");
		this.left_arm = body.getChild("left_arm");
		this.right_arm = body.getChild("right_arm");
		this.right_leg = rig.getChild("right_leg");
		this.left_leg = rig.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rig = partdefinition.addOrReplaceChild("rig", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = rig.addOrReplaceChild("body", CubeListBuilder.create().texOffs(2, 16).addBox(-6.0F, -5.0F, -5.0F, 12.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(44, 44).mirror().addBox(-2.0F, -2.0F, -2.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -3.0F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(43, 43).addBox(-3.0F, -2.0F, -2.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -3.0F, 0.0F));

		PartDefinition right_leg = rig.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 46).addBox(-4.1F, -2.0F, -2.0F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition left_leg = rig.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 46).mirror().addBox(-0.9F, -2.0F, -2.0F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headwear.visible = false;
		BruteZombieEntity customZombie = (BruteZombieEntity) entity;
		if (ModMainCommon.modConfigInstance.useBetterAnimations){
			
			this.root().getAllParts().forEach(ModelPart::resetPose);

			this.animateWalk(RunnerZombieModelAnimation.walk, limbSwing, limbSwingAmount, 1.2f, 2f);
			this.animate(((BruteZombieEntity) entity).idleAnimationState, RunnerZombieModelAnimation.idle, ageInTicks, 1f);
		}else{
			float f = 1.0F;
	
			if (f < 1.0F) {
			f = 1.0F;
			}

			this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (entity instanceof BruteZombieEntity) {
				AnimationUtils.animateZombieArms(this.left_arm, this.right_arm, customZombie.isAggressive(), this.attackTime, ageInTicks);

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
			this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
			this.left_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
/* 
			if (customZombie.getLeftArmVisible()){
				this.left_arm.visible = true;
			}
			if (customZombie.getRightArmVisible()){
				this.right_arm.visible = true;
			} */
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rig.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return rig;
	}
}