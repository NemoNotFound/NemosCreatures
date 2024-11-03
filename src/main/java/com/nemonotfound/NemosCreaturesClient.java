package com.nemonotfound;

import com.nemonotfound.client.render.entity.*;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.client.render.entity.model.WildBoarEntityModel;
import com.nemonotfound.entity.ModEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.*;

@Environment(EnvType.CLIENT)
public class NemosCreaturesClient implements ClientModInitializer {

    private static final Dilation ARMOR_DILATION = new Dilation(1.0f);
    private static final Dilation HAT_DILATION = new Dilation(0.5f);
    TexturedModelData armorModelData = TexturedModelData.of(ArmorEntityModel.getModelData(ARMOR_DILATION), 64, 32);
    TexturedModelData hatModelData = TexturedModelData.of(ArmorEntityModel.getModelData(HAT_DILATION), 64, 32);

    @Override
    public void onInitializeClient() {
        ModEntityModelLayers.registerEntityModelLayers();

        EntityRendererRegistry.register(ModEntityTypes.VENOMOUS_SKELETON, VenomousSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.VENOMOUS_SPIDER, VenomousSpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.VENOMOUS_ZOMBIE, VenomousZombieEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.VENOMOUS_CREEPER, VenomousCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SCORCHED_SKELETON, ScorchedSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SAND_SPIDER, SandSpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.MUMMY, MummyEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SCORCHED_CREEPER, ScorchedCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.CRIMSON_SKELETON, CrimsonSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.WARPED_SKELETON, WarpedSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.WILD_BOAR, WildBoarEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOWY_SKELETON, SnowySkeletonEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOWY_PIG, SnowyPigEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOWY_COW, SnowyCowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOWY_SPIDER, SnowySpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOW_SPIDER, SnowSpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOWY_CREEPER, SnowyCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SNOWY_ZOMBIE, SnowyZombieEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.FROZEN_SKELETON, FrozenSkeletonEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.FROZEN_CREEPER, FrozenCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.FROZEN_SPIDER, FrozenSpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.ICE_SPIDER, IceSpiderEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_SKELETON_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_SKELETON_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_SKELETON_OUTER, () -> TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.25f), 0.0f), 64, 32));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_SPIDER, SpiderEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_ZOMBIE, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_ZOMBIE_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_ZOMBIE_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64).transform(BipedEntityModel.BABY_TRANSFORMER));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SCORCHED_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SCORCHED_SKELETON_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SCORCHED_SKELETON_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SAND_SPIDER, SpiderEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.MUMMY, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.MUMMY_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.MUMMY_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.MUMMY_BABY, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64).transform(BipedEntityModel.BABY_TRANSFORMER));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.MUMMY_BABY_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.MUMMY_BABY_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.CRIMSON_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.CRIMSON_SKELETON_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.CRIMSON_SKELETON_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.WARPED_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.WARPED_SKELETON_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.WARPED_SKELETON_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.WILD_BOAR, WildBoarEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.WILD_BOAR_BABY, WildBoarEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_SKELETON_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_SKELETON_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_PIG, () -> PigEntityModel.getTexturedModelData(Dilation.NONE));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_PIG_BABY, () -> PigEntityModel.getTexturedModelData(Dilation.NONE));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_COW, CowEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_COW_BABY, CowEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_SPIDER, SpiderEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOW_SPIDER, SpiderEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_ZOMBIE, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 32));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_ZOMBIE_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_ZOMBIE_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_ZOMBIE_BABY, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 32).transform(BipedEntityModel.BABY_TRANSFORMER));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_ZOMBIE_BABY_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNOWY_ZOMBIE_BABY_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FROZEN_SKELETON, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FROZEN_SKELETON_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FROZEN_SKELETON_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FROZEN_SPIDER, SpiderEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ICE_SPIDER, SpiderEntityModel::getTexturedModelData);
    }
}
