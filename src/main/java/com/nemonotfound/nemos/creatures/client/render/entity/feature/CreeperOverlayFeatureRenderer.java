package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.entity.state.CreeperEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CreeperOverlayFeatureRenderer<S extends CreeperEntityRenderState, M extends EntityModel<S>> extends FeatureRenderer<S, M> {
    private final CreeperEntityModel outerModel;
    private final Identifier texture;

    public CreeperOverlayFeatureRenderer(FeatureRendererContext<S, M> context, LoadedEntityModels loader, EntityModelLayer layer, Identifier texture) {
        super(context);
        this.texture = texture;
        this.outerModel = new CreeperEntityModel(loader.getModelPart(layer));
    }



    @Override
    public void render(MatrixStack matrixStack, OrderedRenderCommandQueue queue, int light, S zombieEntityRenderState, float limbAngle, float limbDistance) {
        render(outerModel, this.texture, matrixStack, queue, light, zombieEntityRenderState, -1, 1);
    }
}
