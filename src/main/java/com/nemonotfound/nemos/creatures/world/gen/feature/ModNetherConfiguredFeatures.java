package com.nemonotfound.nemos.creatures.world.gen.feature;

import com.nemonotfound.nemos.creatures.registry.tag.CreatureBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class ModNetherConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CRIMSON_FOREST_VEGETATION_PATCH = of("crimson_forest_vegetation_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL = of("crimson_forest_vegetation_patch_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WARPED_FOREST_VEGETATION_PATCH = of("warped_forest_vegetation_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WARPED_FOREST_VEGETATION_PATCH_BONEMEAL = of("warped_forest_vegetation_patch_bonemeal");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        WeightedBlockStateProvider crimsonWeightedBlockStateProvider = new WeightedBlockStateProvider(
                Pool.<BlockState>builder()
                        .add(Blocks.CRIMSON_ROOTS.getDefaultState(), 87)
                        .add(Blocks.CRIMSON_FUNGUS.getDefaultState(), 13)
        );

        ConfiguredFeatures.register(
                featureRegisterable,
                CRIMSON_FOREST_VEGETATION_PATCH,
                Feature.NETHER_FOREST_VEGETATION,
                new NetherForestVegetationFeatureConfig(crimsonWeightedBlockStateProvider, 3, 4)
        );

        ConfiguredFeatures.register(
                featureRegisterable,
                CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL,
                Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(
                        CreatureBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE,
                        BlockStateProvider.of(Blocks.CRIMSON_NYLIUM),
                        PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(CRIMSON_FOREST_VEGETATION_PATCH)),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformIntProvider.create(1, 2),
                        0.75F
                )
        );

        WeightedBlockStateProvider warpedWeightedBlockStateProvider = new WeightedBlockStateProvider(
                Pool.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.getDefaultState(), 87)
                        .add(Blocks.WARPED_FUNGUS.getDefaultState(), 13)
        );

        ConfiguredFeatures.register(
                featureRegisterable,
                WARPED_FOREST_VEGETATION_PATCH,
                Feature.NETHER_FOREST_VEGETATION,
                new NetherForestVegetationFeatureConfig(warpedWeightedBlockStateProvider, 3, 4)
        );

        ConfiguredFeatures.register(
                featureRegisterable,
                WARPED_FOREST_VEGETATION_PATCH_BONEMEAL,
                Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(
                        CreatureBlockTags.WARPED_BONE_MEAL_REPLACEABLE,
                        BlockStateProvider.of(Blocks.WARPED_NYLIUM),
                        PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(WARPED_FOREST_VEGETATION_PATCH)),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformIntProvider.create(1, 2),
                        0.75F
                )
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MOD_ID, id));
    }
}
