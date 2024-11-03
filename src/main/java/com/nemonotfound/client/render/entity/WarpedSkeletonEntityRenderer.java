package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class WarpedSkeletonEntityRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/warped_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/warped_skeleton_glow.png";

    public WarpedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.WARPED_SKELETON, ModEntityModelLayers.WARPED_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.WARPED_SKELETON_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
