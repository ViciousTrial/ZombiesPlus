package net.trial.zombies_plus.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.custom.*;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.custom.SwordZombieEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModMain implements ModInitializer {
	public static final String MOD_ID = ModMainCommon.MOD_ID;
    	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModMainCommon.init();
		//ModItemGroups.registerItemGroups();

		//modItems.registerModItems();
		//modEntities.registerModEntities();
		//modblo.registerModBlocks();

		//FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		FabricDefaultAttributeRegistry.register(modEntities.RUNNER_ZOMBIE.get(), RunnerZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.BRUTE_ZOMBIE.get(), BruteZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.CRAWLER_ZOMBIE.get(), CrawlerZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.BOW_ZOMBIE.get(), BowZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.CROSSBOW_ZOMBIE.get(), CrossbowZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.SHRIEKER_ZOMBIE.get(), ShriekerZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.AXE_ZOMBIE.get(), AxeZombieEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(modEntities.SWORD_ZOMBIE.get(), SwordZombieEntity.createAttributes().build());
	}
  
}