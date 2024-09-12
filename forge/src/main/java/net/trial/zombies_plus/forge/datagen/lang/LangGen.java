package net.trial.zombies_plus.forge.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.forge.ModMain;
import net.trial.zombies_plus.item.ModItems;

public class LangGen extends LanguageProvider {

    public LangGen(PackOutput output, String modid, String locale) {
        super(output, ModMain.MOD_ID, locale);
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
        addEntityType(() -> modEntities.SWORD_ZOMBIE.get(), "Sword Zombie");

        add("category.zombies_plus_tab", "Zombies+");

        addItem(() -> ModItems.BRUTE_ZOMBIE_SPAWN_EGG.get(), "Brute Zombie Spawn Egg");
        addItem(() -> ModItems.RUNNER_ZOMBIE_SPAWN_EGG.get(), "Runner Zombie Spawn Egg");
        addItem(() -> ModItems.CRAWLER_ZOMBIE_SPAWN_EGG.get(), "Crawler Zombie Spawn Egg");
        addItem(() -> ModItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get(), "Crossbow Zombie Spawn Egg");
        addItem(() -> ModItems.BOW_ZOMBIE_SPAWN_EGG.get(), "Bow Zombie Spawn Egg");
        addItem(() -> ModItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get(), "Shrieker Zombie Spawn Egg");
        addItem(() -> ModItems.AXE_ZOMBIE_SPAWN_EGG.get(), "Axe Zombie Spawn Egg");
        addItem(() -> ModItems.SWORD_ZOMBIE_SPAWN_EGG.get(), "Sword Zombie Spawn Egg");
    }

}
