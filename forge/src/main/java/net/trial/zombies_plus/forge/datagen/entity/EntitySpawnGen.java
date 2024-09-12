package net.trial.zombies_plus.forge.datagen.entity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.forge.datagen.custom.EntitySpawnDataProvider;
import net.trial.zombies_plus.util.ZombieSpawnProperties;

public class EntitySpawnGen extends EntitySpawnDataProvider {

     public EntitySpawnGen(PackOutput pOutput, String modId) {
          super(pOutput, modId);
     }

     @Override
     protected void generateSpawns(CachedOutput cache, List<CompletableFuture<?>> entry) {

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.AXE_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.axeZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.RUNNER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.runnerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.BRUTE_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.bruteZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.CRAWLER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.crawlerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.BOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.bowZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.CROSSBOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.crossbowZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.SHRIEKER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.shriekerSpawnZombieProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    modEntities.SWORD_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.swordZombieProperties));

     }

     private CompletableFuture<?> createConfigBasedSpawnData(CachedOutput cache, ResourceLocation entityId,
               Object biomes, ZombieSpawnProperties.baseSpawnPropertiesConfig spawnProperties) {
          return createBasicSpawnData(cache, entityId, biomes, spawnProperties.spawnWeight,
                    spawnProperties.minGroupSize, spawnProperties.maxGroupSize);
     }

}
