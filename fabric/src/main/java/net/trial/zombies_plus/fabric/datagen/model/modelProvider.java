package net.trial.zombies_plus.fabric.datagen.model;

import java.util.Optional;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.model.Model;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.trial.zombies_plus.item.modItems;

public class modelProvider extends FabricModelProvider {
    public modelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(modItems.RUNNER_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.generateFlatItem(modItems.CRAWLER_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.generateFlatItem(modItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.generateFlatItem(modItems.BOW_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.generateFlatItem(modItems.BRUTE_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.generateFlatItem(modItems.AXE_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.generateFlatItem(modItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get(),
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));
    }

}