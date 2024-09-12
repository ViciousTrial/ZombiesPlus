package net.trial.zombies_plus.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.custom.*;

public class modEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ModMainCommon.MOD_ID,
            Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<RunnerZombieEntity>> RUNNER_ZOMBIE = ENTITY_TYPES.register(
            "runner_zombie", () -> EntityType.Builder.of(RunnerZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("runner_zombie"));

    public static final RegistrySupplier<EntityType<BruteZombieEntity>> BRUTE_ZOMBIE = ENTITY_TYPES.register(
            "brute_zombie", () -> EntityType.Builder.of(BruteZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("brute_zombie"));

    public static final RegistrySupplier<EntityType<CrawlerZombieEntity>> CRAWLER_ZOMBIE = ENTITY_TYPES.register(
            "crawler_zombie", () -> EntityType.Builder.of(CrawlerZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("crawler_zombie"));

    public static final RegistrySupplier<EntityType<CrossbowZombieEntity>> CROSSBOW_ZOMBIE = ENTITY_TYPES.register(
            "crossbow_zombie", () -> EntityType.Builder.of(CrossbowZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("crossbow_zombie"));

    public static final RegistrySupplier<EntityType<BowZombieEntity>> BOW_ZOMBIE = ENTITY_TYPES
            .register("bow_zombie", () -> EntityType.Builder.of(BowZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("bow_zombie"));

    public static final RegistrySupplier<EntityType<ShriekerZombieEntity>> SHRIEKER_ZOMBIE = ENTITY_TYPES.register(
            "shrieker_zombie", () -> EntityType.Builder.of(ShriekerZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("shrieker_zombie"));

    public static final RegistrySupplier<EntityType<AxeZombieEntity>> AXE_ZOMBIE = ENTITY_TYPES
            .register("axe_zombie", () -> EntityType.Builder.of(AxeZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("axe_zombie"));

    public static final RegistrySupplier<EntityType<SwordZombieEntity>> SWORD_ZOMBIE = ENTITY_TYPES
            .register("sword_zombie", () -> EntityType.Builder.of(SwordZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("sword_zombie"));
}
