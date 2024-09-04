package net.trial.zombies_plus.forge.event;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
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
import net.trial.zombies_plus.world.gen.entitySpawn;

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


    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
        for (EntityType<? extends Monster> entityType : entitySpawn.addForgeSpawns()) {
            registerForgeSpawn(event, entityType, Monster::checkMonsterSpawnRules);
        }
    }

    private static <T extends Monster> void registerForgeSpawn(SpawnPlacementRegisterEvent event, EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        event.register(entityType, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
