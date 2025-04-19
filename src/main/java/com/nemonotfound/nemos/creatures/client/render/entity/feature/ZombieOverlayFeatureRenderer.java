package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ZombieOverlayFeatureRenderer<S extends ZombieEntityRenderState, M extends EntityModel<S>> extends FeatureRenderer<S, M> {
    private final ZombieEntityModel<S> outerModel;
    private final ZombieEntityModel<S> babyOuterModel;
    private final Identifier texture;

    public ZombieOverlayFeatureRenderer(FeatureRendererContext<S, M> context, LoadedEntityModels loader, EntityModelLayer layer, EntityModelLayer babyLayer, Identifier texture) {
        super(context);
        this.texture = texture;
        this.outerModel = new ZombieEntityModel<>(loader.getModelPart(layer));
        this.babyOuterModel = new ZombieEntityModel<>(loader.getModelPart(babyLayer));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, S zombieEntityRenderState, float limbAngle, float limbDistance) {
        render(getModel(zombieEntityRenderState), this.texture, matrixStack, vertexConsumerProvider, light, zombieEntityRenderState, -1);
    }

    private ZombieEntityModel<S> getModel(S state) {
        return state.baby ? this.babyOuterModel : this.outerModel;
    }
}
