package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.WarpedSkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.WarpedSkeletonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class WarpedSkeletonEntityRenderer extends SkeletonEntityRenderer<WarpedSkeletonEntity> {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/warped_skeleton.png");

    public WarpedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.WARPED_SKELETON, ModEntityModelLayers.WARPED_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.WARPED_SKELETON_OUTER_ARMOR);
        this.addFeature(new WarpedSkeletonGlowFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(WarpedSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
