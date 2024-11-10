package net.trial.zombies_plus.util;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.trial.zombies_plus.ModMainCommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Comment("Configure spawn properties for each zombie type.")
    public List<ZombieSpawnConfig> zombieSpawnProperties;

    public ModConfig() {
        zombieSpawnProperties = new ArrayList<>();
    }

    public static class ZombieSpawnConfig {

        @Comment("The type of zombie.")
        public String zombieType;

        @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
        @Comment("Spawn weight determines the probability of this zombie type spawning. Range: 1 - 1000")
        public int spawnWeight;

        @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
        @Comment("Minimum number of zombies in a spawn group. Range: 1 - 1000. Advised to keep it less than maxGroupSize.")
        public int minGroupSize;

        @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
        @Comment("Maximum number of zombies in a spawn group. Range: 1 - 1000")
        public int maxGroupSize;

        public ZombieSpawnConfig() {

        }

        public ZombieSpawnConfig(String zombieType, int spawnWeight, int minGroupSize, int maxGroupSize) {
            this.zombieType = zombieType;
            this.spawnWeight = spawnWeight;
            this.minGroupSize = minGroupSize;
            this.maxGroupSize = maxGroupSize;
        }


        public boolean isValid() {
            return minGroupSize <= maxGroupSize;
        }
    }

    @Override
    public void validatePostLoad() {
        if (zombieSpawnProperties == null || zombieSpawnProperties.isEmpty()) {
            zombieSpawnProperties = Arrays.stream(ZombieSpawnProperties.values())
                    .map(zsp -> new ZombieSpawnConfig(
                            zsp.name(),
                            zsp.getSpawnWeight(),
                            zsp.getMinGroupSize(),
                            zsp.getMaxGroupSize()))
                    .collect(Collectors.toList());
        }

        for (ZombieSpawnConfig config : zombieSpawnProperties) {
            if (!config.isValid()) {
                config.minGroupSize = Math.min(config.minGroupSize, config.maxGroupSize);
            }
        }
    }
}
