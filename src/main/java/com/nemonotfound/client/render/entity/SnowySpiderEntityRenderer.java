package com.nemonotfound.client.render.entity;

import com.nemonotfound.entity.mob.SnowySpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.client.render.entity.model.ModEntityModelLayers.SNOWY_SPIDER;

public class SnowySpiderEntityRenderer extends SpiderEntityRenderer<SnowySpiderEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/spider/snowy_spider.png");

    public SnowySpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, SNOWY_SPIDER);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
