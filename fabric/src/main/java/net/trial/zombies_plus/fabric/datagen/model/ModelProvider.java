package net.trial.zombies_plus.fabric.datagen.model;

import java.util.Optional;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.trial.zombies_plus.item.ModItems;

public class ModelProvider extends FabricModelProvider {

        private ItemModelGenerators itemModelGenerator;

        public ModelProvider(FabricDataOutput output) {
                super(output);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        }

        @Override
        public void generateItemModels(ItemModelGenerators itemModelGenerator) {
                this.itemModelGenerator = itemModelGenerator;
               
                spawnEgg(ModItems.RUNNER_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.BRUTE_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.CRAWLER_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.CROSSBOW_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.BOW_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.SHRIEKER_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.AXE_ZOMBIE_SPAWN_EGG.get());
                spawnEgg(ModItems.SWORD_ZOMBIE_SPAWN_EGG.get());
        }

        private void spawnEgg(Item item) {
                this.itemModelGenerator.generateFlatItem(item,
                                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")),
                                                Optional.empty()));
        }

}