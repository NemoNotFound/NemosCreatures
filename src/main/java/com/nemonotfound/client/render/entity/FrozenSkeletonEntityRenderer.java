package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.FrozenSkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.FrozenSkeletonEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class FrozenSkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<FrozenSkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/frozen_skeleton.png");

    public FrozenSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.FROZEN_SKELETON, ModEntityModelLayers.FROZEN_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.FROZEN_SKELETON_OUTER_ARMOR);
        this.addFeature(new FrozenSkeletonGlowFeatureRenderer<>(this));
    }

    @Override
    public SkeletonEntityRenderState createRenderState() {
        return new SkeletonEntityRenderState();
    }

    @Override
    public Identifier getTexture(SkeletonEntityRenderState state) {
        return TEXTURE;
    }
}
