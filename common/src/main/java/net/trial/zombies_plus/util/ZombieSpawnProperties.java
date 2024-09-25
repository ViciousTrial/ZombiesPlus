package net.trial.zombies_plus.util;

public enum ZombieSpawnProperties {


    runnerZombie(40, 4, 4),
    bruteZombie(10, 4, 4),
    crawlerZombie(15, 4, 4),
    crossbowZombie(35, 4, 4),
    bowZombie(35, 4, 4),
    shriekerZombie(3, 4, 4),
    axeZombie(15, 4, 4),
    swordZombie(15, 4, 4),
    weakZombie(10, 4, 4),
    slowZombie(7, 4, 4),
    vileZombie(15, 4, 4),
    caveZombie(30, 4, 4),
    leaperZombie(10,4,4);

    // Spawn properties
    private final int spawnWeight;
    private final int minGroupSize;
    private final int maxGroupSize;

    /**
     * Constructor for ZombieSpawnProperties enum.
     *
     * @param spawnWeight  The weight of the spawn probability.
     * @param minGroupSize The minimum group size for spawning.
     * @param maxGroupSize The maximum group size for spawning.
     */
    ZombieSpawnProperties(int spawnWeight, int minGroupSize, int maxGroupSize) {
        this.spawnWeight = spawnWeight;
        this.minGroupSize = minGroupSize;
        this.maxGroupSize = maxGroupSize;
    }

    // Getter methods for the spawn properties

    /**
     * Gets the spawn weight for the zombie type.
     *
     * @return The spawn weight.
     */
    public int getSpawnWeight() {
        return spawnWeight;
    }

    /**
     * Gets the minimum group size for spawning.
     *
     * @return The minimum group size.
     */
    public int getMinGroupSize() {
        return minGroupSize;
    }

    /**
     * Gets the maximum group size for spawning.
     *
     * @return The maximum group size.
     */
    public int getMaxGroupSize() {
        return maxGroupSize;
    }
}
