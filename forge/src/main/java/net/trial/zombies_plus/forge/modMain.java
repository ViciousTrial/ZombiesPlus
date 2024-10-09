package net.trial.zombies_plus.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.entity.client.ModModelRenderer;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModMainCommon.MOD_ID)
public class ModMain {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = ModMainCommon.MOD_ID;
    // Directly reference a slf4j logger
    /* private static final Logger LOGGER = LogUtils.getLogger(); */
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public ModMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(ModMainCommon.MOD_ID, modEventBus);
        ModMainCommon.init();


        //modEntities.ENTITY_TYPES.register();
        //modItems.ITEMS.register();


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
        ModMainCommon.LOGGER.info("Loaded mod!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // event.enqueueWork(() -> {
        //     //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Misgiving.MOD_ID, modSurfaceRules.makeRules());
        //     registerZombieSpawn(modEntities.RUNNER_ZOMBIE.get(), runnerZombieEntity::checkMonsterSpawnRules);
        //     registerZombieSpawn(modEntities.BRUTE_ZOMBIE.get(), bruteZombieEntity::checkMonsterSpawnRules);
        //     registerZombieSpawn(modEntities.CRAWLER_ZOMBIE.get(), crawlerZombieEntity::checkMonsterSpawnRules);
        //     registerZombieSpawn(modEntities.CROSSBOW_ZOMBIE.get(), crossbowZombieEntity::checkMonsterSpawnRules);
        //     registerZombieSpawn(modEntities.BOW_ZOMBIE.get(), bowZombieEntity::checkMonsterSpawnRules);
        //     registerZombieSpawn(modEntities.SHRIEKER_ZOMBIE.get(), shriekerZombieEntity::checkMonsterSpawnRules);
        //     registerZombieSpawn(modEntities.AXE_ZOMBIE.get(), axeZombieEntity::checkMonsterSpawnRules);
        // });
    }

    // @SuppressWarnings("deprecation")
    // private <T extends abstractZombieEntity> void registerZombieSpawn(EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> monsterSpawnRules) {
    // SpawnPlacements.register(entityType, SpawnPlacements.Type.ON_GROUND, 
    //     Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, monsterSpawnRules);
    // }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            renderEntities();
        }
    }

    private static void renderEntities() {
        EntityRenderers.register(ModEntities.RUNNER_ZOMBIE.get(), ModModelRenderer.RunnerZombieRenderer::new);
        EntityRenderers.register(ModEntities.BRUTE_ZOMBIE.get(), ModModelRenderer.BruteZombieRenderer::new);
        EntityRenderers.register(ModEntities.CRAWLER_ZOMBIE.get(), ModModelRenderer.CrawlerZombieRenderer::new);
        EntityRenderers.register(ModEntities.CROSSBOW_ZOMBIE.get(), ModModelRenderer.CrossbowZombieRenderer::new);
        EntityRenderers.register(ModEntities.BOW_ZOMBIE.get(), ModModelRenderer.BowZombieRenderer::new);
        EntityRenderers.register(ModEntities.SHRIEKER_ZOMBIE.get(), ModModelRenderer.ShriekerZombieRenderer::new);
        EntityRenderers.register(ModEntities.AXE_ZOMBIE.get(), ModModelRenderer.AxeZombieRenderer::new);
        EntityRenderers.register(ModEntities.SWORD_ZOMBIE.get(), ModModelRenderer.SwordZombieRenderer::new);
        EntityRenderers.register(ModEntities.WEAK_ZOMBIE.get(), ModModelRenderer.WeakZombieRenderer::new);
        EntityRenderers.register(ModEntities.SLOW_ZOMBIE.get(), ModModelRenderer.SlowZombieRenderer::new);
        EntityRenderers.register(ModEntities.VILE_ZOMBIE.get(), ModModelRenderer.VileZombieRenderer::new);
        EntityRenderers.register(ModEntities.CAVE_ZOMBIE.get(), ModModelRenderer.CaveZombieRenderer::new);
        EntityRenderers.register(ModEntities.LEAPER_ZOMBIE.get(), ModModelRenderer.LeaperZombieRenderer::new);
    }
}
