package net.trial.zombies_plus.util;

public enum ZombieSpawnProperties {


    runner_zombie(40, 4, 4),
    brute_zombie(10, 4, 4),
    crawler_zombie(15, 4, 4),
    crossbow_zombie(35, 4, 4),
    bow_zombie(35, 4, 4),
    shrieker_zombie(3, 4, 4),
    axe_zombie(15, 4, 4),
    sword_zombie(15, 4, 4),
    weak_zombie(10, 4, 4),
    slow_zombie(7, 4, 4),
    vile_zombie(40, 4, 4),
    cave_zombie(30, 4, 4),
    leaper_zombie(10,4,4);

    private final int spawnWeight;
    private final int minGroupSize;
    private final int maxGroupSize;


    ZombieSpawnProperties(int spawnWeight, int minGroupSize, int maxGroupSize) {
        this.spawnWeight = spawnWeight;
        this.minGroupSize = minGroupSize;
        this.maxGroupSize = maxGroupSize;
    }



    public int getSpawnWeight() {
        return spawnWeight;
    }

    public int getMinGroupSize() {
        return minGroupSize;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }
}
