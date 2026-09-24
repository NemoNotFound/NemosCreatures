package com.nemonotfound.nemos.creatures.client.render.entity;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.client.renderer.entity.state.PigRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class SnowyPigRenderer extends PigRenderer {

    private static final Identifier ADULT_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/pig/snowy_pig.png");
    private static final Identifier BABY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/pig/snowy_pig_baby.png");

    public SnowyPigRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull PigRenderState pigRenderState) {
        return pigRenderState.isBaby ? BABY_TEXTURE : ADULT_TEXTURE;
    }
}
