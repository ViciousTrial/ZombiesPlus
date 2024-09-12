package net.trial.zombies_plus.entity.ai;

import net.trial.zombies_plus.ModMainCommon;
import org.joml.Random;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.trial.zombies_plus.entity.modEntities;
import net.trial.zombies_plus.entity.custom.AxeZombieEntity;
import net.trial.zombies_plus.entity.custom.BowZombieEntity;
import net.trial.zombies_plus.entity.custom.BruteZombieEntity;
import net.trial.zombies_plus.entity.custom.CrawlerZombieEntity;
import net.trial.zombies_plus.entity.custom.CrossbowZombieEntity;
import net.trial.zombies_plus.entity.custom.RunnerZombieEntity;
import net.trial.zombies_plus.entity.custom.ShriekerZombieEntity;

public class ShriekerZombieAttackGoal extends ZombieAttackGoal {

    private boolean isShrieking = false;
    private int shriekCooldown = 1200;
    private int speedCooldown = 100;
    private int cooldownTimer = 1200;
    private Zombie currentZombie;

    public ShriekerZombieAttackGoal(Zombie pZombie, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pZombie, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.currentZombie = pZombie;
    }

    @Override
    public void start() {
        if (!isShrieking && cooldownTimer >= shriekCooldown) {
            isShrieking = true;
            cooldownTimer = 0;
            ShriekerZombieEntity bludZombie = (ShriekerZombieEntity) this.currentZombie;
            bludZombie.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK);
            summonReinforcements();
            bludZombie.startShriekAnimation();
        }
        super.start();
    }

    @Override
    public void tick() {
        if (isShrieking) {
            if (cooldownTimer < speedCooldown) {
                cooldownTimer++;
                this.currentZombie.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
            } else {
                ShriekerZombieEntity bludZombie = (ShriekerZombieEntity) this.currentZombie;

                isShrieking = false;
                bludZombie.stopShriekAnimation();
                this.currentZombie.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
                bludZombie.shriekAnimationTimeout = 0;

            }
        } else {
            if (cooldownTimer < shriekCooldown) {
                cooldownTimer++;
            }
        }
        super.tick();
    }

    private int minDistance = 48;
    private int maxDistance = 64;

    private Entity returnZombie(Level world) {
        Entity chosen;
        int randomNum = RandomSource.create().nextInt(6) + 1;

        switch (randomNum) {
            case 1:
                chosen = new AxeZombieEntity(modEntities.AXE_ZOMBIE.get(), world);
                break;
            case 2:
                chosen = new BowZombieEntity(modEntities.BOW_ZOMBIE.get(), world);
                break;
            case 3:
                chosen = new CrossbowZombieEntity(modEntities.CROSSBOW_ZOMBIE.get(), world);
                break;
            case 4:
                chosen = new CrawlerZombieEntity(modEntities.CRAWLER_ZOMBIE.get(), world);
                break;
            case 5:
                chosen = new BruteZombieEntity(modEntities.BRUTE_ZOMBIE.get(), world);
                break;
            case 6:
                chosen = new RunnerZombieEntity(modEntities.RUNNER_ZOMBIE.get(), world);
                break;
            default:
                chosen = new RunnerZombieEntity(modEntities.RUNNER_ZOMBIE.get(), world);
                break;
        }

        return chosen;
    }

    private void summonReinforcements() {
        Level world = this.currentZombie.level();
        if (world != null && !world.isClientSide) {

            AABB area = this.currentZombie.getBoundingBox()
                    .inflate(ModMainCommon.modConfigInstance.shriekerZombieRange);

            java.util.List<Zombie> nearbyZombies = world.getEntitiesOfClass(Zombie.class, area, zombie -> true);

            ModMainCommon.LOGGER.info("Number of nearby zombies: " + nearbyZombies.size());

            for (Zombie zombie : nearbyZombies) {
                ModMainCommon.LOGGER.info("Moving zombie: " + zombie);
                zombie.setTarget(this.currentZombie.getTarget());
                zombie.getNavigation().moveTo(this.currentZombie, 1.2);
            }

            RandomSource randomSource = RandomSource.create();
            /*
             * var tagManager = Registries.ENTITY_TYPE.tags();
             * var horde_zombies_tag = modTags.EntityTag.HORDE_ZOMBIES;
             * var tag = tagManager.getTag(horde_zombies_tag);
             */

            int integerNumber = 7;

            for (int i = 0; i < new Random().nextInt(integerNumber) + 1; i++) { // Adjust the number of reinforcements

                // var chosenZombie = tag.getRandomElement(randomSource);
                // EntityType<?> zombieType = returnZombie(world);

                Entity reinforcement = returnZombie(world);
                // modMainCommon.LOGGER.info("created zobie");

                if (reinforcement != null) {

                    int randomDistance = minDistance + randomSource.nextInt(maxDistance - minDistance + 1);
                    int randomDistance2 = minDistance + randomSource.nextInt(maxDistance - minDistance + 1);

                    randomDistance = Mth.floor(randomDistance / 2.5);
                    randomDistance2 = Mth.floor(randomDistance2 / 2.5);

                    Zombie reinforcementBehaviour = (Zombie) reinforcement;

                    reinforcementBehaviour.setTarget(currentZombie.getTarget());
                    reinforcementBehaviour.getNavigation().moveTo(this.currentZombie, 1.2);

                    double baseX = this.currentZombie.getX() + randomDistance;
                    double baseY = this.currentZombie.getY();
                    double baseZ = this.currentZombie.getZ() + randomDistance2;

                    boolean positionFound = false;

                    for (int attempt = 0; attempt < 10; attempt++) {
                        double checkX = baseX + (randomSource.nextDouble() - 0.5) * 2;
                        double checkY = baseY;
                        double checkZ = baseZ + (randomSource.nextDouble() - 0.5) * 2;

                        if (world.noCollision(reinforcement,
                                reinforcement.getBoundingBox().move(checkX, checkY, checkZ))) {
                            reinforcement.moveTo(checkX, checkY, checkZ);
                            world.addFreshEntity(reinforcement);
                            positionFound = true;
                            break;
                        }
                    }
                    if (positionFound) {
                        // modMainCommon.LOGGER.info("fresh entity");
                    }
                }
            }
        }
    }

}
