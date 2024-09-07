package net.trial.zombies_plus.forge.datagen.entity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.forge.datagen.custom.EntitySpawnDataProvider;
import net.trial.zombies_plus.util.zombieSpawnProperties;

public class entitySpawnGen extends EntitySpawnDataProvider {

     public entitySpawnGen(PackOutput pOutput, String modId) {
          super(pOutput, modId);
     }

     @Override
     protected void generateSpawns(CachedOutput cache, List<CompletableFuture<?>> entry) {

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.AXE_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.axeZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.RUNNER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.runnerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.BRUTE_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.bruteZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.CRAWLER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.crawlerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.BOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.bowZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.CROSSBOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.crossbowZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.SHRIEKER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    zombieSpawnProperties.shriekerSpawnZombieProperties));

     }

     private CompletableFuture<?> createConfigBasedSpawnData(CachedOutput cache, ResourceLocation entityId,
               Object biomes, zombieSpawnProperties.baseSpawnPropertiesConfig spawnProperties) {
          return createBasicSpawnData(cache, entityId, biomes, spawnProperties.spawnWeight,
                    spawnProperties.minGroupSize, spawnProperties.maxGroupSize);
     }

}
