package net.trial.zombies_plus.item;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.entity.ModEntities;

public class ModItems {
        // public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(()
        // -> RegistrarManager.get(modMainCommon.MOD_ID));

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ModMainCommon.MOD_ID,
                        Registries.ITEM);

        public static final RegistrySupplier<Item> RUNNER_ZOMBIE_SPAWN_EGG = ITEMS.register("runner_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.RUNNER_ZOMBIE, 0x4D3236, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> BRUTE_ZOMBIE_SPAWN_EGG = ITEMS.register("brute_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.BRUTE_ZOMBIE, 0x73593D, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> CRAWLER_ZOMBIE_SPAWN_EGG = ITEMS.register("crawler_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.CRAWLER_ZOMBIE, 0x354652, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> CROSSBOW_ZOMBIE_SPAWN_EGG = ITEMS.register(
                        "crossbow_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.CROSSBOW_ZOMBIE, 0x4A4A4A, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> BOW_ZOMBIE_SPAWN_EGG = ITEMS.register("bow_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.BOW_ZOMBIE, 0x5C5822, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> SHRIEKER_ZOMBIE_SPAWN_EGG = ITEMS.register("shrieker_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.SHRIEKER_ZOMBIE, 0x00776D, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> AXE_ZOMBIE_SPAWN_EGG = ITEMS.register("axe_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.AXE_ZOMBIE, 0x7E009E, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> SWORD_ZOMBIE_SPAWN_EGG = ITEMS.register("sword_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.SWORD_ZOMBIE, 0x6D1B1F, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

        public static final RegistrySupplier<Item> WEAK_ZOMBIE_SPAWN_EGG = ITEMS.register("weak_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.WEAK_ZOMBIE, 0x416E6E, 0x43543D,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));
         public static final RegistrySupplier<Item> SLOW_ZOMBIE_SPAWN_EGG = ITEMS.register("slow_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.SLOW_ZOMBIE, 0x25274A, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));
         public static final RegistrySupplier<Item> VILE_ZOMBIE_SPAWN_EGG = ITEMS.register("vile_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.VILE_ZOMBIE, 0x2AA87D, 0x234F47,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));
         public static final RegistrySupplier<Item> CAVE_ZOMBIE_SPAWN_EGG = ITEMS.register("cave_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.CAVE_ZOMBIE, 0x626262, 0xDBDBDB,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

         public static final RegistrySupplier<Item> LEAPER_ZOMBIE_SPAWN_EGG = ITEMS.register("leaper_zombie_spawn_egg",
                        () -> new ArchitecturySpawnEggItem(ModEntities.LEAPER_ZOMBIE, 0x3E2945, 0x5009705,
                                        new Item.Properties().arch$tab(ModCreativeTab.ZOMBIES_PLUS_TAB)));

}
