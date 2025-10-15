package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.FrozenZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EquipmentModelData;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class FrozenZombieEntityRenderer extends ZombieBaseEntityRenderer<FrozenZombieEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/frozen_zombie.png");

    public FrozenZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, CreaturesEntityModelLayers.FROZEN_ZOMBIE, CreaturesEntityModelLayers.FROZEN_ZOMBIE_BABY, CreaturesEntityModelLayers.FROZEN_ZOMBIE_EQUIPMENT, CreaturesEntityModelLayers.FROZEN_ZOMBIE_BABY_EQUIPMENT);
    }

    public FrozenZombieEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EquipmentModelData<EntityModelLayer> equipmentModelData, EquipmentModelData<EntityModelLayer> babyEquipmentModelData) {
        super(
                context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                EquipmentModelData.mapToEntityModel(equipmentModelData, context.getEntityModels(), ZombieEntityModel::new),
                EquipmentModelData.mapToEntityModel(babyEquipmentModelData, context.getEntityModels(), ZombieEntityModel::new)
        );
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
