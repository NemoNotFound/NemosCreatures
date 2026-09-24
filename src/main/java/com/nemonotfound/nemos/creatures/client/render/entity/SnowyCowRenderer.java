package com.nemonotfound.nemos.creatures.client.render.entity;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.CowRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class SnowyCowRenderer extends CowRenderer {

    private static final Identifier ADULT_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/cow/snowy_cow.png");
    private static final Identifier BABY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/cow/snowy_cow_baby.png");

    public SnowyCowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull CowRenderState cowRenderState) {
        return cowRenderState.isBaby ? BABY_TEXTURE : ADULT_TEXTURE;
    }
}
