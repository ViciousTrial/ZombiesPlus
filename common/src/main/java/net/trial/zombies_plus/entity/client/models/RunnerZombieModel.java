package net.trial.zombies_plus.entity.client.models;

import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class RunnerZombieModel<T extends Zombie> extends ZombieModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "brutezombie"), "main");
	private boolean alreadySetup = false;
	
	public ModelPart leftarm = this.leftArm;

	public RunnerZombieModel(ModelPart root) {
		super(root);
		if (alreadySetup == false){
			//modelExtraMethods.determineArmless(this.leftArm, this.rightArm);
			alreadySetup = true;
		}
	}
	
} 