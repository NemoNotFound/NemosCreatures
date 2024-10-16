package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CustomSpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.client.render.entity.model.ModEntityModelLayers.SNOW_SPIDER;

public class SnowSpiderEntityRenderer<T extends SpiderEntity> extends MobEntityRenderer<T, SpiderEntityModel<T>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/spider/snow_spider.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/spider/snow_spider_eyes.png";
    private static final float SCALE = 0.4f;

    public SnowSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SpiderEntityModel<>(context.getPart(SNOW_SPIDER)), 0.8F);
        this.addFeature(new CustomSpiderEyesFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    protected void scale(T entity, MatrixStack matrixStack, float f) {
        matrixStack.scale(SCALE, SCALE, SCALE);
    }

    @Override
    public Identifier getTexture(T snowSpiderEntity) {
        return TEXTURE;
    }


}
