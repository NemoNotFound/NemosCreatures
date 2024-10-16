package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.SnowySkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.SnowySkeletonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SnowySkeletonEntityRenderer extends SkeletonEntityRenderer<SnowySkeletonEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/snowy_skeleton.png");

    public SnowySkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SNOWY_SKELETON, ModEntityModelLayers.SNOWY_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.SNOWY_SKELETON_OUTER_ARMOR);
        this.addFeature(new SnowySkeletonGlowFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(SnowySkeletonEntity snowySkeletonEntity) {
        return TEXTURE;
    }
}
