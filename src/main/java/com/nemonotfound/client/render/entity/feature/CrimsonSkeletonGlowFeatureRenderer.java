package com.nemonotfound.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class CrimsonSkeletonGlowFeatureRenderer<M extends SkeletonEntityModel<SkeletonEntityRenderState>>
        extends EyesFeatureRenderer<SkeletonEntityRenderState, M> {

    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(MOD_ID, "textures/entity/skeleton/crimson_skeleton_glow.png"));

    public CrimsonSkeletonGlowFeatureRenderer(FeatureRendererContext<SkeletonEntityRenderState, M> featureRendererContext) {
        super(featureRendererContext);

    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
