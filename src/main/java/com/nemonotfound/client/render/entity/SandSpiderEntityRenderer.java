package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.SandSpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SandSpiderEntityRenderer extends SpiderEntityRenderer<SandSpiderEntity> {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/spider/sand_spider.png");
    private static final float SCALE = 0.4f;

    public SandSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SAND_SPIDER);
        this.shadowRadius *= SCALE;
    }

    @Override
    protected void scale(SandSpiderEntity sandSpiderEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(SCALE, SCALE, SCALE);
    }

    @Override
    public Identifier getTexture(SandSpiderEntity sandSpiderEntity) {
        return TEXTURE;
    }
}
