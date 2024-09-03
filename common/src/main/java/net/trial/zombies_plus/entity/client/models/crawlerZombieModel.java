package net.trial.zombies_plus.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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
import net.trial.zombies_plus.entity.animations.crawlerZombieModelAnimation;
import net.trial.zombies_plus.entity.animations.crawlerZombieModelAnimationBetter;
import net.trial.zombies_plus.entity.custom.crawlerZombieEntity;

public class crawlerZombieModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "crazlerzombie"), "main");
	private final ModelPart rig;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public crawlerZombieModel(ModelPart root) {
		this.rig = root.getChild("rig");
		this.body = rig.getChild("body");
		this.head = body.getChild("head");
		this.headwear = head.getChild("headwear");
		this.left_arm = body.getChild("left_arm");
		this.right_arm = body.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rig = partdefinition.addOrReplaceChild("rig", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition body = rig.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -5.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition headwear_r1 = headwear.addOrReplaceChild("headwear_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, -3.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6.0F, 0.0F, -3.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	private float threshold = 0.5f;
	private static final float f = 1.0f;

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		boolean isWalking = limbSwingAmount > threshold;

		if (modMainCommon.modConfigInstance.useBetterAnimations){
			if (isWalking) {
				if (((crawlerZombieEntity) entity).idleAnimationState.isStarted()) {
					((crawlerZombieEntity) entity).idleAnimationState.stop();
				}
				this.animateWalk(crawlerZombieModelAnimationBetter.crawl, limbSwing, limbSwingAmount, 1.2f, 2f);
			} else {
				((crawlerZombieEntity) entity).idleAnimationState.startIfStopped((int) ageInTicks);
				this.animate(((crawlerZombieEntity) entity).idleAnimationState, crawlerZombieModelAnimationBetter.idleBetter, ageInTicks, 1f);
			}
		}else{

			headRotation(f, entity, netHeadYaw, headPitch);
			this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
			this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;


			this.animate(((crawlerZombieEntity) entity).idleAnimationState, crawlerZombieModelAnimation.idle, ageInTicks, 1f); 
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

	public void headRotation(float f, Entity entity, float netHeadYaw, float headPitch){
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

				if (entity instanceof crawlerZombieEntity) {
			crawlerZombieEntity customZombie = (crawlerZombieEntity) entity;

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