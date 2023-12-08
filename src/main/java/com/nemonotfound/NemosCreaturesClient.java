package com.nemonotfound;

import com.nemonotfound.client.render.entity.*;
import com.nemonotfound.entity.Entities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(EnvType.CLIENT)
public class NemosCreaturesClient implements ClientModInitializer {

    public static final EntityModelLayer VENOMOUS_SKELETON = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "main");
    public static final EntityModelLayer VENOMOUS_SKELETON_INNER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "inner_armor");
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "outer_armor");
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER = new EntityModelLayer(new Identifier(MOD_ID, "venomous_skeleton"), "outer");
    public static final EntityModelLayer VENOMOUS_SPIDER = new EntityModelLayer(new Identifier(MOD_ID, "venomous_spider"), "main");
    public static final EntityModelLayer VENOMOUS_ZOMBIE = new EntityModelLayer(new Identifier(MOD_ID, "venomous_zombie"), "main");
    public static final EntityModelLayer VENOMOUS_ZOMBIE_INNER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venomous_zombie"), "inner_armor");
    public static final EntityModelLayer VENOMOUS_ZOMBIE_OUTER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venomous_zombie"), "outer_armor");
    public static final EntityModelLayer SCORCHED_SKELETON = new EntityModelLayer(new Identifier(MOD_ID, "scorched_skeleton"), "main");
    public static final EntityModelLayer SCORCHED_SKELETON_INNER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "scorched_skeleton"), "inner_armor");
    public static final EntityModelLayer SCORCHED_SKELETON_OUTER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "scorched_skeleton"), "outer_armor");


    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Entities.VENOMOUS_SKELETON, VenomousSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(Entities.VENOMOUS_SPIDER, VenomousSpiderEntityRenderer::new);
        EntityRendererRegistry.register(Entities.VENOMOUS_ZOMBIE, VenomousZombieEntityRenderer::new);
        EntityRendererRegistry.register(Entities.VENOMOUS_CREEPER, VenomousCreeperEntityRenderer::new);
        EntityRendererRegistry.register(Entities.SCORCHED_SKELETON, ScorchedSkeletonEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON_INNER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON_OUTER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SKELETON_OUTER, () -> TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.25f), 0.0f), 64, 32));
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_SPIDER, SpiderEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_ZOMBIE, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_ZOMBIE_INNER_ARMOR, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(VENOMOUS_ZOMBIE_OUTER_ARMOR, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(SCORCHED_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SCORCHED_SKELETON_INNER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SCORCHED_SKELETON_OUTER_ARMOR, SkeletonEntityModel::getTexturedModelData);
    }
}
