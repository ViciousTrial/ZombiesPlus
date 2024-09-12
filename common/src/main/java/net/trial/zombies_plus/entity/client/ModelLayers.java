package net.trial.zombies_plus.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.trial.zombies_plus.ModMainCommon;

public class ModelLayers {
    public static final ModelLayerLocation RUNNER_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(ModMainCommon.MOD_ID, "runner_zombie_layer"), "main");

    public static final ModelLayerLocation BRUTE_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(ModMainCommon.MOD_ID, "brute_zombie_layer"), "main");

    public static final ModelLayerLocation CRAWLER_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(ModMainCommon.MOD_ID, "crawler_zombie_layer"), "main");

    public static final ModelLayerLocation SHRIEKER_ZOMBIE_LAYER = new ModelLayerLocation(
           new ResourceLocation(ModMainCommon.MOD_ID, "shrieker_zombie_layer"), "main");

}
