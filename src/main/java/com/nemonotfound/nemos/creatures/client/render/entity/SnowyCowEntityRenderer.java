package com.nemonotfound.nemos.creatures.client.render.entity;

import net.minecraft.client.render.entity.CowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.CowEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class SnowyCowEntityRenderer extends CowEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/cow/snowy_cow.png");

    public SnowyCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CowEntityRenderState livingEntityRenderState) {
        return TEXTURE;
    }
}
