package net.trial.zombies_plus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.item.modCreativeTab;
import net.trial.zombies_plus.item.modItems;
import net.trial.zombies_plus.util.modConfig;
import net.trial.zombies_plus.world.gen.entitySpawn;

public final class modMainCommon {
    public static final String MOD_ID = "zombies_plus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static modConfig modConfigInstance = null;

    public static void init() {
        modEntities.ENTITY_TYPES.register();
        modItems.ITEMS.register();
        modCreativeTab.TABS.register();

        // use .addForgeSpawns() in modEventBus for forge

        // modConfig.loadConfig();

        // Config epicness
        AutoConfig.register(modConfig.class, JanksonConfigSerializer::new);
        modConfigInstance = AutoConfig.getConfigHolder(modConfig.class).getConfig();

        entitySpawn.addFabricSpawns();
    }

}
