package net.trial.zombies_plus.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.trial.zombies_plus.fabric.datagen.lang.langGen;
import net.trial.zombies_plus.fabric.datagen.model.modelProvider;

public class dataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(modelProvider::new);
		pack.addProvider(langGen::new);
		//pack.addProvider(recipeProvider::new);
	}
}