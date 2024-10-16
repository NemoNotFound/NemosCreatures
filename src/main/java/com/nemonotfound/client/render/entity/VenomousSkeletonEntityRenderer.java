package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.VenomousSkeletonOverlayFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.VenomousSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class VenomousSkeletonEntityRenderer extends SkeletonEntityRenderer<VenomousSkeletonEntity> {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/venomous_skeleton.png");

    public VenomousSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.VENOMOUS_SKELETON, ModEntityModelLayers.VENOMOUS_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.VENOMOUS_SKELETON_OUTER_ARMOR);
        this.addFeature(new VenomousSkeletonOverlayFeatureRenderer<>(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(VenomousSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
