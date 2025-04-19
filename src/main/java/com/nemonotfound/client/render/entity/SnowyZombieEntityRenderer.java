package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.ZombieOverlayFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.SnowyZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SnowyZombieEntityRenderer extends ZombieBaseEntityRenderer<SnowyZombieEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/snowy_zombie.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/snowy_zombie_overlay.png");

    public SnowyZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.SNOWY_ZOMBIE, ModEntityModelLayers.SNOWY_ZOMBIE_BABY, ModEntityModelLayers.SNOWY_ZOMBIE_INNER_ARMOR, ModEntityModelLayers.SNOWY_ZOMBIE_OUTER_ARMOR, ModEntityModelLayers.SNOWY_ZOMBIE_BABY_INNER_ARMOR, ModEntityModelLayers.SNOWY_ZOMBIE_BABY_OUTER_ARMOR);
    }

    public SnowyZombieEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EntityModelLayer innerArmor, EntityModelLayer outerArmor, EntityModelLayer babyInnerArmor, EntityModelLayer babyOuterArmor) {
        super(context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                new ZombieEntityModel<>(context.getPart(innerArmor)),
                new ZombieEntityModel<>(context.getPart(outerArmor)),
                new ZombieEntityModel<>(context.getPart(babyInnerArmor)),
                new ZombieEntityModel<>(context.getPart(babyOuterArmor)));
        this.addFeature(new ZombieOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.SNOWY_ZOMBIE_OUTER, ModEntityModelLayers.SNOWY_ZOMBIE_BABY_OUTER, OVERLAY_TEXTURE));
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
