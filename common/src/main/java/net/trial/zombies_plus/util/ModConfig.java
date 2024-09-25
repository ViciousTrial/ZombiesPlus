package net.trial.zombies_plus.util;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.trial.zombies_plus.ModMainCommon;

@Config(name = ModMainCommon.MOD_ID)
public class ModConfig implements ConfigData {

     @Comment("Use another resource pack for zombie textures? NOTE: Does not work for Brutes.")
     public boolean zombieTextureOverride = false;

     @Comment("Add details for Tissou Zombie Resource Pack? NOTE: Adds realistic zombie textures for Brutes and Cave Zombies only. Install the mod 'Entity Texture Features' for emissive eye textures. For other zombies, install Tissou's pack and set 'Zombie Texture Override' to true.")
     public boolean tissouZombiePackDetails = false;

     @Comment("Use better animations for zombies? Animations similar to Fresh Animations. NOTE: Applies to Brutes, Shriekers, and Crawlers only. For every other zombie, install 'Fresh Animations' resource-pack. If installed, Fresh Animations will override zombie animations.")
     public boolean useBetterAnimations = false;

     @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
     @Comment("The range in which a Shrieker Zombie will alert other zombies. Has a min of 1 and a max of 1000")
     public int shriekerZombieRange = 225;

     // public static class baseSpawnPropertiesConfig {
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
     //      public int spawnWeight = 15;
     
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
     //      public int minGroupSize = 4;
     
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
     //      public int maxGroupSize = 4;
     // }

     // @Comment("########################")

     // @ConfigEntry.Category("runner_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig runnerZombieSpawnProperties = new runnerZombieSpawnPropertiesEnum();

     // static class runnerZombieSpawnPropertiesEnum extends baseSpawnPropertiesConfig {
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
     //      public int spawnWeight = 40;
     // };

     // @ConfigEntry.Category("brute_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig bruteZombieSpawnProperties = new bruteZombiePropertiesEnum();

     // static class bruteZombiePropertiesEnum extends baseSpawnPropertiesConfig {
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
     //      public int spawnWeight = 10;
     // };

     // @ConfigEntry.Category("crawler_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig crawlerZombieSpawnProperties = new baseSpawnPropertiesConfig();

     // @ConfigEntry.Category("crossbow_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig crossbowZombieSpawnProperties = new crossbowZombiePropertiesEnum();

     // static class crossbowZombiePropertiesEnum extends baseSpawnPropertiesConfig {
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
     //      public int spawnWeight = 35;
     // };

     // @ConfigEntry.Category("bow_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig bowZombieSpawnProperties = new crossbowZombiePropertiesEnum();

     // @ConfigEntry.Category("shrieker_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig shriekerSpawnZombieProperties = new shriekerZombiePropertiesEnum();

     // static class shriekerZombiePropertiesEnum extends baseSpawnPropertiesConfig {
     //      @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
     //      public int spawnWeight = 3;
     // };


     // @ConfigEntry.Category("axe_zombie_spawn_properties")
     // public baseSpawnPropertiesConfig axeZombieSpawnProperties = new baseSpawnPropertiesConfig();

}
