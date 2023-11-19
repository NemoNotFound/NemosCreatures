package com.nemonotfound.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.NemosCreaturesClient.VENOMOUS_SKELETON_OUTER;

@Environment(value= EnvType.CLIENT)
public class VenomousSkeletonOverlayFeatureRenderer<T extends MobEntity & RangedAttackMob, M extends EntityModel<T>>
        extends FeatureRenderer<T, M> {

    private static final Identifier SKIN = new Identifier(MOD_ID, "textures/entity/skeleton/venomous_skeleton_overlay.png");
    private final SkeletonEntityModel<T> model;

    public VenomousSkeletonOverlayFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new SkeletonEntityModel(loader.getModelPart(VENOMOUS_SKELETON_OUTER));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        VenomousSkeletonOverlayFeatureRenderer.render(this.getContextModel(), this.model, SKIN, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, tickDelta, 1.0f, 1.0f, 1.0f);
    }
}
