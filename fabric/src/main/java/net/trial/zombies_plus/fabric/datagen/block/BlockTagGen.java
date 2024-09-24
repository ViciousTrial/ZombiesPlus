package net.trial.zombies_plus.fabric.datagen.block;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.trial.zombies_plus.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGen extends BlockTagProvider  {
    public BlockTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(ModTags.Blocks.CAVE_ZOMBIE_SPAWNABLE)
                .forceAddTag(BlockTags.STONE_BRICKS)
                .forceAddTag(ConventionalBlockTags.SANDSTONE_BLOCKS)
                .forceAddTag(ConventionalBlockTags.ORES)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD);
    }

}
