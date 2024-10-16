package com.nemonotfound.client.render.entity.feature;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class CustomSpiderEyesFeatureRenderer<T extends Entity, M extends SpiderEntityModel<T>> extends SpiderEyesFeatureRenderer<T, M> {

    private final RenderLayer eyes;

    public CustomSpiderEyesFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext, String path) {
        super(featureRendererContext);
        eyes = RenderLayer.getEyes(Identifier.of(MOD_ID, path));
    }

    public RenderLayer getEyesTexture() {
        return eyes;
    }
}
