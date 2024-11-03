package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.CrimsonSkeletonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class CrimsonSkeletonEntityRenderer extends SkeletonEntityRenderer<CrimsonSkeletonEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/crimson_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/crimson_skeleton_glow.png";

    public CrimsonSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.CRIMSON_SKELETON, ModEntityModelLayers.CRIMSON_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.CRIMSON_SKELETON_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    public Identifier getTexture(CrimsonSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
