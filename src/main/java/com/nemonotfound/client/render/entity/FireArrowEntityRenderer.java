package com.nemonotfound.client.render.entity;

import com.nemonotfound.entity.projectile.FireArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class FireArrowEntityRenderer extends ProjectileEntityRenderer<FireArrowEntity> {

    public static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/projectiles/fire_arrow.png");

    public FireArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(FireArrowEntity arrowEntity) {
        return TEXTURE;
    }

}
