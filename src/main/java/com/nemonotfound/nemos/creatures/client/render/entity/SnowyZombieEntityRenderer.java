package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.ZombieOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.SnowyZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EquipmentModelData;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class SnowyZombieEntityRenderer extends ZombieBaseEntityRenderer<SnowyZombieEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/snowy_zombie.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/snowy_zombie_overlay.png");

    public SnowyZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, CreaturesEntityModelLayers.SNOWY_ZOMBIE, CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY, CreaturesEntityModelLayers.SNOWY_ZOMBIE_EQUIPMENT, CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY_EQUIPMENT);
    }

    public SnowyZombieEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EquipmentModelData<EntityModelLayer> equipmentModelData, EquipmentModelData<EntityModelLayer> babyEquipmentModelData) {
        super(
                context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                EquipmentModelData.mapToEntityModel(equipmentModelData, context.getEntityModels(), ZombieEntityModel::new),
                EquipmentModelData.mapToEntityModel(babyEquipmentModelData, context.getEntityModels(), ZombieEntityModel::new)
        );
        this.addFeature(new ZombieOverlayFeatureRenderer<>(this, context.getEntityModels(), CreaturesEntityModelLayers.SNOWY_ZOMBIE_OUTER, CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY_OUTER, OVERLAY_TEXTURE));
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
