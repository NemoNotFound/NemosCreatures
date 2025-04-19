package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CreeperOverlayFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.CreeperEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class SnowyCreeperEntityRenderer extends CreeperEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/creeper/snowy_creeper.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/creeper/snowy_creeper_overlay.png");

    public SnowyCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new CreeperOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.SNOWY_CREEPER_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public Identifier getTexture(CreeperEntityRenderState creeperEntityRenderState) {
        return TEXTURE;
    }
}
