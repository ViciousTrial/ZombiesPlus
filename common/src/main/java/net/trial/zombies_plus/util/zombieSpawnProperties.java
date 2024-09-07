package net.trial.zombies_plus.util;

public interface zombieSpawnProperties {
     public static class baseSpawnPropertiesConfig {
          public int spawnWeight = 15;
          public int minGroupSize = 4;
          public int maxGroupSize = 4;
     }

     public baseSpawnPropertiesConfig runnerZombieSpawnProperties = new runnerZombieSpawnPropertiesEnum();

     static class runnerZombieSpawnPropertiesEnum extends baseSpawnPropertiesConfig {
          public runnerZombieSpawnPropertiesEnum(){
               this.spawnWeight = 40;
          }
     };

     public baseSpawnPropertiesConfig bruteZombieSpawnProperties = new bruteZombiePropertiesEnum();

     static class bruteZombiePropertiesEnum extends baseSpawnPropertiesConfig {
          public bruteZombiePropertiesEnum() {
               this.spawnWeight = 10;
          }
     }

     public baseSpawnPropertiesConfig crawlerZombieSpawnProperties = new baseSpawnPropertiesConfig();
     public baseSpawnPropertiesConfig crossbowZombieSpawnProperties = new crossbowZombiePropertiesEnum();

     static class crossbowZombiePropertiesEnum extends baseSpawnPropertiesConfig {
          public crossbowZombiePropertiesEnum() {
          this.spawnWeight = 35;
          }
     }

     public baseSpawnPropertiesConfig bowZombieSpawnProperties = new crossbowZombiePropertiesEnum();

     public baseSpawnPropertiesConfig shriekerSpawnZombieProperties = new shriekerZombiePropertiesEnum();

     static class shriekerZombiePropertiesEnum extends baseSpawnPropertiesConfig {
          public shriekerZombiePropertiesEnum() {
               this.spawnWeight = 3;
          }
     }

     public baseSpawnPropertiesConfig axeZombieSpawnProperties = new baseSpawnPropertiesConfig();
}
