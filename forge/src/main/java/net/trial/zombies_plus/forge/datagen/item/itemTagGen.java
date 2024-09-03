package net.trial.zombies_plus.forge.datagen.item;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class itemTagGen extends ItemTagsProvider {

        public itemTagGen(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags, String modId,
            @org.jetbrains.annotations.Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, modId, existingFileHelper);
    }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
          /*   this.tag(ItemTags.TRIMMABLE_ARMOR)
                    .add(ModItems.SAPPHIRE_HELMET.get(),
                            ModItems.SAPPHIRE_CHESTPLATE.get(),
                            ModItems.SAPPHIRE_LEGGINGS.get(),
                            ModItems.SAPPHIRE_BOOTS.get());

            this.tag(ItemTags.MUSIC_DISCS)
                    .add(ModItems.BAR_BRAWL_MUSIC_DISC.get());

            this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                    .add(ModItems.BAR_BRAWL_MUSIC_DISC.get());

            this.tag(ItemTags.LOGS_THAT_BURN)
                    .add(ModBlocks.PINE_LOG.get().asItem())
                    .add(ModBlocks.PINE_WOOD.get().asItem())
                    .add(ModBlocks.STRIPPED_PINE_LOG.get().asItem())
                    .add(ModBlocks.STRIPPED_PINE_WOOD.get().asItem());

            this.tag(ItemTags.PLANKS)
                    .add(ModBlocks.PINE_PLANKS.get().asItem()); */
        }

}
