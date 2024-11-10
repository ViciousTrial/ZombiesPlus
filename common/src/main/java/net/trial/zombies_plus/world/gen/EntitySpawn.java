package net.trial.zombies_plus.world.gen;

import dev.architectury.platform.Platform;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.entity.custom.AbstractZombieEntity;
import net.trial.zombies_plus.entity.custom.CaveZombieEntity;
import net.trial.zombies_plus.entity.custom.LeaperZombieEntity;
import net.trial.zombies_plus.util.ModConfig;
import net.trial.zombies_plus.util.ZombieSpawnProperties;

import java.util.ArrayList;
import java.util.List;

public class EntitySpawn {
    public static void addFabricSpawns() {
        if (Platform.isFabric()) {
            registerEntitySpawnWithConfig(
                    ModEntities.RUNNER_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.runner_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.BRUTE_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.brute_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.AXE_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.axe_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.CRAWLER_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.crawler_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.CROSSBOW_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.crossbow_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.BOW_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.bow_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.SHRIEKER_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.shrieker_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.SWORD_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.sword_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.WEAK_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.weak_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.SLOW_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.slow_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.VILE_ZOMBIE.get(),
                    AbstractZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.vile_zombie,
                    ConventionalBiomeTags.SWAMP);

            registerEntitySpawnWithConfig(
                    ModEntities.CAVE_ZOMBIE.get(),
                    CaveZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.cave_zombie);

            registerEntitySpawnWithConfig(
                    ModEntities.LEAPER_ZOMBIE.get(),
                    LeaperZombieEntity::checkEntitySpawnRules,
                    ZombieSpawnProperties.leaper_zombie);
        }
    }

//    private static <T extends Mob> void registerEntitySpawnWithConfig(EntityType<T> entityType,
//                                                                      SpawnPlacements.SpawnPredicate<T> spawnPredicate, ZombieSpawnProperties spawnProperties) {
//        registerFabricSpawn(entityType, spawnPredicate, spawnProperties.getSpawnWeight(), spawnProperties.getMinGroupSize(),
//                spawnProperties.getMaxGroupSize());
//    }
//
//    private static <T extends Mob> void registerEntitySpawnWithConfig(EntityType<T> entityType,
//                                                                      SpawnPlacements.SpawnPredicate<T> spawnPredicate, ZombieSpawnProperties spawnProperties, TagKey<Biome> biomes) {
//        registerFabricSpawnWithBiomeTag(entityType, spawnPredicate, spawnProperties.getSpawnWeight(), spawnProperties.getMinGroupSize(),
//                spawnProperties.getMaxGroupSize(), biomes);
//    }

    private static <T extends Mob> void registerEntitySpawnWithConfig(EntityType<T> entityType,
                                                                      SpawnPlacements.SpawnPredicate<T> spawnPredicate,
                                                                      ZombieSpawnProperties spawnProperty) {
        ModConfig.ZombieSpawnConfig spawnConfig = ModMainCommon.modConfigInstance.zombieSpawnProperties.stream()
                .filter(zsp -> zsp.zombieType.equalsIgnoreCase(spawnProperty.name()))
                .findFirst()
                .orElseGet(() -> new ModConfig.ZombieSpawnConfig(
                        spawnProperty.name(),
                        spawnProperty.getSpawnWeight(),
                        spawnProperty.getMinGroupSize(),
                        spawnProperty.getMaxGroupSize()
                ));
        registerFabricSpawn(entityType, spawnPredicate, spawnConfig.spawnWeight, spawnConfig.minGroupSize,
                spawnConfig.maxGroupSize);
    }

    private static <T extends Mob> void registerEntitySpawnWithConfig(EntityType<T> entityType,
                                                                                         SpawnPlacements.SpawnPredicate<T> spawnPredicate,
                                                                                         ZombieSpawnProperties spawnProperty,
                                                                                         TagKey<Biome> biomes) {
        ModConfig.ZombieSpawnConfig spawnConfig = ModMainCommon.modConfigInstance.zombieSpawnProperties.stream()
                .filter(zsp -> zsp.zombieType.equalsIgnoreCase(spawnProperty.name()))
                .findFirst()
                .orElseGet(() -> new ModConfig.ZombieSpawnConfig(
                        spawnProperty.name(),
                        spawnProperty.getSpawnWeight(),
                        spawnProperty.getMinGroupSize(),
                        spawnProperty.getMaxGroupSize()
                ));
        registerFabricSpawnWithBiomeTag(entityType, spawnPredicate, spawnConfig.spawnWeight, spawnConfig.minGroupSize,
                spawnConfig.maxGroupSize, biomes);
    }

    private static <T extends Mob> void registerFabricSpawn(EntityType<T> entityType,
                                                            SpawnPlacements.SpawnPredicate<T> spawnPredicate, int weight, int minGroupSize, int maxGroupSize) {
        registerFabricSpawnWithBiomeTag(entityType, spawnPredicate, weight, minGroupSize, maxGroupSize, BiomeTags.IS_OVERWORLD);
    }

    private static <T extends Mob> void registerFabricSpawnWithBiomeTag(EntityType<T> entityType,
                                                                        SpawnPlacements.SpawnPredicate<T> spawnPredicate, int weight, int minGroupSize, int maxGroupSize, TagKey<Biome> biomeTag) {
        BiomeModifications.addSpawn(BiomeSelectors.tag(biomeTag), MobCategory.MONSTER, entityType,
                weight, minGroupSize, maxGroupSize);
        SpawnPlacements.register(entityType, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate);
    }


    public static List<EntityType<? extends Monster>> addForgeSpawns() {
        List<EntityType<? extends Monster>> entities = new ArrayList<>();
        entities.add(ModEntities.RUNNER_ZOMBIE.get());
        entities.add(ModEntities.BRUTE_ZOMBIE.get());
        entities.add(ModEntities.AXE_ZOMBIE.get());
        entities.add(ModEntities.CRAWLER_ZOMBIE.get());
        entities.add(ModEntities.CROSSBOW_ZOMBIE.get());
        entities.add(ModEntities.BOW_ZOMBIE.get());
        entities.add(ModEntities.SHRIEKER_ZOMBIE.get());
        entities.add(ModEntities.SWORD_ZOMBIE.get());
        entities.add(ModEntities.SLOW_ZOMBIE.get());
        entities.add(ModEntities.VILE_ZOMBIE.get());
        entities.add(ModEntities.CAVE_ZOMBIE.get());

        return entities;

        // Dont forget to add the json file for it on forge resources.
    }
}
