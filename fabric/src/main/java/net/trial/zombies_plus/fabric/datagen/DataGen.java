package net.trial.zombies_plus.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.trial.zombies_plus.fabric.datagen.block.BlockTagGen;
import net.trial.zombies_plus.fabric.datagen.lang.LangGen;
import net.trial.zombies_plus.fabric.datagen.model.ModelProvider;

public class DataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModelProvider::new);
		pack.addProvider(LangGen::new);
		pack.addProvider(BlockTagGen::new);
		//pack.addProvider(recipeProvider::new);
	}
}