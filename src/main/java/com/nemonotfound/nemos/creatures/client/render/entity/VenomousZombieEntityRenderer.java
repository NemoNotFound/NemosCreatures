package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.ZombieOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.VenomousZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class VenomousZombieEntityRenderer extends ZombieBaseEntityRenderer<VenomousZombieEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/venomous_zombie.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/venomous_zombie_overlay.png");

    public VenomousZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.VENOMOUS_ZOMBIE, ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY, ModEntityModelLayers.VENOMOUS_ZOMBIE_INNER_ARMOR, ModEntityModelLayers.VENOMOUS_ZOMBIE_OUTER_ARMOR, ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY_INNER_ARMOR, ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER_ARMOR);
    }

    public VenomousZombieEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EntityModelLayer innerArmor, EntityModelLayer outerArmor, EntityModelLayer babyInnerArmor, EntityModelLayer babyOuterArmor) {
        super(context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                new ZombieEntityModel<>(context.getPart(innerArmor)),
                new ZombieEntityModel<>(context.getPart(outerArmor)),
                new ZombieEntityModel<>(context.getPart(babyInnerArmor)),
                new ZombieEntityModel<>(context.getPart(babyOuterArmor)));
        this.addFeature(new ZombieOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.VENOMOUS_ZOMBIE_OUTER, ModEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public ZombieEntityRenderState createRenderState() {
        return new ZombieEntityRenderState();
    }

    @Override
    public Identifier getTexture(ZombieEntityRenderState state) {
        return TEXTURE;
    }
}
