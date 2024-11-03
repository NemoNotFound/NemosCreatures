package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CustomSpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.client.render.entity.model.ModEntityModelLayers.ICE_SPIDER;

public class IceSpiderEntityRenderer<T extends SpiderEntity> extends MobEntityRenderer<T, LivingEntityRenderState, SpiderEntityModel> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/spider/ice_spider.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/spider/ice_spider_eyes.png";
    private static final float SCALE = 0.4f;

    public IceSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SpiderEntityModel(context.getPart(ICE_SPIDER)), 0.8F);
        this.addFeature(new CustomSpiderEyesFeatureRenderer<>(this, EYES_TEXTURE_PATH));
        this.shadowRadius *= SCALE;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    protected void scale(LivingEntityRenderState state, MatrixStack matrices) {
        matrices.scale(SCALE, SCALE, SCALE);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
