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
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.entity.animations.runnerZombieModelAnimation;
import net.trial.zombies_plus.entity.animations.shriekerZombieModelAnimation;
import net.trial.zombies_plus.entity.custom.shriekerZombieEntity;

public class shriekerZombieModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "runnerzombie"), "main");
	private final ModelPart rig;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public shriekerZombieModel(ModelPart root) {
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

		PartDefinition body = rig.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -9.0F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -9.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = rig.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.9F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -10.0F, 0.0F));

		PartDefinition right_leg = rig.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.1F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -10.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		shriekerZombieEntity customZombie = (shriekerZombieEntity) entity;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		if (modMainCommon.modConfigInstance.useBetterAnimations){
			
			this.animate(customZombie.shriekAnimationState, shriekerZombieModelAnimation.shriekBetter, ageInTicks, 1f);
			this.animateWalk(runnerZombieModelAnimation.walk, limbSwing, limbSwingAmount, 1f, 2f);
			this.animate(customZombie.idleAnimationState, runnerZombieModelAnimation.idle, ageInTicks, 1f);
		}else{
			this.animate(customZombie.shriekAnimationState, shriekerZombieModelAnimation.shriek, ageInTicks, 1f);
			float f = 1.0F;

			
			this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

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


			this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
			this.left_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
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