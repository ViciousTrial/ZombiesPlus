package net.trial.zombies_plus.forge.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trial.zombies_plus.modMainCommon;
import net.trial.zombies_plus.forge.modMain;
import net.trial.zombies_plus.forge.datagen.entity.entitySpawnGen;
import net.trial.zombies_plus.forge.datagen.entity.entityTagGen;
import net.trial.zombies_plus.forge.datagen.item.itemModelProvider;
import net.trial.zombies_plus.forge.datagen.lang.langGen;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = modMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class dataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //generator.addProvider(event.includeClient(), new blockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new itemModelProvider(packOutput, existingFileHelper));

        //generator.addProvider(event.includeServer(), blockLootTableProvider.create(packOutput));
        
        generator.addProvider(event.includeServer(), new entityTagGen(packOutput, lookupProvider, modMain.MOD_ID, existingFileHelper));

    /*      blockTagGen blockTagGenerator = generator.addProvider(event.includeServer(),
                new blockTagGen(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new itemTagGen(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), Misgiving.MOD_ID, existingFileHelper)); */

        //generator.addProvider(event.includeServer(), new structureTagGen(packOutput, lookupProvider, Misgiving.MOD_ID, existingFileHelper));
        //generator.addProvider(event.includeServer(), new worldGenProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new langGen(packOutput, modMain.MOD_ID, "en_us"));
        generator.addProvider(event.includeServer(), new entitySpawnGen(packOutput, modMainCommon.MOD_ID));
        //generator.addProvider(event.includeServer(), new recipeProvider(packOutput));

        


    }
}
