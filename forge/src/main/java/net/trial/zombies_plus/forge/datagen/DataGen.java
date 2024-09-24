package net.trial.zombies_plus.forge.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trial.zombies_plus.ModMainCommon;
import net.trial.zombies_plus.forge.ModMain;
import net.trial.zombies_plus.forge.datagen.block.BlockTagGen;
import net.trial.zombies_plus.forge.datagen.entity.EntitySpawnGen;
import net.trial.zombies_plus.forge.datagen.entity.EntityTagGen;
import net.trial.zombies_plus.forge.datagen.item.ItemModelProvider;
import net.trial.zombies_plus.forge.datagen.item.ItemTagGen;
import net.trial.zombies_plus.forge.datagen.lang.LangGen;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //generator.addProvider(event.includeClient(), new blockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelProvider(packOutput, existingFileHelper));

        //generator.addProvider(event.includeServer(), blockLootTableProvider.create(packOutput));

        generator.addProvider(event.includeServer(), new EntityTagGen(packOutput, lookupProvider, ModMain.MOD_ID, existingFileHelper));

        BlockTagGen blockTagGenerator = generator.addProvider(event.includeServer(),
                new BlockTagGen(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ItemTagGen(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), ModMainCommon.MOD_ID, existingFileHelper));


        //generator.addProvider(event.includeServer(), new structureTagGen(packOutput, lookupProvider, Misgiving.MOD_ID, existingFileHelper));
        //generator.addProvider(event.includeServer(), new worldGenProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new LangGen(packOutput, ModMain.MOD_ID, "en_us"));
        generator.addProvider(event.includeServer(), new EntitySpawnGen(packOutput, ModMainCommon.MOD_ID));
        //generator.addProvider(event.includeClient(), new SoundDefinitions(packOutput, ModMainCommon.MOD_ID, existingFileHelper));

        //generator.addProvider(event.includeServer(), new recipeProvider(packOutput));


    }
}
