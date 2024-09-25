package net.trial.zombies_plus.forge.datagen.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.trial.zombies_plus.forge.ModMain;
import net.trial.zombies_plus.item.ModItems;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
       // simpleItem(MODITEMS.FRIES);

        spawnEgg(ModItems.RUNNER_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.BRUTE_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.CRAWLER_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.CROSSBOW_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.BOW_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.SHRIEKER_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.AXE_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.SWORD_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.WEAK_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.SLOW_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.VILE_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.CAVE_ZOMBIE_SPAWN_EGG);
        spawnEgg(ModItems.LEAPER_ZOMBIE_SPAWN_EGG);

       // simpleBlock(MODBLOCKS.BLOCK_OF_CHEESE);

    }

//        return withExistingParent(eyeOfVillages.getId().getPath(),
//        new ResourceLocation("item/generated")).texture("layer0",
//        new ResourceLocation(modMain.MOD_ID, "item/" + eyeOfVillages.getId().getPath()));
//    }

    private ItemModelBuilder simpleBlock(RegistryObject<Block> blockRegistryObject) {
        return withExistingParent(blockRegistryObject.getId().getPath(),
                new ResourceLocation(ModMain.MOD_ID, "block/" + blockRegistryObject.getId().getPath()));
    }

    private ItemModelBuilder spawnEgg(RegistrySupplier<Item> item){
        return withExistingParent(item.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
