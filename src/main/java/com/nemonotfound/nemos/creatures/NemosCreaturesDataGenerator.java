package com.nemonotfound.nemos.creatures;

import com.nemonotfound.nemos.creatures.datagen.*;
import com.nemonotfound.nemos.creatures.world.gen.feature.ModNetherConfiguredFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class NemosCreaturesDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageProvider::new);
		pack.addProvider(EntityLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(RecipeProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(WorldGenProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModNetherConfiguredFeatures::bootstrap);
	}
}
