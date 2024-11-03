package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.FrozenZombieEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class FrozenZombieEntityRenderer extends BipedEntityRenderer<FrozenZombieEntity, ZombieEntityModel<FrozenZombieEntity>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/frozen_zombie.png");

    public FrozenZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.FROZEN_ZOMBIE,  ModEntityModelLayers.FROZEN_ZOMBIE_INNER_ARMOR,  ModEntityModelLayers.FROZEN_ZOMBIE_OUTER_ARMOR);
    }

    public FrozenZombieEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer body, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(body)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new ZombieEntityModel<>(ctx.getPart(legsArmorLayer)),
                new ZombieEntityModel<>(ctx.getPart(bodyArmorLayer)), ctx.getModelManager()));
    }

    @Override
    public Identifier getTexture(FrozenZombieEntity entity) {
        return TEXTURE;
    }
}
