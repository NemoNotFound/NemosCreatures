package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.FrozenSkeletonEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class FrozenSkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<FrozenSkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/frozen_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/frozen_skeleton_glow.png";

    public FrozenSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.FROZEN_SKELETON, ModEntityModelLayers.FROZEN_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.FROZEN_SKELETON_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
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
