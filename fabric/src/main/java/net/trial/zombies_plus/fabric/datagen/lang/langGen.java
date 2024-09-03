package net.trial.zombies_plus.fabric.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.item.modItems;

public class langGen extends FabricLanguageProvider {

    public langGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(modItems.BRUTE_ZOMBIE_SPAWN_EGG.get(), "Brute Zombie Spawn Egg");
        translationBuilder.add(modItems.RUNNER_ZOMBIE_SPAWN_EGG.get(), "Runner Zombie Spawn Egg");
        translationBuilder.add(modItems.CRAWLER_ZOMBIE_SPAWN_EGG.get(), "Crawler Zombie Spawn Egg");
        translationBuilder.add(modItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get(), "Crossbow Zombie Spawn Egg");
        translationBuilder.add(modItems.BOW_ZOMBIE_SPAWN_EGG.get(), "Bow Zombie Spawn Egg");
        translationBuilder.add(modItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get(), "Shrieker Zombie Spawn Egg");
        translationBuilder.add(modItems.AXE_ZOMBIE_SPAWN_EGG.get(), "Axe Zombie Spawn Egg");

        translationBuilder.add("category.zombies_plus_tab", "Zombies+");
    
        translationBuilder.add(modEntities.BRUTE_ZOMBIE.get(), "Brute Zombie");
        translationBuilder.add(modEntities.RUNNER_ZOMBIE.get(), "Runner Zombie");
        translationBuilder.add(modEntities.CRAWLER_ZOMBIE.get(), "Crawler Zombie");
        translationBuilder.add(modEntities.CROSSBOW_ZOMBIE.get(), "Crossbow Zombie");
        translationBuilder.add(modEntities.BOW_ZOMBIE.get(), "Bow Zombie");
        translationBuilder.add(modEntities.SHRIEKER_ZOMBIE.get(), "Shrieker Zombie");
        translationBuilder.add(modEntities.AXE_ZOMBIE.get(), "Axe Zombie");
    }

}
