package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.SnowyZombieEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SnowyZombieEntityRenderer extends BipedEntityRenderer<SnowyZombieEntity, ZombieEntityModel<SnowyZombieEntity>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/snowy_zombie.png");

    public SnowyZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.SNOWY_ZOMBIE,  ModEntityModelLayers.SNOWY_ZOMBIE_INNER_ARMOR,  ModEntityModelLayers.SNOWY_ZOMBIE_OUTER_ARMOR);
    }

    public SnowyZombieEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer body, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(body)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new ZombieEntityModel<>(ctx.getPart(legsArmorLayer)),
                new ZombieEntityModel<>(ctx.getPart(bodyArmorLayer)), ctx.getModelManager()));
    }

    @Override
    public Identifier getTexture(SnowyZombieEntity entity) {
        return TEXTURE;
    }
}
