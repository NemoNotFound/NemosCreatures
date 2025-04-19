package com.nemonotfound.client.render.entity;

import com.nemonotfound.client.render.entity.feature.CreeperOverlayFeatureRenderer;
import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.CreeperEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class ScorchedCreeperEntityRenderer extends CreeperEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/creeper/scorched_creeper.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/creeper/scorched_creeper_overlay.png");

    public ScorchedCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new CreeperOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.SCORCHED_CREEPER_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public Identifier getTexture(CreeperEntityRenderState creeperEntityRenderState) {
        return TEXTURE;
    }
}
