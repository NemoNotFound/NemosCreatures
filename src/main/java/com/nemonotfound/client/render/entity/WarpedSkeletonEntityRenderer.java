package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import com.nemonotfound.client.render.entity.feature.WarpedSkeletonGlowFeatureRenderer;
import com.nemonotfound.entity.mob.WarpedSkeletonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class WarpedSkeletonEntityRenderer extends SkeletonEntityRenderer<WarpedSkeletonEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/warped_skeleton.png");

    public WarpedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, NemosCreaturesClient.WARPED_SKELETON,NemosCreaturesClient.WARPED_SKELETON_INNER_ARMOR,
                NemosCreaturesClient.WARPED_SKELETON_OUTER_ARMOR);
        this.addFeature(new WarpedSkeletonGlowFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(WarpedSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
