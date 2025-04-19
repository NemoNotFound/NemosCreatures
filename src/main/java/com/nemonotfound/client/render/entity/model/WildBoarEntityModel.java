package com.nemonotfound.client.render.entity.model;

import com.nemonotfound.client.render.entity.animation.Animations;
import com.nemonotfound.client.render.entity.state.WildBoarEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

public class WildBoarEntityModel extends QuadrupedEntityModel<WildBoarEntityRenderState> {

    public WildBoarEntityModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -14.0F, -9.0F, 10.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData back = body.addChild("back", ModelPartBuilder.create(), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
        back.addChild("cube_r1", ModelPartBuilder.create().uv(20, 28).cuboid(-2.6889F, -15.0301F, -6.0F, 3.0F, 1.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-1.6889F, -16.0301F, -6.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 24).cuboid(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(38, 34).cuboid(-3.0F, 0.0F, -10.0F, 6.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(36, 0).cuboid(-1.6889F, -5.0301F, -8.0F, 3.0F, 3.0F, 10.0F, new Dilation(0.0F))
                .uv(32, 41).cuboid(-0.6889F, -6.0301F, -7.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 12.0F, -8.0F));
        head.addChild("horn_right", ModelPartBuilder.create().uv(7, 10).cuboid(-5.0F, -11.0F, -17.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.0F, -13.0F, -17.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 12.0F, 8.0F, 0.0F, 0.0F, -0.0873F));
        head.addChild("horn_left", ModelPartBuilder.create().uv(7, 12).cuboid(3.0F, -11.0F, -17.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(4.0F, -13.0F, -17.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0873F));

        modelPartData.addChild("right_hind_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-3.0F, 18.0F, 6.0F));
        modelPartData.addChild("left_hind_leg", ModelPartBuilder.create().uv(16, 41).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(3.0F, 18.0F, 6.0F));
        modelPartData.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 40).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(3.0F, 18.0F, -6.0F));
        modelPartData.addChild("right_front_leg", ModelPartBuilder.create().uv(38, 24).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-3.0F, 18.0F, -6.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(WildBoarEntityRenderState wildBoarEntityRenderState) {
        super.setAngles(wildBoarEntityRenderState);

        this.animate(wildBoarEntityRenderState.idleAnimationState, Animations.WILD_BOAR_IDLE, wildBoarEntityRenderState.age, 1f);
        this.animate(wildBoarEntityRenderState.attackAnimationState, Animations.WILD_BOAR_ATTACK, wildBoarEntityRenderState.age, 1f);
    }
}