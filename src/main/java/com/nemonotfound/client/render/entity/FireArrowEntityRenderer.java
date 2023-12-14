package com.nemonotfound.client.render.entity;

import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class FireArrowEntityRenderer extends ArrowEntityRenderer {

    public static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/projectiles/fire_arrow.png");
    public static final Identifier TIPPED_TEXTURE = new Identifier(MOD_ID, "textures/entity/projectiles/tipped_fire_arrow.png");

    public FireArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ArrowEntity arrowEntity) {
        return arrowEntity.getColor() > 0 ? TIPPED_TEXTURE : TEXTURE;
    }

}
