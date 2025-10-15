package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.client.render.entity.model.WildBoarEntityModel;
import com.nemonotfound.nemos.creatures.client.render.entity.state.WildBoarEntityRenderState;
import com.nemonotfound.nemos.creatures.entity.mob.WildBoarEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class WildBoarEntityRenderer extends AgeableMobEntityRenderer<WildBoarEntity, WildBoarEntityRenderState, WildBoarEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/pig/wild_boar.png");

    public WildBoarEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WildBoarEntityModel(context.getPart(CreaturesEntityModelLayers.WILD_BOAR)), new WildBoarEntityModel(context.getPart(CreaturesEntityModelLayers.WILD_BOAR_BABY)), 0.7f);
    }

    @Override
    public Identifier getTexture(WildBoarEntityRenderState wildBoarEntityRenderState) {
        return TEXTURE;
    }

    @Override
    public void render(WildBoarEntityRenderState wildBoarEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if(wildBoarEntityRenderState.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(wildBoarEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public WildBoarEntityRenderState createRenderState() {
        return new WildBoarEntityRenderState();
    }

    public void updateRenderState(WildBoarEntity wildBoarEntity, WildBoarEntityRenderState wildBoarEntityRenderState, float f) {
        super.updateRenderState(wildBoarEntity, wildBoarEntityRenderState, f);
        wildBoarEntityRenderState.idleAnimationState.copyFrom(wildBoarEntity.idleAnimationState);
        wildBoarEntityRenderState.attackAnimationState.copyFrom(wildBoarEntity.attackAnimationState);
    }
}
