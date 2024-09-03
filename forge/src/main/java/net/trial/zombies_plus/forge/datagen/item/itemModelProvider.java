package net.trial.zombies_plus.forge.datagen.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.trial.zombies_plus.forge.modMain;
import net.trial.zombies_plus.item.modItems;

public class itemModelProvider extends ItemModelProvider {
    public itemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, modMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
       // simpleItem(MODITEMS.FRIES);

        spawnEgg(modItems.RUNNER_ZOMBIE_SPAWN_EGG);
        spawnEgg(modItems.BRUTE_ZOMBIE_SPAWN_EGG);
        spawnEgg(modItems.CRAWLER_ZOMBIE_SPAWN_EGG);
        spawnEgg(modItems.CROSSBOW_ZOMBIE_SPAWN_EGG);
        spawnEgg(modItems.BOW_ZOMBIE_SPAWN_EGG);
        spawnEgg(modItems.SHRIEKER_ZOMBIE_SPAWN_EGG);
        spawnEgg(modItems.AXE_ZOMBIE_SPAWN_EGG);

       // simpleBlock(MODBLOCKS.BLOCK_OF_CHEESE);

    }

    private ItemModelBuilder simpleItem(RegistrySupplier<Item> eyeOfVillages) {
        return withExistingParent(eyeOfVillages.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
        new ResourceLocation(modMain.MOD_ID, "item/" + eyeOfVillages.getId().getPath()));
    }

    private ItemModelBuilder simpleBlock(RegistryObject<Block> blockRegistryObject) {
        return withExistingParent(blockRegistryObject.getId().getPath(),
                new ResourceLocation(modMain.MOD_ID, "block/" + blockRegistryObject.getId().getPath()));
    }

    private ItemModelBuilder spawnEgg(RegistrySupplier<Item> item){
        return withExistingParent(item.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
