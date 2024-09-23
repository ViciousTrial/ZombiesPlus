package net.trial.zombies_plus.fabric;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.entity.client.ModelLayers;
import net.trial.zombies_plus.entity.client.ModelRenderer;
import net.trial.zombies_plus.entity.client.models.BruteZombieModel;
import net.trial.zombies_plus.entity.client.models.CrawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.ShriekerZombieModel;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        renderEntities();
    }

    private void renderEntities() {
        EntityRendererRegistry.register(ModEntities.RUNNER_ZOMBIE, ModelRenderer.runnerZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.BRUTE_ZOMBIE, ModelRenderer.bruteZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModelLayers.BRUTE_ZOMBIE_LAYER, BruteZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.CRAWLER_ZOMBIE, ModelRenderer.crawlerZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModelLayers.CRAWLER_ZOMBIE_LAYER, CrawlerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.CROSSBOW_ZOMBIE, ModelRenderer.crossbowZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOW_ZOMBIE, ModelRenderer.bowZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHRIEKER_ZOMBIE, ModelRenderer.shriekerZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModelLayers.SHRIEKER_ZOMBIE_LAYER, ShriekerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.AXE_ZOMBIE, ModelRenderer.axeZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.SWORD_ZOMBIE, ModelRenderer.swordZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.WEAK_ZOMBIE, ModelRenderer.weakZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.SLOW_ZOMBIE, ModelRenderer.slowZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.VILE_ZOMBIE, ModelRenderer.vileZombieModelRenderer::new);
        EntityRendererRegistry.register(ModEntities.CAVE_ZOMBIE, ModelRenderer.caveZombieModelRenderer::new);
    }
}