package net.trial.zombies_plus.fabric.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.trial.zombies_plus.entity.modEntities;
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

        translationBuilder.add("category.zombies_plus_tab", "Zombies+");
    
        translationBuilder.add(modEntities.BRUTE_ZOMBIE.get(), "Brute Zombie");
        translationBuilder.add(modEntities.RUNNER_ZOMBIE.get(), "Runner Zombie");
        translationBuilder.add(modEntities.CRAWLER_ZOMBIE.get(), "Crawler Zombie");
        translationBuilder.add(modEntities.CROSSBOW_ZOMBIE.get(), "Crossbow Zombie");
        translationBuilder.add(modEntities.BOW_ZOMBIE.get(), "Bow Zombie");
        translationBuilder.add(modEntities.SHRIEKER_ZOMBIE.get(), "Shrieker Zombie");
        translationBuilder.add(modEntities.AXE_ZOMBIE.get(), "Axe Zombie");
        translationBuilder.add(modEntities.SWORD_ZOMBIE.get(), "Sword Zombie");
    }

}
