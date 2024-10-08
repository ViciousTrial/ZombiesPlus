package net.trial.zombies_plus.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.client.modelRenderer;
import net.trial.zombies_plus.entity.custom.abstractZombieEntity;
import net.trial.zombies_plus.entity.custom.axeZombieEntity;
import net.trial.zombies_plus.entity.custom.bowZombieEntity;
import net.trial.zombies_plus.entity.custom.bruteZombieEntity;
import net.trial.zombies_plus.entity.custom.crawlerZombieEntity;
import net.trial.zombies_plus.entity.custom.crossbowZombieEntity;
import net.trial.zombies_plus.entity.custom.runnerZombieEntity;
import net.trial.zombies_plus.entity.custom.shriekerZombieEntity;
import net.trial.zombies_plus.item.modCreativeTab;
import net.trial.zombies_plus.item.modItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(modMainCommon.MOD_ID)
public class modMain {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = modMainCommon.MOD_ID;
    // Directly reference a slf4j logger
    /* private static final Logger LOGGER = LogUtils.getLogger(); */
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public modMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(modMainCommon.MOD_ID, modEventBus);

        //modEntities.ENTITY_TYPES.register();
        //modItems.ITEMS.register();

        modMainCommon.init();

        //modCreativeModeTabs.register(modEventBus);

        //modItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        //modEventBus.addListener(this::addCreative);
    //}
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        modMainCommon.LOGGER.info("Loaded mod!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Misgiving.MOD_ID, modSurfaceRules.makeRules());
            registerZombieSpawn(modEntities.RUNNER_ZOMBIE.get(), runnerZombieEntity::checkMonsterSpawnRules);
            registerZombieSpawn(modEntities.BRUTE_ZOMBIE.get(), bruteZombieEntity::checkMonsterSpawnRules);
            registerZombieSpawn(modEntities.CRAWLER_ZOMBIE.get(), crawlerZombieEntity::checkMonsterSpawnRules);
            registerZombieSpawn(modEntities.CROSSBOW_ZOMBIE.get(), crossbowZombieEntity::checkMonsterSpawnRules);
            registerZombieSpawn(modEntities.BOW_ZOMBIE.get(), bowZombieEntity::checkMonsterSpawnRules);
            registerZombieSpawn(modEntities.SHRIEKER_ZOMBIE.get(), shriekerZombieEntity::checkMonsterSpawnRules);
            registerZombieSpawn(modEntities.AXE_ZOMBIE.get(), axeZombieEntity::checkMonsterSpawnRules);
        });
    }

    @SuppressWarnings("deprecation")
    private <T extends abstractZombieEntity> void registerZombieSpawn(EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> monsterSpawnRules) {
    SpawnPlacements.register(entityType, SpawnPlacements.Type.ON_GROUND, 
        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, monsterSpawnRules);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(modEntities.RUNNER_ZOMBIE.get(), modelRenderer.runnerZombieModelRenderer::new);
            EntityRenderers.register(modEntities.BRUTE_ZOMBIE.get(), modelRenderer.bruteZombieModelRenderer::new);
            EntityRenderers.register(modEntities.CRAWLER_ZOMBIE.get(), modelRenderer.crawlerZombieModelRenderer::new);     
            EntityRenderers.register(modEntities.CROSSBOW_ZOMBIE.get(), modelRenderer.crossbowZombieModelRenderer::new);    
            EntityRenderers.register(modEntities.BOW_ZOMBIE.get(), modelRenderer.bowZombieModelRenderer::new);
            EntityRenderers.register(modEntities.SHRIEKER_ZOMBIE.get(), modelRenderer.shriekerZombieModelRenderer::new);
            EntityRenderers.register(modEntities.AXE_ZOMBIE.get(), modelRenderer.axeZombieModelRenderer::new);
            }
    }
}
