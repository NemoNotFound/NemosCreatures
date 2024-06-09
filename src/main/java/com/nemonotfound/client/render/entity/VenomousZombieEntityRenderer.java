package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import com.nemonotfound.entity.mob.VenomousZombieEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class VenomousZombieEntityRenderer extends BipedEntityRenderer<VenomousZombieEntity, ZombieEntityModel<VenomousZombieEntity>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/venomous_zombie.png");

    public VenomousZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, NemosCreaturesClient.VENOMOUS_ZOMBIE,  NemosCreaturesClient.VENOMOUS_ZOMBIE_INNER_ARMOR,  NemosCreaturesClient.VENOMOUS_ZOMBIE_OUTER_ARMOR);
    }

    public VenomousZombieEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer body, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new ZombieEntityModel(ctx.getPart(body)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer(this, new ZombieEntityModel(ctx.getPart(legsArmorLayer)),
                new ZombieEntityModel(ctx.getPart(bodyArmorLayer)), ctx.getModelManager()));
    }

    @Override
    public Identifier getTexture(VenomousZombieEntity entity) {
        return TEXTURE;
    }
}
