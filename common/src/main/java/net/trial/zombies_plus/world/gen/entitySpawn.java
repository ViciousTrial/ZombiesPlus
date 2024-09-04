package net.trial.zombies_plus.world.gen;

import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.Subscribe;

import dev.architectury.event.Event;
import dev.architectury.platform.Platform;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.custom.abstractZombieEntity;

public class entitySpawn {
     public static void addFabricSpawns() {
          if (Platform.isFabric()) {
               registerFabricSpawn(modEntities.RUNNER_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 40, 4, 4);
               registerFabricSpawn(modEntities.BRUTE_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 10, 4, 4);
               registerFabricSpawn(modEntities.AXE_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 15, 4, 4);
               registerFabricSpawn(modEntities.CRAWLER_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 15, 4, 4);
               registerFabricSpawn(modEntities.CROSSBOW_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 35, 4, 4);
               registerFabricSpawn(modEntities.BOW_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 35, 4, 4);
               registerFabricSpawn(modEntities.SHRIEKER_ZOMBIE.get(), abstractZombieEntity::checkMonsterSpawnRules, 3, 4, 4);

          }
     }

     private static <T extends Mob> void registerFabricSpawn(EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> spawnPredicate, int weight, int minGroupSize, int maxGroupSize) {
          BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), MobCategory.MONSTER, entityType, weight, minGroupSize, maxGroupSize);
          SpawnPlacements.register(entityType, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate);
     }

     public static List<EntityType<? extends Monster>> addForgeSpawns() {
          List<EntityType<? extends Monster>> entities = new ArrayList<>();
          entities.add(modEntities.RUNNER_ZOMBIE.get());
          entities.add(modEntities.BRUTE_ZOMBIE.get());
          entities.add(modEntities.AXE_ZOMBIE.get());
          entities.add(modEntities.CRAWLER_ZOMBIE.get());
          entities.add(modEntities.CROSSBOW_ZOMBIE.get());
          entities.add(modEntities.BOW_ZOMBIE.get());
          entities.add(modEntities.SHRIEKER_ZOMBIE.get());

          return entities;

          // Dont forget to add the json file for it on forge resources.
     }    
}
