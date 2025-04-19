package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers.FROZEN_SPIDER;

public class FrozenSpiderEntityRenderer<T extends SpiderEntity> extends MobEntityRenderer<T, LivingEntityRenderState, SpiderEntityModel> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/spider/frozen_spider.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/spider/frozen_spider_eyes.png";

    public FrozenSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SpiderEntityModel(context.getPart(FROZEN_SPIDER)), 0.8F);
        this.addFeature(new CustomSpiderEyesFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
