package net.trial.zombies_plus.fabric;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.client.ModelLayers;
import net.trial.zombies_plus.entity.client.ModelRenderer;
import net.trial.zombies_plus.entity.client.models.BruteZombieModel;
import net.trial.zombies_plus.entity.client.models.CrawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.ShriekerZombieModel;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(modEntities.RUNNER_ZOMBIE, ModelRenderer.runnerZombieModelRenderer::new);
        EntityRendererRegistry.register(modEntities.BRUTE_ZOMBIE, ModelRenderer.bruteZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModelLayers.BRUTE_ZOMBIE_LAYER, BruteZombieModel::createBodyLayer);

        EntityRendererRegistry.register(modEntities.CRAWLER_ZOMBIE, ModelRenderer.crawlerZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModelLayers.CRAWLER_ZOMBIE_LAYER, CrawlerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(modEntities.CROSSBOW_ZOMBIE, ModelRenderer.crossbowZombieModelRenderer::new);
        EntityRendererRegistry.register(modEntities.BOW_ZOMBIE, ModelRenderer.bowZombieModelRenderer::new);
        EntityRendererRegistry.register(modEntities.SHRIEKER_ZOMBIE, ModelRenderer.shriekerZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(ModelLayers.SHRIEKER_ZOMBIE_LAYER, ShriekerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(modEntities.AXE_ZOMBIE, ModelRenderer.axeZombieModelRenderer::new);
        EntityRendererRegistry.register(modEntities.SWORD_ZOMBIE, ModelRenderer.swordZombieModelRenderer::new);
    }
}