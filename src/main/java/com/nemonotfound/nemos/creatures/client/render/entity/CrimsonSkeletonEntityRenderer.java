package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.CrimsonSkeletonEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class CrimsonSkeletonEntityRenderer extends AbstractSkeletonEntityRenderer<CrimsonSkeletonEntity, SkeletonEntityRenderState> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/crimson_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/crimson_skeleton_glow.png";

    public CrimsonSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.CRIMSON_SKELETON, ModEntityModelLayers.CRIMSON_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.CRIMSON_SKELETON_OUTER_ARMOR);
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
