package com.nemonotfound.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class NecromancerOverlayGlowFeatureRenderer<T extends MobEntity & RangedAttackMob>
        extends EyesFeatureRenderer<T, SkeletonEntityModel<T>> {

    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(MOD_ID, "textures/entity/skeleton/necromancer_overlay_glow.png"));
    private final SkeletonEntityModel<T> model;


    public NecromancerOverlayGlowFeatureRenderer(FeatureRendererContext<T, SkeletonEntityModel<T>> featureRendererContext, EntityModelLoader modelLoader, EntityModelLayer necromancerOuter) {
        super(featureRendererContext);
        this.model = new SkeletonEntityModel<>(modelLoader.getModelPart(necromancerOuter));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        this.getContextModel().copyStateTo(model);
        model.animateModel(entity, limbAngle, limbDistance, tickDelta);
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getEyesTexture());
        model.render(matrices, vertexConsumer, 0xF00000, LivingEntityRenderer.getOverlay(entity, 0.0f));
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }


}
