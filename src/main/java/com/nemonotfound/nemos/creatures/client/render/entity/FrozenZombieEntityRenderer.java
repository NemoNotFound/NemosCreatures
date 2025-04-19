package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.FrozenZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class FrozenZombieEntityRenderer extends ZombieBaseEntityRenderer<FrozenZombieEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/frozen_zombie.png");

    public FrozenZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.FROZEN_ZOMBIE, ModEntityModelLayers.FROZEN_ZOMBIE_BABY, ModEntityModelLayers.FROZEN_ZOMBIE_INNER_ARMOR, ModEntityModelLayers.FROZEN_ZOMBIE_OUTER_ARMOR, ModEntityModelLayers.FROZEN_ZOMBIE_BABY_INNER_ARMOR, ModEntityModelLayers.FROZEN_ZOMBIE_BABY_OUTER_ARMOR);
    }

    public FrozenZombieEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EntityModelLayer innerArmor, EntityModelLayer outerArmor, EntityModelLayer babyInnerArmor, EntityModelLayer babyOuterArmor) {
        super(context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                new ZombieEntityModel<>(context.getPart(innerArmor)),
                new ZombieEntityModel<>(context.getPart(outerArmor)),
                new ZombieEntityModel<>(context.getPart(babyInnerArmor)),
                new ZombieEntityModel<>(context.getPart(babyOuterArmor)));
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
