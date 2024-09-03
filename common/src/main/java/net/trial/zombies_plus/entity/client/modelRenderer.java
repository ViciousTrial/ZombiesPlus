package net.trial.zombies_plus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.trial.zombies_plus.entity.client.models.bruteZombieModel;
import net.trial.zombies_plus.entity.client.models.crawlerZombieModel;
import net.trial.zombies_plus.entity.client.models.crossbowZombieModel;
import net.trial.zombies_plus.entity.client.models.runnerZombieModel;
import net.trial.zombies_plus.entity.client.models.shriekerZombieModel;
import net.trial.zombies_plus.entity.custom.axeZombieEntity;
import net.trial.zombies_plus.entity.custom.bowZombieEntity;
import net.trial.zombies_plus.entity.custom.bruteZombieEntity;
import net.trial.zombies_plus.entity.custom.crawlerZombieEntity;
import net.trial.zombies_plus.entity.custom.crossbowZombieEntity;
import net.trial.zombies_plus.entity.custom.runnerZombieEntity;
import net.trial.zombies_plus.entity.custom.shriekerZombieEntity;

public class modelRenderer {
 
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

    public static class bruteZombieModelRenderer extends MobRenderer<bruteZombieEntity, bruteZombieModel<bruteZombieEntity>> {
        public bruteZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new bruteZombieModel<>(pContext.bakeLayer(modelLayers.BRUTE_ZOMBIE_LAYER)), 1f);
        }


        @Override
        public ResourceLocation getTextureLocation(bruteZombieEntity pEntity){ 
            return pEntity.getTexture();
        }

        @Override
        public void render(bruteZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {


            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
           /*  bruteZombieModel<bruteZombieEntity> model = (bruteZombieModel<bruteZombieEntity>) this.getModel();
            if (!pEntity.getHasSetupAnim()){
                modelExtraMethods.determineArmless(pEntity, model.left_arm, model.right_arm);
                pEntity.setHasSetupAnim(true);
            } */

        }
    }   

    public static class crawlerZombieModelRenderer extends MobRenderer<crawlerZombieEntity, crawlerZombieModel<crawlerZombieEntity>> {
        public crawlerZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new crawlerZombieModel<>(pContext.bakeLayer(modelLayers.CRAWLER_ZOMBIE_LAYER)), 1f);
        }

        @Override
        public ResourceLocation getTextureLocation(crawlerZombieEntity pEntity) {
            return pEntity.getTexture();
        }

        @Override
        public void render(crawlerZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }   

    public static class runnerZombieModelRenderer extends AbstractZombieRenderer<runnerZombieEntity, runnerZombieModel<runnerZombieEntity>> {
       public runnerZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
      this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
   }
   @Override
       public ResourceLocation getTextureLocation(runnerZombieEntity pEntity) {
           return pEntity.getTexture();
       }

   public runnerZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
      super(pContext, new runnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new runnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new runnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
   }
    }   

    /////////

    public static class crossbowZombieModelRenderer extends AbstractZombieRenderer<crossbowZombieEntity, crossbowZombieModel<crossbowZombieEntity>> {
        public crossbowZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
             this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }
        @Override
        public ResourceLocation getTextureLocation(crossbowZombieEntity pEntity) {
            return pEntity.getTexture();
        }
 
    public crossbowZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
       super(pContext, new crossbowZombieModel<>(pContext.bakeLayer(pZombieLayer)), new crossbowZombieModel<>(pContext.bakeLayer(pInnerArmor)), new crossbowZombieModel<>(pContext.bakeLayer(pOuterArmor)));
    }
     }   

     //

     public static class bowZombieModelRenderer extends AbstractZombieRenderer<bowZombieEntity, runnerZombieModel<bowZombieEntity>> {
        public bowZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
             this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }
        @Override
        public ResourceLocation getTextureLocation(bowZombieEntity pEntity) {
            return pEntity.getTexture();
        }
 
    public bowZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
       super(pContext, new runnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new runnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new runnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
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

    public static class shriekerZombieModelRenderer extends MobRenderer<shriekerZombieEntity, shriekerZombieModel<shriekerZombieEntity>> {
        public shriekerZombieModelRenderer(EntityRendererProvider.Context pContext) {
            super(pContext, new shriekerZombieModel<>(pContext.bakeLayer(modelLayers.SHRIEKER_ZOMBIE_LAYER)), 1f);
        }


        @Override
        public ResourceLocation getTextureLocation(shriekerZombieEntity pEntity){ 
            return pEntity.getTexture();
        }

        @Override
        public void render(shriekerZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }   
    
    public static class axeZombieModelRenderer extends AbstractZombieRenderer<axeZombieEntity, runnerZombieModel<axeZombieEntity>> {
        public axeZombieModelRenderer(EntityRendererProvider.Context p_174456_) {
             this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }
        @Override
        public ResourceLocation getTextureLocation(axeZombieEntity pEntity) {
            return pEntity.getTexture();
        }
 
    public axeZombieModelRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
       super(pContext, new runnerZombieModel<>(pContext.bakeLayer(pZombieLayer)), new runnerZombieModel<>(pContext.bakeLayer(pInnerArmor)), new runnerZombieModel<>(pContext.bakeLayer(pOuterArmor)));
    }

    }

}
