package net.trial.zombies_plus.forge.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.util.ModConfig;
import net.trial.zombies_plus.world.gen.EntitySpawn;

import java.util.List;

public class ZombieSpawnBiomeModifier implements BiomeModifier {

    public static final Codec<ZombieSpawnBiomeModifier> CODEC = Codec.unit(ZombieSpawnBiomeModifier::new);

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
      if (phase == Phase.ADD) {
        List<EntityType<? extends Monster>> zombieEntities = EntitySpawn.addForgeSpawns();

        for (EntityType<? extends Monster> entityType : zombieEntities) {
            ResourceLocation entityResourceLocation = EntityType.getKey(entityType);
            String zombieTypeFromEntity = normalizeZombieType(entityResourceLocation.getPath());

            ModConfig.ZombieSpawnConfig spawnConfig = ModMainCommon.modConfigInstance.zombieSpawnProperties.stream()
                    .filter(zsp -> normalizeZombieType(zsp.zombieType).equals(zombieTypeFromEntity))
                    .findFirst()
                    .orElse(null);

            if (spawnConfig != null) {
                boolean shouldAddSpawn = false;

                if (zombieTypeFromEntity.equals("vilezombie")) {
                    if (biome.is(Tags.Biomes.IS_SWAMP)) {
                        shouldAddSpawn = true;
                    }
                } else {
                    if (biome.is(BiomeTags.IS_OVERWORLD)) {
                        shouldAddSpawn = true;
                    }
                }

                if (shouldAddSpawn) {
                    builder.getMobSpawnSettings().addSpawn(
                            MobCategory.MONSTER,
                            new MobSpawnSettings.SpawnerData(entityType, spawnConfig.spawnWeight, spawnConfig.minGroupSize, spawnConfig.maxGroupSize)
                    );
                    //ModMainCommon.LOGGER.info("Registered spawn for zombie type: {} in biome: {}", entityResourceLocation.getPath(), biome.unwrapKey().map(ResourceKey::location).orElse(new ResourceLocation("unknown")));
                }
            } else {
                //ModMainCommon.LOGGER.warn("No spawn config found for zombie type: {}", entityResourceLocation.getPath());
            }
        }
    }
    }

    private String normalizeZombieType(String zombieType) {
        return zombieType.replace("_", "").toLowerCase();
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return CODEC;
    }
}
