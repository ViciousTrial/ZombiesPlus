package net.trial.zombies_plus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.DrownedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.trial.zombies_plus.entity.client.models.BruteZombieModel;
import net.trial.zombies_plus.entity.client.models.CrawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.CrossbowZombieModel;
import net.trial.zombies_plus.entity.client.models.RunnerZombieModel;
import net.trial.zombies_plus.entity.client.models.ShriekerZombieModel;
import net.trial.zombies_plus.entity.custom.*;

public class ModelRenderer {
 
  /*   public static class runnerZombieModelRenderer extends MobRenderer<runnerZombieEntity, runnerZombieModel<runnerZombieEntity>> {
        public runnerZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new runnerZombieModel<>(pContext.bakeLayer(modelLayers.RUNNER_ZOMBIE_LAYER)), 1f);
        }

        @Override
        public ResourceLocation getTextureLocation(runnerZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        @Override
        public void render(runnerZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {


            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }    */

    public static class bruteZombieModelRenderer extends MobRenderer<BruteZombieEntity, BruteZombieModel<BruteZombieEntity>> {
        public bruteZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new BruteZombieModel<>(pContext.bakeLayer(ModelLayers.BRUTE_ZOMBIE_LAYER)), 1f);
        }


        @Override
        public ResourceLocation getTextureLocation(BruteZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        @Override
        public void render(BruteZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {


            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
           /*  bruteZombieModel<bruteZombieEntity> model = (bruteZombieModel<bruteZombieEntity>) this.getModel();
            if (!pEntity.getHasSetupAnim()){
                modelExtraMethods.determineArmless(pEntity, model.left_arm, model.right_arm);
                pEntity.setHasSetupAnim(true);
            } */

        }
    }

    public static class crawlerZombieModelRenderer extends MobRenderer<CrawlerZombieEntity, CrawlerZombieModel<CrawlerZombieEntity>> {
        public crawlerZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new CrawlerZombieModel<>(pContext.bakeLayer(ModelLayers.CRAWLER_ZOMBIE_LAYER)), 1f);
        }

        @Override
        public ResourceLocation getTextureLocation(CrawlerZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        @Override
        public void render(CrawlerZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }

    public static class runnerZombieModelRenderer extends AbstractZombieRenderer<RunnerZombieEntity, RunnerZombieModel<RunnerZombieEntity>> {
        public runnerZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(RunnerZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public runnerZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }
    }

    /////////

    public static class crossbowZombieModelRenderer extends AbstractZombieRenderer<CrossbowZombieEntity, CrossbowZombieModel<CrossbowZombieEntity>> {
        public crossbowZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(CrossbowZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public crossbowZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new CrossbowZombieModel<>(pContext.bakeLayer(pZombieLayer)), new CrossbowZombieModel<>(pContext.bakeLayer(pInnerArmor)), new CrossbowZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }
    }

    //

    public static class bowZombieModelRenderer extends AbstractZombieRenderer<BowZombieEntity, RunnerZombieModel<BowZombieEntity>> {
        public bowZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(BowZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public bowZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }
/* 
    public static class shriekerZombieModelRenderer extends AbstractZombieRenderer<shriekerZombieEntity, shriekerZombieModel<shriekerZombieEntity>> {
        public shriekerZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
             this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }
        @Override
        public ResourceLocation getTextureLocation(shriekerZombieEntity pEntity) {
            return pEntity.getTexture();
        }
 
    public shriekerZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
       super(pContext, new shriekerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new shriekerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new shriekerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
    }
    }
 */

    public static class shriekerZombieModelRenderer extends MobRenderer<ShriekerZombieEntity, ShriekerZombieModel<ShriekerZombieEntity>> {
        public shriekerZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new ShriekerZombieModel<>(pContext.bakeLayer(ModelLayers.SHRIEKER_ZOMBIE_LAYER)), 1f);
        }


        @Override
        public ResourceLocation getTextureLocation(ShriekerZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        @Override
        public void render(ShriekerZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }

    public static class axeZombieModelRenderer extends AbstractZombieRenderer<AxeZombieEntity, RunnerZombieModel<AxeZombieEntity>> {
        public axeZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(AxeZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public axeZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }


    public static class swordZombieModelRenderer extends AbstractZombieRenderer<SwordZombieEntity, RunnerZombieModel<SwordZombieEntity>> {
        public swordZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(SwordZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public swordZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }

    public static class weakZombieModelRenderer extends AbstractZombieRenderer<WeakZombieEntity, RunnerZombieModel<WeakZombieEntity>> {
        public weakZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(WeakZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public weakZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }

     public static class slowZombieModelRenderer extends AbstractZombieRenderer<SlowZombieEntity, RunnerZombieModel<SlowZombieEntity>> {
        public slowZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(SlowZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public slowZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }

    public static class vileZombieModelRenderer extends AbstractZombieRenderer<VileZombieEntity, DrownedModel<VileZombieEntity>> {
        public vileZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(VileZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public vileZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new DrownedModel<>(pContext.bakeLayer(pZombieLayer)), new DrownedModel<>(pContext.bakeLayer(pInnerArmor)), new DrownedModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }

    public static class caveZombieModelRenderer extends AbstractZombieRenderer<CaveZombieEntity, RunnerZombieModel<CaveZombieEntity>> {
        public caveZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(CaveZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public caveZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }

    public static class leaperZombieModelRenderer extends AbstractZombieRenderer<LeaperZombieEntity, RunnerZombieModel<LeaperZombieEntity>> {
        public leaperZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
            this(p_174456_, net.minecraft.client.model.geom.ModelLayers.ZOMBIE, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_INNER_ARMOR, net.minecraft.client.model.geom.ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(LeaperZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        public leaperZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
            super(pContext, new RunnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new RunnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new RunnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
        }

    }

}
