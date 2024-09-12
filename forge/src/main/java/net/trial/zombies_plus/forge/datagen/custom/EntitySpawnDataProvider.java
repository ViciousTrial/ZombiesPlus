package net.trial.zombies_plus.forge.datagen.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.trial.zombies_plus.ModMainCommon;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class EntitySpawnDataProvider implements DataProvider {

     private final List<CompletableFuture<?>> spawnFutures = new ArrayList<>();

     private final PackOutput output;
     private final String modid;
     // private final CompletableFuture<Provider> provider;
     // private final ExistingFileHelper fileHelper;

     public EntitySpawnDataProvider(PackOutput pOutput, String modId) {
          this.output = pOutput;
          this.modid = modId;
          // this.provider = pProvider;
          // this.fileHelper = existingFileHelper;
     }

     protected abstract void generateSpawns(CachedOutput cache, List<CompletableFuture<?>> entry);

     @Override
     public CompletableFuture<?> run(CachedOutput cache) {
          generateSpawns(cache, spawnFutures);

          return CompletableFuture.allOf(spawnFutures.toArray(new CompletableFuture[0]));
     }

     public CompletableFuture<?> createBasicSpawnData(CachedOutput cache, ResourceLocation entityIdRaw, Object biomes,
               int weight,
               int minCount,
               int maxCount) {

          String entityId = entityIdRaw.toString();

          JsonArray spawnableBiomes = new JsonArray();
          String spawnableBiomeTag;


          if (biomes instanceof List<?> biomesList) {
               spawnableBiomeTag = null;
               for (Object biome : biomesList) {
                    if (biome instanceof ResourceKey<?> resourceKey && resourceKey.isFor(Registries.BIOME)) {
                         @SuppressWarnings("unchecked")
                         ResourceKey<Biome> biomeResource = (ResourceKey<Biome>) resourceKey; // singular biome
                         spawnableBiomes.add(biomeResource.location().toString());
                    } else {
                         throw new IllegalArgumentException(
                                   "Invalid type in biome list: " + biome.getClass().getName());
                    }
               }
          } else if (biomes instanceof TagKey<?> tagKey && tagKey.isFor(Registries.BIOME)) {
               @SuppressWarnings("unchecked")
               TagKey<Biome> biomeTag = (TagKey<Biome>) tagKey; // biome tag
               spawnableBiomes = null;
               spawnableBiomeTag = "#" + biomeTag.location().toString();
          } else {
               throw new IllegalArgumentException("Invalid type for biomesOrTag: " + biomes.getClass().getName());
          }

          JsonObject spawnRulesJson = new JsonObject();
          spawnRulesJson.addProperty("type", "forge:add_spawns");
          if (spawnableBiomes != null){
               spawnRulesJson.add("biomes", spawnableBiomes);
          }else{
               spawnRulesJson.addProperty("biomes", spawnableBiomeTag);
          }

          JsonObject spawners = new JsonObject();
          spawners.addProperty("type", entityId);
          spawners.addProperty("maxCount", maxCount);
          spawners.addProperty("minCount", minCount);
          spawners.addProperty("weight", weight);

          spawnRulesJson.add("spawners", spawners);

          String entityName = entityId.substring(entityId.indexOf(':') + 1); // separate mod_id and axe_zombie
          
          String fileName = "spawn_" + entityName; // construct filename


          Path outputPath2 = this.output.getOutputFolder(PackOutput.Target.DATA_PACK).resolve(this.modid)
                    .resolve("forge").resolve("biome_modifier").resolve(fileName + ".json");

          try {
               return DataProvider.saveStable(cache, spawnRulesJson, outputPath2);
          } catch (Exception e) {
               ModMainCommon.LOGGER.info("Failed to create new spawn file.json!");
               throw new RuntimeException("Failed to save entity spawn rule file: " + outputPath2, e);
          }
     }

     @Override
     public String getName() {
          return "Entity Spawn Generator: " + modid;
     }
}
