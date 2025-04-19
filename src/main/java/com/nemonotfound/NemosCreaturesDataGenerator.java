package com.nemonotfound;

import com.nemonotfound.datagen.EnglishLanguageProvider;
import com.nemonotfound.datagen.EntityLootTableProvider;
import com.nemonotfound.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class NemosCreaturesDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageProvider::new);
		pack.addProvider(EntityLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
