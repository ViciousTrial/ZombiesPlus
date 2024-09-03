package net.trial.zombies_plus.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.trial.zombies_plus.modMainCommon;

public class modCreativeTab {
     public static final DeferredRegister<CreativeModeTab> TABS =
          DeferredRegister.create(modMainCommon.MOD_ID, Registries.CREATIVE_MODE_TAB);
     
     public static final RegistrySupplier<CreativeModeTab> ZOMBIES_PLUS_TAB = TABS.register(
          "zombies_plus_tab", // Tab ID
          () -> CreativeTabRegistry.create(
                    Component.translatable("category.zombies_plus_tab"), // Tab Name
                    () -> new ItemStack(modItems.RUNNER_ZOMBIE_SPAWN_EGG.get()) // Icon
          )
     );
}
