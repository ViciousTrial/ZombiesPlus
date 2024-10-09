package net.trial.zombies_plus.forge.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.client.ModModelLayers;
import net.trial.zombies_plus.entity.client.models.BruteZombieModel;
import net.trial.zombies_plus.entity.client.models.CrawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.ShriekerZombieModel;

@Mod.EventBusSubscriber(modid = ModMainCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClient {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.BRUTE_ZOMBIE_LAYER, BruteZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CRAWLER_ZOMBIE_LAYER, CrawlerZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SHRIEKER_ZOMBIE_LAYER, ShriekerZombieModel::createBodyLayer);
    }
}
