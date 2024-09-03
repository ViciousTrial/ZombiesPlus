package net.trial.zombies_plus.forge.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.custom.bowZombieEntity;
import net.trial.zombies_plus.entity.custom.bruteZombieEntity;
import net.trial.zombies_plus.entity.custom.crawlerZombieEntity;
import net.trial.zombies_plus.entity.custom.crossbowZombieEntity;
import net.trial.zombies_plus.entity.custom.runnerZombieEntity;
import net.trial.zombies_plus.entity.custom.shriekerZombieEntity;

@Mod.EventBusSubscriber(modid = modMainCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class modEventBus {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(modEntities.RUNNER_ZOMBIE.get(), runnerZombieEntity.createAttributes().build());
        event.put(modEntities.BRUTE_ZOMBIE.get(), bruteZombieEntity.createAttributes().build());
        event.put(modEntities.CRAWLER_ZOMBIE.get(), crawlerZombieEntity.createAttributes().build());
        event.put(modEntities.CROSSBOW_ZOMBIE.get(), crossbowZombieEntity.createAttributes().build());
        event.put(modEntities.BOW_ZOMBIE.get(), bowZombieEntity.createAttributes().build());
        event.put(modEntities.SHRIEKER_ZOMBIE.get(), shriekerZombieEntity.createAttributes().build());
        event.put(modEntities.AXE_ZOMBIE.get(), shriekerZombieEntity.createAttributes().build());
    }
}
