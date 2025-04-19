package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.SnowySkeletonEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.SkeletonOverlayFeatureRenderer;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class SnowySkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<SnowySkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/snowy_skeleton.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/snowy_skeleton_overlay.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/snowy_skeleton_glow.png";

    public SnowySkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SNOWY_SKELETON, ModEntityModelLayers.SNOWY_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.SNOWY_SKELETON_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
        this.addFeature(new SkeletonOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.SNOWY_SKELETON_OUTER, OVERLAY_TEXTURE));
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
