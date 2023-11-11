package com.nemonotfound.client.render.entity;

import com.nemonotfound.NemosCreaturesClient;
import com.nemonotfound.client.render.entity.feature.VenomOverlayFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class VenomEntityRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/skeleton/venom.png");

    public VenomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, NemosCreaturesClient.VENOM,NemosCreaturesClient.VENOM_INNER_ARMOR, NemosCreaturesClient.VENOM_OUTER_ARMOR);
        this.addFeature(new VenomOverlayFeatureRenderer<>(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }
}
