package com.nemonotfound;

import com.nemonotfound.client.render.entity.model.ModEntityModelLayers;
import com.nemonotfound.client.render.entity.model.ModEntityModels;
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
