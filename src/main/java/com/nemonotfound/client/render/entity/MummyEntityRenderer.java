package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.MummyEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class MummyEntityRenderer extends BipedEntityRenderer<MummyEntity, ZombieEntityModel<MummyEntity>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/mummy.png");

    public MummyEntityRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.MUMMY,  ModEntityModelLayers.MUMMY_INNER_ARMOR,  ModEntityModelLayers.MUMMY_OUTER_ARMOR);
    }

    public MummyEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer body, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(body)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new ZombieEntityModel<>(ctx.getPart(legsArmorLayer)),
                new ZombieEntityModel<>(ctx.getPart(bodyArmorLayer)), ctx.getModelManager()));
    }

    @Override
    public Identifier getTexture(MummyEntity entity) {
        return TEXTURE;
    }
}
