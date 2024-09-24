package net.trial.zombies_plus.sound;


import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.trial.zombies_plus.ModMainCommon;


public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ModMainCommon.MOD_ID, Registries.SOUND_EVENT);

    public static final RegistrySupplier<SoundEvent> CAVE_ZOMBIE_YELL = registerSoundEvent("cave_zombie_yell");



    // we use function to simplify it just a bit
    private static RegistrySupplier<SoundEvent> registerSoundEvent(String string) {
        return SOUNDS.register(new ResourceLocation(ModMainCommon.MOD_ID, string), () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ModMainCommon.MOD_ID, string)));
    }

}