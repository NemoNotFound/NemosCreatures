package com.nemonotfound.nemos.creatures;

import com.nemonotfound.nemos.creatures.datagen.EnglishLanguageProvider;
import com.nemonotfound.nemos.creatures.datagen.EntityLootTableProvider;
import com.nemonotfound.nemos.creatures.datagen.ModModelProvider;
import com.nemonotfound.nemos.creatures.datagen.RecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class NemosCreaturesDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageProvider::new);
		pack.addProvider(EntityLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(RecipeProvider::new);
	}
}
