package com.nemonotfound;

import com.nemonotfound.client.render.entity.VenomousSkeletonEntityRenderer;
import com.nemonotfound.client.render.entity.VenomousSpiderEntityRenderer;
import com.nemonotfound.entity.Entities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(EnvType.CLIENT)
public class NemosCreaturesClient implements ClientModInitializer {

    public static final EntityModelLayer VENOMOUS_SKELETON = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "main");
    public static final EntityModelLayer VENOMOUS_SKELETON__INNER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "inner_armor");
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "outer_armor");
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "outer");
    public static final EntityModelLayer VENOMOUS_SPIDER = new EntityModelLayer(new Identifier(MOD_ID, "venomous_spider"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Entities.VENOMOUS_SKELETON, VenomousSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(Entities.VENOMOUS_SPIDER, VenomousSpiderEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON__INNER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON_OUTER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON_OUTER, () -> TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.25f), 0.0f), 64, 32));
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SPIDER, SpiderEntityModel::getTexturedModelData);
    }
}
