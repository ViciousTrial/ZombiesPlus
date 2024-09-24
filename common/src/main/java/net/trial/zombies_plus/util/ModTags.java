package net.trial.zombies_plus.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.trial.zombies_plus.ModMainCommon;

public class ModTags {
   /*  public static class Items {

        public static final TagKey<Item> BURGERS = tag("burgers");
        
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(templateMod.MOD_ID, name));
        } */
    //}

     public static class Blocks {

        public static final TagKey<Block> CAVE_ZOMBIE_SPAWNABLE = tag("cave_zombie_spawnable");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(name));
        }
    }

    public static class EntityTag {
        public static final TagKey<EntityType<?>> HORDE_ZOMBIES = entityTag("horde_zombies");


        private static TagKey<EntityType<?>> entityTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ModMainCommon.MOD_ID, name));
        }
    }
}