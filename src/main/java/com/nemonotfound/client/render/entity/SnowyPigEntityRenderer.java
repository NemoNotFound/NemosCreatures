package com.nemonotfound.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SnowyPigEntityRenderer extends PigEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/pig/snowy_pig.png");

    public SnowyPigEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(PigEntity entity) {
        return TEXTURE;
    }
}
