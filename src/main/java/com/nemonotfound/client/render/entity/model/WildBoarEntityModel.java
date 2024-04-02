package com.nemonotfound.client.render.entity.model;

import com.nemonotfound.client.render.entity.animation.Animations;
import com.nemonotfound.entity.mob.WildBoarEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class WildBoarEntityModel<T extends WildBoarEntity> extends SinglePartEntityModel<T> {

    private final ModelPart wildBoar;
    private final ModelPart head;

    public WildBoarEntityModel(ModelPart root) {
        this.wildBoar = root.getChild("wild_boar");
        this.head = wildBoar.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData wildBoarModelPartData = modelPartData.addChild("wild_boar", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 8.0F, -7.0F));
        wildBoarModelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, 2.0F, -2.0F, 10.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData head = wildBoarModelPartData.addChild("head", ModelPartBuilder.create().uv(0, 24).cuboid(-4.0F, 0.0F, -8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(36, 10).cuboid(-3.0F, 4.0F, -11.0F, 6.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        head.addChild("horn_right", ModelPartBuilder.create().uv(0, 10).cuboid(-5.0F, -11.0F, -17.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.0F, -13.0F, -17.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 7.0F));
        head.addChild("horn_left", ModelPartBuilder.create().uv(6, 10).cuboid(3.0F, -11.0F, -17.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(11, 11).cuboid(4.0F, -13.0F, -17.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 7.0F));
        ModelPartData legs = wildBoarModelPartData.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 7.0F));
        legs.addChild("back_right", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -6.0F, 6.0F));
        legs.addChild("front_right", ModelPartBuilder.create().uv(32, 24).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -6.0F, -6.0F));
        legs.addChild("back_left", ModelPartBuilder.create().uv(36, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -6.0F, 6.0F));
        legs.addChild("front_left", ModelPartBuilder.create().uv(32, 34).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -6.0F, -6.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(WildBoarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(Animations.WILD_BOAR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, Animations.WILD_BOAR_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, Animations.WILD_BOAR_ATTACK, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        wildBoar.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return wildBoar;
    }
}