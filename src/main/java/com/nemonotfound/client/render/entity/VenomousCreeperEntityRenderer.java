package com.nemonotfound.client.render.entity;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class VenomousCreeperEntityRenderer extends CreeperEntityRenderer {

    private static final Identifier TEXTURE = new Identifier(MOD_ID ,"textures/entity/creeper/venomous_creeper.png");

    public VenomousCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CreeperEntity creeperEntity) {
        return TEXTURE;
    }
}
