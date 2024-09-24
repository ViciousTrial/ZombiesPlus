package net.trial.zombies_plus;

import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.sound.ModSounds;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.trial.zombies_plus.item.ModCreativeTab;
import net.trial.zombies_plus.item.ModItems;
import net.trial.zombies_plus.util.ModConfig;
import net.trial.zombies_plus.world.gen.EntitySpawn;

public final class ModMainCommon {
    public static final String MOD_ID = "zombies_plus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ModConfig modConfigInstance = null;

    public static void init() {
        ModSounds.SOUNDS.register();
        ModEntities.ENTITY_TYPES.register();
        ModItems.ITEMS.register();
        ModCreativeTab.TABS.register();

        // use .addForgeSpawns() in modEventBus for forge

        // modConfig.loadConfig();

        // Config epicness
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        modConfigInstance = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        EntitySpawn.addFabricSpawns();
    }

}
