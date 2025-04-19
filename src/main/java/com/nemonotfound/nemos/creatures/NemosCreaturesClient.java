package com.nemonotfound.nemos.creatures;

import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.nemos.creatures.client.render.entity.model.ModEntityModels;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NemosCreaturesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntityModelLayers.registerEntityModelLayers();
        ModEntityModels.bootstrap();
    }
}
