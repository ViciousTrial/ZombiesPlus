package net.trial.zombies_plus.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.custom.axeZombieEntity;
import net.trial.zombies_plus.entity.custom.bowZombieEntity;
import net.trial.zombies_plus.entity.custom.bruteZombieEntity;
import net.trial.zombies_plus.entity.custom.crawlerZombieEntity;
import net.trial.zombies_plus.entity.custom.crossbowZombieEntity;
import net.trial.zombies_plus.entity.custom.runnerZombieEntity;
import net.trial.zombies_plus.entity.custom.shriekerZombieEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class modMain implements ModInitializer {
	public static final String MOD_ID = modMainCommon.MOD_ID;
    	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		modMainCommon.init();
		//ModItemGroups.registerItemGroups();

		//modItems.registerModItems();
		//modEntities.registerModEntities();
		//modblo.registerModBlocks();

		//FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		FabricDefaultAttributeRegistry.register(modEntities.RUNNER_ZOMBIE.get(), runnerZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.BRUTE_ZOMBIE.get(), bruteZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.CRAWLER_ZOMBIE.get(), crawlerZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.BOW_ZOMBIE.get(), bowZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.CROSSBOW_ZOMBIE.get(), crossbowZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.SHRIEKER_ZOMBIE.get(), shriekerZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.AXE_ZOMBIE.get(), axeZombieEntity.createAttributes().build());
	}
  
}