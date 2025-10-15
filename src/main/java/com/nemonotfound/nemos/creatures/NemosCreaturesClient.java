package com.nemonotfound.nemos.creatures;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModels;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NemosCreaturesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CreaturesEntityModelLayers.registerEntityModelLayers();
        CreaturesEntityModels.bootstrap();
    }
}
