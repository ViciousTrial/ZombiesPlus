package net.trial.zombies_plus.fabric.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.trial.zombies_plus.entity.ModEntities;
import net.trial.zombies_plus.item.ModItems;

public class LangGen extends FabricLanguageProvider {

    public LangGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BRUTE_ZOMBIE_SPAWN_EGG.get(), "Brute Zombie Spawn Egg");
        translationBuilder.add(ModItems.RUNNER_ZOMBIE_SPAWN_EGG.get(), "Runner Zombie Spawn Egg");
        translationBuilder.add(ModItems.CRAWLER_ZOMBIE_SPAWN_EGG.get(), "Crawler Zombie Spawn Egg");
        translationBuilder.add(ModItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get(), "Crossbow Zombie Spawn Egg");
        translationBuilder.add(ModItems.BOW_ZOMBIE_SPAWN_EGG.get(), "Bow Zombie Spawn Egg");
        translationBuilder.add(ModItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get(), "Shrieker Zombie Spawn Egg");
        translationBuilder.add(ModItems.AXE_ZOMBIE_SPAWN_EGG.get(), "Axe Zombie Spawn Egg");
        translationBuilder.add(ModItems.SWORD_ZOMBIE_SPAWN_EGG.get(), "Sword Zombie Spawn Egg");
        translationBuilder.add(ModItems.WEAK_ZOMBIE_SPAWN_EGG.get(), "Weak Zombie Spawn Egg");
        translationBuilder.add(ModItems.SLOW_ZOMBIE_SPAWN_EGG.get(), "Slow Zombie Spawn Egg");
        translationBuilder.add(ModItems.VILE_ZOMBIE_SPAWN_EGG.get(), "Vile Zombie Spawn Egg");
        translationBuilder.add(ModItems.CAVE_ZOMBIE_SPAWN_EGG.get(), "Cave Zombie Spawn Egg");


        translationBuilder.add("category.zombies_plus_tab", "Zombies+");
        translationBuilder.add("sound.zombies_plus.cave_zombie_yell", "Cave Zombie Screams");

    
        translationBuilder.add(ModEntities.BRUTE_ZOMBIE.get(), "Brute Zombie");
        translationBuilder.add(ModEntities.RUNNER_ZOMBIE.get(), "Runner Zombie");
        translationBuilder.add(ModEntities.CRAWLER_ZOMBIE.get(), "Crawler Zombie");
        translationBuilder.add(ModEntities.CROSSBOW_ZOMBIE.get(), "Crossbow Zombie");
        translationBuilder.add(ModEntities.BOW_ZOMBIE.get(), "Bow Zombie");
        translationBuilder.add(ModEntities.SHRIEKER_ZOMBIE.get(), "Shrieker Zombie");
        translationBuilder.add(ModEntities.AXE_ZOMBIE.get(), "Axe Zombie");
        translationBuilder.add(ModEntities.SWORD_ZOMBIE.get(), "Sword Zombie");
        translationBuilder.add(ModEntities.WEAK_ZOMBIE.get(), "Weak Zombie");
        translationBuilder.add(ModEntities.SLOW_ZOMBIE.get(), "Slow Zombie");
        translationBuilder.add(ModEntities.VILE_ZOMBIE.get(), "Vile Zombie");
        translationBuilder.add(ModEntities.CAVE_ZOMBIE.get(), "Cave Zombie");

    }

}
