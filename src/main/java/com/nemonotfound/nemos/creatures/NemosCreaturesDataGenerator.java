package com.nemonotfound.nemos.creatures;

import com.nemonotfound.nemos.creatures.datagen.*;
import com.nemonotfound.nemos.creatures.world.gen.feature.ModNetherConfiguredFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class NemosCreaturesDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageProvider::new);
		pack.addProvider(EntityLootTableProvider::new);
		pack.addProvider(CreaturesModelProvider::new);
		pack.addProvider(CreaturesRecipeProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(WorldGenProvider::new);
		pack.addProvider(EntityTypeTagsProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.FEATURE, ModNetherConfiguredFeatures::bootstrap);
	}
}
