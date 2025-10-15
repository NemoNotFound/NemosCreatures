package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.ZombieOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.VenomousZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EquipmentModelData;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class VenomousZombieEntityRenderer extends ZombieBaseEntityRenderer<VenomousZombieEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/venomous_zombie.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/venomous_zombie_overlay.png");

    public VenomousZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_EQUIPMENT, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_EQUIPMENT);
    }

    public VenomousZombieEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EquipmentModelData<EntityModelLayer> equipmentModelData, EquipmentModelData<EntityModelLayer> babyEquipmentModelData) {
        super(
                context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                EquipmentModelData.mapToEntityModel(equipmentModelData, context.getEntityModels(), ZombieEntityModel::new),
                EquipmentModelData.mapToEntityModel(babyEquipmentModelData, context.getEntityModels(), ZombieEntityModel::new)
        );
        this.addFeature(new ZombieOverlayFeatureRenderer<>(this, context.getEntityModels(), CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_OUTER, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER, OVERLAY_TEXTURE));
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
