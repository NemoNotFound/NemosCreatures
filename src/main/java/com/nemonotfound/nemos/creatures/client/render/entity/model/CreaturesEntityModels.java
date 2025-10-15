package com.nemonotfound.nemos.creatures.client.render.entity.model;

import com.google.common.collect.ImmutableMap;
import com.nemonotfound.nemos.creatures.client.render.entity.*;
import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.minecraft.client.render.entity.model.*;
import org.jetbrains.annotations.NotNull;

public class CreaturesEntityModels {

    private static final Dilation OUTER_DILATION = new Dilation(0.1f);
    private static final Dilation ARMOR_DILATION = new Dilation(1.0F);
    private static final Dilation HAT_DILATION = new Dilation(0.5F);

    public static void bootstrap() {
        EntityRendererFactories.register(CreaturesEntityTypes.VENOMOUS_SKELETON, VenomousSkeletonEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.VENOMOUS_SPIDER, VenomousSpiderEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.VENOMOUS_ZOMBIE, VenomousZombieEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.VENOMOUS_CREEPER, VenomousCreeperEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SCORCHED_SKELETON, ScorchedSkeletonEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SAND_SPIDER, SandSpiderEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.MUMMY, MummyEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SCORCHED_CREEPER, ScorchedCreeperEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.CRIMSON_SKELETON, CrimsonSkeletonEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.WARPED_SKELETON, WarpedSkeletonEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.WILD_BOAR, WildBoarEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOWY_SKELETON, SnowySkeletonEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOWY_PIG, SnowyPigEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOWY_COW, SnowyCowEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOWY_SPIDER, SnowySpiderEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOW_SPIDER, SnowSpiderEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOWY_CREEPER, SnowyCreeperEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.SNOWY_ZOMBIE, SnowyZombieEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.FROZEN_SKELETON, FrozenSkeletonEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.FROZEN_CREEPER, FrozenCreeperEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.FROZEN_SPIDER, FrozenSpiderEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.ICE_SPIDER, IceSpiderEntityRenderer::new);
        EntityRendererFactories.register(CreaturesEntityTypes.FROZEN_ZOMBIE, FrozenZombieEntityRenderer::new);

        ImmutableMap.Builder<EntityModelLayer, TexturedModelData> builder = ImmutableMap.builder();

        var bipedEquipmentModelData = BipedEntityModel.createEquipmentModelData(HAT_DILATION, ARMOR_DILATION)
                .map(data -> TexturedModelData.of(data, 64, 32));
        var babyBipedEquipmentModelData = bipedEquipmentModelData.map(modelData -> modelData.transform(BipedEntityModel.BABY_TRANSFORMER));

        var skeletonOuterTexturedModelData = bipedTexturedModelData64x32(OUTER_DILATION);
        var skeletonOuterPantsTexturedModelData = bipedTexturedModelData64x32(new Dilation(0.25f));
        var zombieTexturedModelData64x64 = zombieTexturedModelData(Dilation.NONE, 64);
        var zombieOuterTexturedModelData64x64 = zombieTexturedModelData(OUTER_DILATION, 64);
        var mummyOuterTexturedModelData = zombieTexturedModelData(new Dilation(0.25f), 64);
        var zombieTexturedModelData64x32 = zombieTexturedModelData(Dilation.NONE, 32);
        var zombieOuterTexturedModelData64x32 = zombieTexturedModelData(OUTER_DILATION, 32);

        builder.put(CreaturesEntityModelLayers.VENOMOUS_SKELETON, SkeletonEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.VENOMOUS_SKELETON_OUTER, skeletonOuterTexturedModelData);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_SKELETON_OUTER_PANTS, skeletonOuterPantsTexturedModelData);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_SPIDER, SpiderEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.VENOMOUS_CREEPER_OUTER, CreeperEntityModel.getTexturedModelData(OUTER_DILATION));
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE, zombieTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_OUTER, zombieOuterTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY, zombieTexturedModelData64x64.transform(BipedEntityModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER, zombieOuterTexturedModelData64x64.transform(BipedEntityModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.SCORCHED_SKELETON, SkeletonEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SAND_SPIDER, SpiderEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SCORCHED_CREEPER_OUTER, CreeperEntityModel.getTexturedModelData(OUTER_DILATION));
        builder.put(CreaturesEntityModelLayers.MUMMY, zombieTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.MUMMY_OUTER, mummyOuterTexturedModelData);
        builder.put(CreaturesEntityModelLayers.MUMMY_BABY, zombieTexturedModelData64x64.transform(BipedEntityModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.MUMMY_BABY_OUTER, mummyOuterTexturedModelData.transform(BipedEntityModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.CRIMSON_SKELETON, SkeletonEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.WARPED_SKELETON, SkeletonEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.WILD_BOAR, WildBoarEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.WILD_BOAR_BABY, WildBoarEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOWY_SKELETON, SkeletonEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOWY_SKELETON_OUTER, skeletonOuterTexturedModelData);
        builder.put(CreaturesEntityModelLayers.SNOWY_PIG, PigEntityModel.getTexturedModelData(Dilation.NONE));
        builder.put(CreaturesEntityModelLayers.SNOWY_PIG_BABY, PigEntityModel.getTexturedModelData(Dilation.NONE));
        builder.put(CreaturesEntityModelLayers.SNOWY_COW, CowEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOWY_COW_BABY, CowEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOWY_SPIDER, SpiderEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOW_SPIDER, SpiderEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOWY_CREEPER_OUTER, CreeperEntityModel.getTexturedModelData(OUTER_DILATION));
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE, zombieTexturedModelData64x32);
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE_OUTER, zombieOuterTexturedModelData64x32);
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY, zombieTexturedModelData64x32.transform(BipedEntityModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY_OUTER, zombieOuterTexturedModelData64x32.transform(BipedEntityModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.FROZEN_SKELETON, SkeletonEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.FROZEN_SPIDER, SpiderEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.ICE_SPIDER, SpiderEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.FROZEN_ZOMBIE, zombieTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.FROZEN_ZOMBIE_BABY, zombieTexturedModelData64x64.transform(BipedEntityModel.BABY_TRANSFORMER));

        CreaturesEntityModelLayers.VENOMOUS_SKELETON_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_EQUIPMENT.addTo(babyBipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SCORCHED_SKELETON_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.MUMMY_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.MUMMY_BABY_EQUIPMENT.addTo(babyBipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.CRIMSON_SKELETON_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.WARPED_SKELETON_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SNOWY_SKELETON_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SNOWY_ZOMBIE_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY_EQUIPMENT.addTo(babyBipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.FROZEN_SKELETON_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.FROZEN_ZOMBIE_EQUIPMENT.addTo(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.FROZEN_ZOMBIE_BABY_EQUIPMENT.addTo(babyBipedEquipmentModelData, builder);

        builder.build().entrySet().forEach(
                entry -> EntityModelLayerRegistry.registerModelLayer(entry.getKey(), entry::getValue)
        );
    }

    private static @NotNull TexturedModelData bipedTexturedModelData64x32(Dilation dilation) {
        return TexturedModelData.of(
                BipedEntityModel.getModelData(dilation, 0.0f),
                64,
                32
        );
    }

    private static TexturedModelData zombieTexturedModelData(Dilation dilation, int height) {
        return TexturedModelData.of(
                ZombieEntityModel.getModelData(dilation, 0f),
                64,
                height
        );
    }
}
