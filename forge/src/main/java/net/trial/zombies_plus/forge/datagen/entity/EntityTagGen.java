package net.trial.zombies_plus.forge.datagen.entity;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.trial.zombies_plus.forge.ModMain;

public class EntityTagGen extends EntityTypeTagsProvider {

    public EntityTagGen(PackOutput pOutput, CompletableFuture<Provider> pProvider, String modId,
                        @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, ModMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
       
    }

}
