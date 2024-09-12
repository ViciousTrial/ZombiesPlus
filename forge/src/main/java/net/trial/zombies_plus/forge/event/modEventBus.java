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
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.custom.*;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.world.gen.EntitySpawn;

@Mod.EventBusSubscriber(modid = ModMainCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBus {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(modEntities.RUNNER_ZOMBIE.get(), RunnerZombieEntity.createAttributes().build());
        event.put(modEntities.BRUTE_ZOMBIE.get(), BruteZombieEntity.createAttributes().build());
        event.put(modEntities.CRAWLER_ZOMBIE.get(), CrawlerZombieEntity.createAttributes().build());
        event.put(modEntities.CROSSBOW_ZOMBIE.get(), CrossbowZombieEntity.createAttributes().build());
        event.put(modEntities.BOW_ZOMBIE.get(), BowZombieEntity.createAttributes().build());
        event.put(modEntities.SHRIEKER_ZOMBIE.get(), ShriekerZombieEntity.createAttributes().build());
        event.put(modEntities.AXE_ZOMBIE.get(), AxeZombieEntity.createAttributes().build());
        event.put(modEntities.SWORD_ZOMBIE.get(), SwordZombieEntity.createAttributes().build());
    }


    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
        for (EntityType<? extends Monster> entityType : EntitySpawn.addForgeSpawns()) {
            registerForgeSpawn(event, entityType, Monster::checkMonsterSpawnRules);
        }
    }

    private static <T extends Monster> void registerForgeSpawn(SpawnPlacementRegisterEvent event, EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        event.register(entityType, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
