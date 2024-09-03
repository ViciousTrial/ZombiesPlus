package net.trial.zombies_plus.fabric;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.client.modelLayers;
import net.trial.zombies_plus.entity.client.modelRenderer;
import net.trial.zombies_plus.entity.client.models.bruteZombieModel;
import net.trial.zombies_plus.entity.client.models.crawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.shriekerZombieModel;

public class modClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(modEntities.RUNNER_ZOMBIE, modelRenderer.runnerZombieModelRenderer::new);
        EntityRendererRegistry.register(modEntities.BRUTE_ZOMBIE, modelRenderer.bruteZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(modelLayers.BRUTE_ZOMBIE_LAYER, bruteZombieModel::createBodyLayer);

        EntityRendererRegistry.register(modEntities.CRAWLER_ZOMBIE, modelRenderer.crawlerZombieModelRenderer::new);     
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(modelLayers.CRAWLER_ZOMBIE_LAYER, crawlerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(modEntities.CROSSBOW_ZOMBIE, modelRenderer.crossbowZombieModelRenderer::new);    
        EntityRendererRegistry.register(modEntities.BOW_ZOMBIE, modelRenderer.bowZombieModelRenderer::new);
        EntityRendererRegistry.register(modEntities.SHRIEKER_ZOMBIE, modelRenderer.shriekerZombieModelRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(modelLayers.SHRIEKER_ZOMBIE_LAYER, shriekerZombieModel::createBodyLayer);

        EntityRendererRegistry.register(modEntities.AXE_ZOMBIE, modelRenderer.axeZombieModelRenderer::new);
    }
}