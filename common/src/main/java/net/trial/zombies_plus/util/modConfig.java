package net.trial.zombies_plus.util;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.trial.zombies_plus.modMainCommon;

@Config(name = modMainCommon.MOD_ID)
public class modConfig implements ConfigData {


     @Comment("Use another resource pack for zombie textures? NOTE: Does not work for Brutes.")
     public boolean zombieTextureOverride = false;

     @Comment("Add details for Tissou Zombie Resource Pack? NOTE: Adds realistic zombie textures for Brutes only. Install the mod 'Entity Texture Features' for emissive eye textures. For other zombies, install Tissou's pack and set 'Zombie Texture Override' to true.")
     public boolean tissouZombiePackDetails = false;

     @Comment("Use better animations for zombies? Animations similar to Fresh Animations. NOTE: Applies to Brutes, Shriekers, and Crawlers only. For every other zombie, install 'Fresh Animations' resource-pack. If installed, Fresh Animations will override zombie animations.")
     public boolean useBetterAnimations = false;

     @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
     @Comment("The range in which a Shrieker Zombie will alert other zombies. Has a min of 1 and a max of 1000")
     public int shriekerZombieRange = 225;
}
