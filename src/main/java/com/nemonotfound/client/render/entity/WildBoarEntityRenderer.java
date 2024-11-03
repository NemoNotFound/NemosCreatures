package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.client.render.entity.model.WildBoarEntityModel;
import com.nemonotfound.entity.mob.WildBoarEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class WildBoarEntityRenderer extends MobEntityRenderer<WildBoarEntity, WildBoarEntityModel<WildBoarEntity>> {
    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/pig/wild_boar.png");

    public WildBoarEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WildBoarEntityModel<>(context.getPart(ModEntityModelLayers.WILD_BOAR)), 0.7f);
    }

    @Override
    public Identifier getTexture(WildBoarEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(WildBoarEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
