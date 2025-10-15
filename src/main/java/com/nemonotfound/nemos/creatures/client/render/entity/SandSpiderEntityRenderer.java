package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.SandSpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class SandSpiderEntityRenderer extends SpiderEntityRenderer<SandSpiderEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/spider/sand_spider.png");
    private static final float SCALE = 0.4f;

    public SandSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, CreaturesEntityModelLayers.SAND_SPIDER);
        this.shadowRadius *= SCALE;
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    protected void scale(LivingEntityRenderState state, MatrixStack matrices) {
        matrices.scale(SCALE, SCALE, SCALE);
    }
}
