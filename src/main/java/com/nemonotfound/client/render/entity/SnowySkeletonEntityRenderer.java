package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.SnowySkeletonEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SnowySkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<SnowySkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/snowy_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/snowy_skeleton_glow.png";

    public SnowySkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SNOWY_SKELETON, ModEntityModelLayers.SNOWY_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.SNOWY_SKELETON_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
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
