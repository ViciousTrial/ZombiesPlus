package net.trial.zombies_plus.forge.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.entity.client.modelLayers;
import net.trial.zombies_plus.entity.client.models.bruteZombieModel;
import net.trial.zombies_plus.entity.client.models.crawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.shriekerZombieModel;

@Mod.EventBusSubscriber(modid = modMainCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class modEventBusClient {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(modelLayers.BRUTE_ZOMBIE_LAYER, bruteZombieModel::createBodyLayer);
        event.registerLayerDefinition(modelLayers.CRAWLER_ZOMBIE_LAYER, crawlerZombieModel::createBodyLayer);
        event.registerLayerDefinition(modelLayers.SHRIEKER_ZOMBIE_LAYER, shriekerZombieModel::createBodyLayer);
    }
}
