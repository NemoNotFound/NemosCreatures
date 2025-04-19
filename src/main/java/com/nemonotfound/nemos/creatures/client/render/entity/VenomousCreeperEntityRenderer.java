package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CreeperOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.CreeperEntityRenderState;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class VenomousCreeperEntityRenderer extends CreeperEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/creeper/venomous_creeper.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(MOD_ID, "textures/entity/creeper/venomous_creeper_overlay.png");

    public VenomousCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new CreeperOverlayFeatureRenderer<>(this, context.getEntityModels(), ModEntityModelLayers.VENOMOUS_CREEPER_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public Identifier getTexture(CreeperEntityRenderState creeperEntityRenderState) {
        return TEXTURE;
    }
}
