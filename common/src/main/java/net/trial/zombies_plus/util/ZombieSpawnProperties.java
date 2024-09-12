package net.trial.zombies_plus.util;

public interface ZombieSpawnProperties {
     class baseSpawnPropertiesConfig {
          public int spawnWeight = 15;
          public int minGroupSize = 4;
          public int maxGroupSize = 4;
     }

     baseSpawnPropertiesConfig runnerZombieSpawnProperties = new runnerZombieSpawnPropertiesEnum();

     class runnerZombieSpawnPropertiesEnum extends baseSpawnPropertiesConfig {
          public runnerZombieSpawnPropertiesEnum(){
               this.spawnWeight = 40;
          }
     }

    baseSpawnPropertiesConfig bruteZombieSpawnProperties = new bruteZombiePropertiesEnum();

     class bruteZombiePropertiesEnum extends baseSpawnPropertiesConfig {
          public bruteZombiePropertiesEnum() {
               this.spawnWeight = 10;
          }
     }

     baseSpawnPropertiesConfig crawlerZombieSpawnProperties = new baseSpawnPropertiesConfig();
     baseSpawnPropertiesConfig crossbowZombieSpawnProperties = new crossbowZombiePropertiesEnum();

     class crossbowZombiePropertiesEnum extends baseSpawnPropertiesConfig {
          public crossbowZombiePropertiesEnum() {
          this.spawnWeight = 35;
          }
     }

     baseSpawnPropertiesConfig bowZombieSpawnProperties = new crossbowZombiePropertiesEnum();

     baseSpawnPropertiesConfig shriekerSpawnZombieProperties = new shriekerZombiePropertiesEnum();

     class shriekerZombiePropertiesEnum extends baseSpawnPropertiesConfig {
          public shriekerZombiePropertiesEnum() {
               this.spawnWeight = 3;
          }
     }

     baseSpawnPropertiesConfig axeZombieSpawnProperties = new baseSpawnPropertiesConfig();
     baseSpawnPropertiesConfig swordZombieProperties = new baseSpawnPropertiesConfig();
}
