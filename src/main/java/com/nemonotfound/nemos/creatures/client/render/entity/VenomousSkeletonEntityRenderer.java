package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.VenomousSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.SkeletonOverlayFeatureRenderer;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

@Environment(value = EnvType.CLIENT)
public class VenomousSkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<VenomousSkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/venomous_skeleton.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/venomous_skeleton_overlay.png");
    private static final Identifier OVERLAY_PANTS_TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/venomous_skeleton_overlay_pants.png");

    public VenomousSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.VENOMOUS_SKELETON, ModEntityModelLayers.VENOMOUS_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.VENOMOUS_SKELETON_OUTER_ARMOR);
        this.addFeature(new SkeletonOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.VENOMOUS_SKELETON_OUTER, OVERLAY_TEXTURE));
        this.addFeature(new SkeletonOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.VENOMOUS_SKELETON_OUTER_PANTS, OVERLAY_PANTS_TEXTURE));
    }

    @Override
    public SkeletonEntityRenderState createRenderState() {
        return new SkeletonEntityRenderState();
    }

    @Override
    public Identifier getTexture(SkeletonEntityRenderState state) {
        return TEXTURE;
    }
}
