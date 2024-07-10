package com.nemonotfound.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class NecromancerGlowFeatureRenderer<T extends MobEntity & RangedAttackMob>
        extends EyesFeatureRenderer<T, SkeletonEntityModel<T>> {

    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(MOD_ID, "textures/entity/skeleton/necromancer_glow.png"));

    public NecromancerGlowFeatureRenderer(FeatureRendererContext<T, SkeletonEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);

    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
