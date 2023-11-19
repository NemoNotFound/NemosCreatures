package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import com.nemonotfound.client.render.entity.feature.VenomousSkeletonOverlayFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class VenomousSkeletonEntityRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/venomous_skeleton.png");

    public VenomousSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, NemosCreaturesClient.VENOMOUS_SKELETON,NemosCreaturesClient.VENOMOUS_SKELETON__INNER_ARMOR,
                NemosCreaturesClient.VENOMOUS_SKELETON_OUTER_ARMOR);
        this.addFeature(new VenomousSkeletonOverlayFeatureRenderer<>(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
