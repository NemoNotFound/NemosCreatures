package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.ZombieOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.MummyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EquipmentModelData;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class MummyEntityRenderer extends ZombieBaseEntityRenderer<MummyEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/mummy.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/zombie/mummy_overlay.png");

    public MummyEntityRenderer(EntityRendererFactory.Context context) {
        this(context, CreaturesEntityModelLayers.MUMMY, CreaturesEntityModelLayers.MUMMY_BABY, CreaturesEntityModelLayers.MUMMY_EQUIPMENT, CreaturesEntityModelLayers.MUMMY_BABY_EQUIPMENT);
    }

    public MummyEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EquipmentModelData<EntityModelLayer> equipmentModelData, EquipmentModelData<EntityModelLayer> babyEquipmentModelData) {
        super(
                context,
                new ZombieEntityModel<>(context.getPart(body)),
                new ZombieEntityModel<>(context.getPart(baby)),
                EquipmentModelData.mapToEntityModel(equipmentModelData, context.getEntityModels(), ZombieEntityModel::new),
                EquipmentModelData.mapToEntityModel(babyEquipmentModelData, context.getEntityModels(), ZombieEntityModel::new)
        );
        this.addFeature(new ZombieOverlayFeatureRenderer<>(this, context.getEntityModels(), CreaturesEntityModelLayers.MUMMY_OUTER, CreaturesEntityModelLayers.MUMMY_BABY_OUTER, OVERLAY_TEXTURE));
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
