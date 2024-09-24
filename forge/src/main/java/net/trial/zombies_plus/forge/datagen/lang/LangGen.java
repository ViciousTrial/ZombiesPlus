package net.trial.zombies_plus.forge.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.forge.ModMain;
import net.trial.zombies_plus.item.ModItems;

public class LangGen extends LanguageProvider {

    public LangGen(PackOutput output, String modid, String locale) {
        super(output, ModMain.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addEntityType(() -> ModEntities.BRUTE_ZOMBIE.get(), "Brute Zombie");
        addEntityType(() -> ModEntities.RUNNER_ZOMBIE.get(), "Runner Zombie");
        addEntityType(() -> ModEntities.CRAWLER_ZOMBIE.get(), "Crawler Zombie");
        addEntityType(() -> ModEntities.CROSSBOW_ZOMBIE.get(), "Crossbow Zombie");
        addEntityType(() -> ModEntities.BOW_ZOMBIE.get(), "Bow Zombie");
        addEntityType(() -> ModEntities.SHRIEKER_ZOMBIE.get(), "Shrieker Zombie");
        addEntityType(() -> ModEntities.AXE_ZOMBIE.get(), "Axe Zombie");
        addEntityType(() -> ModEntities.SWORD_ZOMBIE.get(), "Sword Zombie");
        addEntityType(() -> ModEntities.WEAK_ZOMBIE.get(), "Weak Zombie");
        addEntityType(() -> ModEntities.SLOW_ZOMBIE.get(), "Slow Zombie");
        addEntityType(() -> ModEntities.VILE_ZOMBIE.get(), "Vile Zombie");
        addEntityType(() -> ModEntities.CAVE_ZOMBIE.get(), "Cave Zombie");


        add("category.zombies_plus_tab", "Zombies+");
        add("sound.zombies_plus.cave_zombie_yell", "Cave Zombie Screams");

        addItem(() -> ModItems.BRUTE_ZOMBIE_SPAWN_EGG.get(), "Brute Zombie Spawn Egg");
        addItem(() -> ModItems.RUNNER_ZOMBIE_SPAWN_EGG.get(), "Runner Zombie Spawn Egg");
        addItem(() -> ModItems.CRAWLER_ZOMBIE_SPAWN_EGG.get(), "Crawler Zombie Spawn Egg");
        addItem(() -> ModItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get(), "Crossbow Zombie Spawn Egg");
        addItem(() -> ModItems.BOW_ZOMBIE_SPAWN_EGG.get(), "Bow Zombie Spawn Egg");
        addItem(() -> ModItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get(), "Shrieker Zombie Spawn Egg");
        addItem(() -> ModItems.AXE_ZOMBIE_SPAWN_EGG.get(), "Axe Zombie Spawn Egg");
        addItem(() -> ModItems.SWORD_ZOMBIE_SPAWN_EGG.get(), "Sword Zombie Spawn Egg");
        addItem(() -> ModItems.WEAK_ZOMBIE_SPAWN_EGG.get(), "Weak Zombie Spawn Egg");
        addItem(() -> ModItems.SLOW_ZOMBIE_SPAWN_EGG.get(), "Slow Zombie Spawn Egg");
        addItem(() -> ModItems.VILE_ZOMBIE_SPAWN_EGG.get(), "Vile Zombie Spawn Egg");
        addItem(() -> ModItems.CAVE_ZOMBIE_SPAWN_EGG.get(), "Cave Zombie Spawn Egg");

    }

}
