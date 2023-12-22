package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class WarpedSkeletonEntityRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/warped_skeleton.png");

    public WarpedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, NemosCreaturesClient.WARPED_SKELETON,NemosCreaturesClient.WARPED_SKELETON_INNER_ARMOR,
                NemosCreaturesClient.WARPED_SKELETON_OUTER_ARMOR);
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
