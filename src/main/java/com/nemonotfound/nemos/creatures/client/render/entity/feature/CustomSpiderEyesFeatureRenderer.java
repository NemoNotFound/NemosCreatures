package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class CustomSpiderEyesFeatureRenderer<M extends SpiderEntityModel> extends EyesFeatureRenderer<LivingEntityRenderState, M> {

    private final RenderLayer eyes;

    public CustomSpiderEyesFeatureRenderer(FeatureRendererContext<LivingEntityRenderState, M> featureRendererContext, String path) {
        super(featureRendererContext);
        eyes = RenderLayer.getEyes(Identifier.of(MOD_ID, path));
    }

    public RenderLayer getEyesTexture() {
        return eyes;
    }
}
