package net.trial.zombies_plus.forge.worldgen;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trial.zombies_plus.ModMainCommon;

public class BiomeModifiers {

    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ModMainCommon.MOD_ID);

   public static final RegistryObject<Codec<ZombieSpawnBiomeModifier>> ZOMBIE_SPAWN_CODEC =
            BIOME_MODIFIER_SERIALIZERS.register("zombie_spawn_biome_modifier", () -> ZombieSpawnBiomeModifier.CODEC);

}
