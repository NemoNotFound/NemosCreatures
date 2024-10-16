package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.entity.mob.ScorchedSkeletonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class ScorchedSkeletonEntityRenderer extends SkeletonEntityRenderer<ScorchedSkeletonEntity> {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/scorched_skeleton.png");

    public ScorchedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SCORCHED_SKELETON,ModEntityModelLayers.SCORCHED_SKELETON_INNER_ARMOR,
                ModEntityModelLayers.SCORCHED_SKELETON_OUTER_ARMOR);
    }

    @Override
    public Identifier getTexture(ScorchedSkeletonEntity scorchedSkeletonEntity) {
        return TEXTURE;
    }
}
