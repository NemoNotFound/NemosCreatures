package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CrimsonSkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.CrimsonSkeletonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class CrimsonSkeletonEntityRenderer extends SkeletonEntityRenderer<CrimsonSkeletonEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/crimson_skeleton.png");

    public CrimsonSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.CRIMSON_SKELETON, ModEntityModelLayers.CRIMSON_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.CRIMSON_SKELETON_OUTER_ARMOR);
        this.addFeature(new CrimsonSkeletonGlowFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(CrimsonSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
