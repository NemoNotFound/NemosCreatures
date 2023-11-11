package com.nemonotfound;

import com.nemonotfound.client.render.entity.VenomEntityRenderer;
import com.nemonotfound.client.render.entity.feature.VenomOverlayFeatureRenderer;
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
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(EnvType.CLIENT)
public class NemosCreaturesClient implements ClientModInitializer {

    public static final EntityModelLayer VENOM = new EntityModelLayer(new Identifier(MOD_ID, "venom"), "main");
    public static final EntityModelLayer VENOM_INNER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venom"), "inner_armor");
    public static final EntityModelLayer VENOM_OUTER_ARMOR = new EntityModelLayer(new Identifier(MOD_ID, "venom"), "outer_armor");
    public static final EntityModelLayer VENOM_OUTER = new EntityModelLayer(new Identifier(MOD_ID, "venom"), "outer");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(NemosCreatures.VENOM, VenomEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VENOM, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOM_INNER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOM_OUTER_ARMOR, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VENOM_OUTER, () -> TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.25f), 0.0f), 64, 32));
    }
}
