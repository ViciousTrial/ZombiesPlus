package net.trial.zombies_plus.forge.datagen.entity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeBiomeTagsProvider;
import net.trial.zombies_plus.entity.ModEntities;
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
                    ModEntities.AXE_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.axeZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.RUNNER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.runnerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.BRUTE_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.bruteZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.CRAWLER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.crawlerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.BOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.bowZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.CROSSBOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.crossbowZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.SHRIEKER_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.shriekerZombieSpawnProperties));

          entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.SWORD_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.swordZombieSpawnProperties));

           entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.WEAK_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.weakZombieSpawnProperties));

           entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.SLOW_ZOMBIE.getId(),
                    BiomeTags.IS_OVERWORLD,
                    ZombieSpawnProperties.slowZombieSpawnProperties));

           entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.VILE_ZOMBIE.getId(),
                    Tags.Biomes.IS_SWAMP,
                    ZombieSpawnProperties.slowZombieSpawnProperties));

           entry.add(createConfigBasedSpawnData(
                    cache,
                    ModEntities.CAVE_ZOMBIE.getId(),
                    Tags.Biomes.IS_CAVE,
                    ZombieSpawnProperties.caveZombieSpawnProperties));

     }

     private CompletableFuture<?> createConfigBasedSpawnData(CachedOutput cache, ResourceLocation entityId,
               Object biomes, ZombieSpawnProperties.baseSpawnPropertiesConfig spawnProperties) {
          return createBasicSpawnData(cache, entityId, biomes, spawnProperties.spawnWeight,
                    spawnProperties.minGroupSize, spawnProperties.maxGroupSize);
     }

}
