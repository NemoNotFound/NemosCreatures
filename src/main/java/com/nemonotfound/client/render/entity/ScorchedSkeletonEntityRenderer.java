package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class ScorchedSkeletonEntityRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/skeleton/scorched_skeleton.png");

    public ScorchedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, NemosCreaturesClient.SCORCHED_SKELETON,NemosCreaturesClient.SCORCHED_SKELETON_INNER_ARMOR,
                NemosCreaturesClient.SCORCHED_SKELETON_OUTER_ARMOR);
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
