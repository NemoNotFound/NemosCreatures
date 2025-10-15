package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.WarpedSkeletonEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class WarpedSkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<WarpedSkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/warped_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/warped_skeleton_glow.png";

    public WarpedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, CreaturesEntityModelLayers.WARPED_SKELETON, CreaturesEntityModelLayers.WARPED_SKELETON_EQUIPMENT);
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
