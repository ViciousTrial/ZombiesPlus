package net.trial.zombies_plus.forge.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.client.ModelLayers;
import net.trial.zombies_plus.entity.client.models.BruteZombieModel;
import net.trial.zombies_plus.entity.client.models.CrawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.ShriekerZombieModel;

@Mod.EventBusSubscriber(modid = ModMainCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClient {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModelLayers.BRUTE_ZOMBIE_LAYER, BruteZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayers.CRAWLER_ZOMBIE_LAYER, CrawlerZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayers.SHRIEKER_ZOMBIE_LAYER, ShriekerZombieModel::createBodyLayer);
    }
}
