package net.trial.zombies_plus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.DrownedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.trial.zombies_plus.entity.client.models.*;
import net.trial.zombies_plus.entity.custom.*;

public class ModModelRenderer {

    public static class GenericRunnerZombieRenderer<T extends AbstractZombieEntity> extends AbstractZombieRenderer<T, RunnerZombieModel<T>> {
        public GenericRunnerZombieRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(T entity) {
            return entity.getTexture();
        }

        public GenericRunnerZombieRenderer(EntityRendererProvider.Context context, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(context, new RunnerZombieModel<>(context.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(context.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(context.bakeLayer(pOuterArmor)));
        }
    }

    public static class CustomZombieRenderer<T extends AbstractZombieEntity, M extends HierarchicalModel<T>> extends MobRenderer<T, M> {
        public CustomZombieRenderer(EntityRendererProvider.Context context, M model, float shadowSize) {
            super(context, model, shadowSize);
        }

        @Override
        public ResourceLocation getTextureLocation(T entity) {
            return entity.getTexture();
        }
    }

    public static class RunnerZombieRenderer extends GenericRunnerZombieRenderer<RunnerZombieEntity> {
        public RunnerZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class AxeZombieRenderer extends GenericRunnerZombieRenderer<AxeZombieEntity> {
        public AxeZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class BowZombieRenderer extends GenericRunnerZombieRenderer<BowZombieEntity> {
        public BowZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class SwordZombieRenderer extends GenericRunnerZombieRenderer<SwordZombieEntity> {
        public SwordZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class WeakZombieRenderer extends GenericRunnerZombieRenderer<WeakZombieEntity> {
        public WeakZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class SlowZombieRenderer extends GenericRunnerZombieRenderer<SlowZombieEntity> {
        public SlowZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class CaveZombieRenderer extends GenericRunnerZombieRenderer<CaveZombieEntity> {
        public CaveZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class LeaperZombieRenderer extends GenericRunnerZombieRenderer<LeaperZombieEntity> {
        public LeaperZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class CrossbowZombieRenderer extends GenericRunnerZombieRenderer<CrossbowZombieEntity> {
        public CrossbowZombieRenderer(EntityRendererProvider.Context context) {
            super(context);
        }
    }

    public static class BruteZombieRenderer extends CustomZombieRenderer<BruteZombieEntity, BruteZombieModel<BruteZombieEntity>> {
        public BruteZombieRenderer(EntityRendererProvider.Context context) {
            super(context, new BruteZombieModel<>(context.bakeLayer(ModModelLayers.BRUTE_ZOMBIE_LAYER)), 1f);
        }

        @Override
        public void render(BruteZombieEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
            super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
        }
    }

    public static class CrawlerZombieRenderer extends CustomZombieRenderer<CrawlerZombieEntity, CrawlerZombieModel<CrawlerZombieEntity>> {
        public CrawlerZombieRenderer(EntityRendererProvider.Context context) {
            super(context, new CrawlerZombieModel<>(context.bakeLayer(ModModelLayers.CRAWLER_ZOMBIE_LAYER)), 1f);
        }
    }

    public static class ShriekerZombieRenderer extends CustomZombieRenderer<ShriekerZombieEntity, ShriekerZombieModel<ShriekerZombieEntity>> {
        public ShriekerZombieRenderer(EntityRendererProvider.Context context) {
            super(context, new ShriekerZombieModel<>(context.bakeLayer(ModModelLayers.SHRIEKER_ZOMBIE_LAYER)), 1f);
        }
    }

    public static class VileZombieRenderer extends AbstractZombieRenderer<VileZombieEntity, DrownedModel<VileZombieEntity>> {
        public VileZombieRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(VileZombieEntity entity) {
            return entity.getTexture();
        }

        public VileZombieRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new DrownedModel<>(pContext.bakeLayer(pZombieLayer)), new DrownedModel<>(pContext.bakeLayer(pInnerArmor)), new DrownedModel<>(pContext.bakeLayer(pOuterArmor)));
        }
    }

}
