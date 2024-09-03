package net.trial.zombies_plus.forge.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.forge.modMain;
import net.trial.zombies_plus.item.modItems;

public class langGen extends LanguageProvider {

    public langGen(PackOutput output, String modid, String locale) {
        super(output, modMain.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addEntityType(() -> modEntities.BRUTE_ZOMBIE.get(), "Brute Zombie");
        addEntityType(() -> modEntities.RUNNER_ZOMBIE.get(), "Runner Zombie");
        addEntityType(() -> modEntities.CRAWLER_ZOMBIE.get(), "Crawler Zombie");
        addEntityType(() -> modEntities.CROSSBOW_ZOMBIE.get(), "Crossbow Zombie");
        addEntityType(() -> modEntities.BOW_ZOMBIE.get(), "Bow Zombie");
        addEntityType(() -> modEntities.SHRIEKER_ZOMBIE.get(), "Shrieker Zombie");
        addEntityType(() -> modEntities.AXE_ZOMBIE.get(), "Axe Zombie");

        add("category.zombies_plus_tab", "Zombies+");

        addItem(() -> modItems.BRUTE_ZOMBIE_SPAWN_EGG.get(), "Brute Zombie Spawn Egg");
        addItem(() -> modItems.RUNNER_ZOMBIE_SPAWN_EGG.get(), "Runner Zombie Spawn Egg");
        addItem(() -> modItems.CRAWLER_ZOMBIE_SPAWN_EGG.get(), "Crawler Zombie Spawn Egg");
        addItem(() -> modItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get(), "Crossbow Zombie Spawn Egg");
        addItem(() -> modItems.BOW_ZOMBIE_SPAWN_EGG.get(), "Bow Zombie Spawn Egg");
        addItem(() -> modItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get(), "Shrieker Zombie Spawn Egg");
        addItem(() -> modItems.AXE_ZOMBIE_SPAWN_EGG.get(), "Axe Zombie Spawn Egg");
    }

}
