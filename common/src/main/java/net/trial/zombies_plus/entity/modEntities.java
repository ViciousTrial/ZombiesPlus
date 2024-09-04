package net.trial.zombies_plus.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.entity.custom.axeZombieEntity;
import net.trial.zombies_plus.entity.custom.bowZombieEntity;
import net.trial.zombies_plus.entity.custom.bruteZombieEntity;
import net.trial.zombies_plus.entity.custom.crawlerZombieEntity;
import net.trial.zombies_plus.entity.custom.crossbowZombieEntity;
import net.trial.zombies_plus.entity.custom.runnerZombieEntity;
import net.trial.zombies_plus.entity.custom.shriekerZombieEntity;

public class modEntities {
        public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(modMainCommon.MOD_ID,
                        Registries.ENTITY_TYPE);

        public static final RegistrySupplier<EntityType<runnerZombieEntity>> RUNNER_ZOMBIE = ENTITY_TYPES.register(
                        "runner_zombie", () -> EntityType.Builder.of(runnerZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("runner_zombie"));

        public static final RegistrySupplier<EntityType<bruteZombieEntity>> BRUTE_ZOMBIE = ENTITY_TYPES.register(
                        "brute_zombie", () -> EntityType.Builder.of(bruteZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("brute_zombie"));

        public static final RegistrySupplier<EntityType<crawlerZombieEntity>> CRAWLER_ZOMBIE = ENTITY_TYPES.register(
                        "crawler_zombie", () -> EntityType.Builder.of(crawlerZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("crawler_zombie"));

        public static final RegistrySupplier<EntityType<crossbowZombieEntity>> CROSSBOW_ZOMBIE = ENTITY_TYPES.register(
                        "crossbow_zombie", () -> EntityType.Builder.of(crossbowZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("crossbow_zombie"));

        public static final RegistrySupplier<EntityType<bowZombieEntity>> BOW_ZOMBIE = ENTITY_TYPES
                        .register("bow_zombie", () -> EntityType.Builder.of(bowZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("bow_zombie"));

        public static final RegistrySupplier<EntityType<shriekerZombieEntity>> SHRIEKER_ZOMBIE = ENTITY_TYPES.register(
                        "shrieker_zombie", () -> EntityType.Builder.of(shriekerZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("shrieker_zombie"));

        public static final RegistrySupplier<EntityType<axeZombieEntity>> AXE_ZOMBIE = ENTITY_TYPES
                        .register("axe_zombie", () -> EntityType.Builder.of(axeZombieEntity::new, MobCategory.MONSTER)
                                        .sized(1f, 1f).build("axe_zombie"));
}
