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
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.entity.custom.*;
import net.trial.zombies_plus.world.gen.EntitySpawn;

@Mod.EventBusSubscriber(modid = ModMainCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBus {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        createEntityAttributes(event);
    }

    private static void createEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RUNNER_ZOMBIE.get(), RunnerZombieEntity.createAttributes().build());
        event.put(ModEntities.BRUTE_ZOMBIE.get(), BruteZombieEntity.createAttributes().build());
        event.put(ModEntities.CRAWLER_ZOMBIE.get(), CrawlerZombieEntity.createAttributes().build());
        event.put(ModEntities.CROSSBOW_ZOMBIE.get(), CrossbowZombieEntity.createAttributes().build());
        event.put(ModEntities.BOW_ZOMBIE.get(), BowZombieEntity.createAttributes().build());
        event.put(ModEntities.SHRIEKER_ZOMBIE.get(), ShriekerZombieEntity.createAttributes().build());
        event.put(ModEntities.AXE_ZOMBIE.get(), AxeZombieEntity.createAttributes().build());
        event.put(ModEntities.SWORD_ZOMBIE.get(), SwordZombieEntity.createAttributes().build());
        event.put(ModEntities.WEAK_ZOMBIE.get(), WeakZombieEntity.createAttributes().build());
        event.put(ModEntities.SLOW_ZOMBIE.get(), SlowZombieEntity.createAttributes().build());
        event.put(ModEntities.VILE_ZOMBIE.get(), VileZombieEntity.createAttributes().build());
        event.put(ModEntities.CAVE_ZOMBIE.get(), CaveZombieEntity.createAttributes().build());
        event.put(ModEntities.LEAPER_ZOMBIE.get(), LeaperZombieEntity.createAttributes().build());
    }


    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
        for (EntityType<? extends Monster> entityType : EntitySpawn.addForgeSpawns()) {
           if (entityType.equals(ModEntities.CAVE_ZOMBIE.get())){
               ModMainCommon.LOGGER.info("Registering special spawn rules for Cave Zombie");
               registerForgeSpawn(event, entityType, CaveZombieEntity::checkEntitySpawnRules);
           }else{
               registerForgeSpawn(event, entityType, AbstractZombieEntity::checkEntitySpawnRules);
           }
        }
    }

    private static <T extends Monster> void registerForgeSpawn(SpawnPlacementRegisterEvent event, EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        event.register(entityType, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
