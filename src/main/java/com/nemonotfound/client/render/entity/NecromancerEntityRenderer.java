package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import com.nemonotfound.client.render.entity.feature.NecromancerGlowFeatureRenderer;
import com.nemonotfound.client.render.entity.feature.NecromancerOverlayGlowFeatureRenderer;
import com.nemonotfound.entity.mob.NecromancerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.feature.SkeletonOverlayFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.NemosCreaturesClient.NECROMANCER_CAPE;
import static com.nemonotfound.NemosCreaturesClient.NECROMANCER_OUTER;

public class NecromancerEntityRenderer extends SkeletonEntityRenderer<NecromancerEntity> {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/necromancer.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/necromancer_overlay.png");
    private static final Identifier CAPE_TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/necromancer_cape.png");

    public NecromancerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, NemosCreaturesClient.NECROMANCER, NemosCreaturesClient.SCORCHED_SKELETON_INNER_ARMOR,
                NemosCreaturesClient.SCORCHED_SKELETON_OUTER_ARMOR);
        this.addFeature(new SkeletonOverlayFeatureRenderer<>(this, context.getModelLoader(), NECROMANCER_OUTER, OVERLAY_TEXTURE));
        this.addFeature(new SkeletonOverlayFeatureRenderer<>(this, context.getModelLoader(), NECROMANCER_CAPE, CAPE_TEXTURE));
        this.addFeature(new NecromancerGlowFeatureRenderer<>(this));
        this.addFeature(new NecromancerOverlayGlowFeatureRenderer<>(this, context.getModelLoader(), NECROMANCER_OUTER));
    }

    @Override
    public Identifier getTexture(NecromancerEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(NecromancerEntity entity, MatrixStack matrixStack, float f) {
        matrixStack.scale(1.4f, 1.4f, 1.4f);
    }
}
