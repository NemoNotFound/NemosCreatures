package com.nemonotfound.client.render.entity;

import com.nemonotfound.entity.mob.VenomousSpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.client.render.entity.model.ModEntityModelLayers.VENOMOUS_SPIDER;

public class VenomousSpiderEntityRenderer extends SpiderEntityRenderer<VenomousSpiderEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/spider/venomous_spider.png");
    private static final float SCALE = 0.8f;

    public VenomousSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, VENOMOUS_SPIDER);
        this.shadowRadius *= SCALE;
    }

    @Override
    protected void scale(VenomousSpiderEntity venomousSpiderEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(SCALE, SCALE, SCALE);
    }

    @Override
    public Identifier getTexture(VenomousSpiderEntity venomousSpiderEntity) {
        return TEXTURE;
    }
}
