package net.trial.zombies_plus.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.entity.custom.*;
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

        createEntityAttributes();
    }

    private void createEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.RUNNER_ZOMBIE.get(), RunnerZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.BRUTE_ZOMBIE.get(), BruteZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER_ZOMBIE.get(), CrawlerZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.BOW_ZOMBIE.get(), BowZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.CROSSBOW_ZOMBIE.get(), CrossbowZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.SHRIEKER_ZOMBIE.get(), ShriekerZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.AXE_ZOMBIE.get(), AxeZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.SWORD_ZOMBIE.get(), SwordZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.WEAK_ZOMBIE.get(), WeakZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.SLOW_ZOMBIE.get(), WeakZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.VILE_ZOMBIE.get(), VileZombieEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntities.CAVE_ZOMBIE.get(), CaveZombieEntity.createAttributes().build());
    }

}