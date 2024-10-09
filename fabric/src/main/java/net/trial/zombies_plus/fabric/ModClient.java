package net.trial.zombies_plus.fabric;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.entity.client.ModModelLayers;
import net.trial.zombies_plus.entity.client.ModModelRenderer;
import net.trial.zombies_plus.entity.client.models.BruteZombieModel;
import net.trial.zombies_plus.entity.client.models.CrawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.ShriekerZombieModel;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        renderEntities();
    }

    private void renderEntities() {
        EntityRendererRegistry.register(ModEntities.RUNNER_ZOMBIE, ModModelRenderer.RunnerZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.BRUTE_ZOMBIE, ModModelRenderer.BruteZombieRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BRUTE_ZOMBIE_LAYER, BruteZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.CRAWLER_ZOMBIE, ModModelRenderer.CrawlerZombieRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRAWLER_ZOMBIE_LAYER, CrawlerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.CROSSBOW_ZOMBIE, ModModelRenderer.CrossbowZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOW_ZOMBIE, ModModelRenderer.BowZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHRIEKER_ZOMBIE, ModModelRenderer.ShriekerZombieRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHRIEKER_ZOMBIE_LAYER, ShriekerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.AXE_ZOMBIE, ModModelRenderer.AxeZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.SWORD_ZOMBIE, ModModelRenderer.SwordZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.WEAK_ZOMBIE, ModModelRenderer.WeakZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.SLOW_ZOMBIE, ModModelRenderer.SlowZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.VILE_ZOMBIE, ModModelRenderer.VileZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.CAVE_ZOMBIE, ModModelRenderer.CaveZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.LEAPER_ZOMBIE, ModModelRenderer.LeaperZombieRenderer::new);
    }
}