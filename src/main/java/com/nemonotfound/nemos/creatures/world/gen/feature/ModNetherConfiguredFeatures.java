package com.nemonotfound.nemos.creatures.world.gen.feature;

import com.nemonotfound.nemos.creatures.registry.tag.CreatureBlockTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class ModNetherConfiguredFeatures {

    public static final ResourceKey<Feature> CRIMSON_FOREST_VEGETATION_PATCH = of("crimson_forest_vegetation_patch");
    public static final ResourceKey<Feature> CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL = of("crimson_forest_vegetation_patch_bonemeal");
    public static final ResourceKey<Feature> WARPED_FOREST_VEGETATION_PATCH = of("warped_forest_vegetation_patch");
    public static final ResourceKey<Feature> WARPED_FOREST_VEGETATION_PATCH_BONEMEAL = of("warped_forest_vegetation_patch_bonemeal");

    public static void bootstrap(BootstrapContext<Feature> featureRegisterable) {
        var blockLookup = featureRegisterable.lookup(Registries.BLOCK);

        WeightedStateProvider crimsonWeightedBlockStateProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(Blocks.CRIMSON_ROOTS.defaultBlockState(), 87)
                        .add(Blocks.CRIMSON_FUNGUS.defaultBlockState(), 13)
        );

        var crimsonVegetation = new SimpleBlockFeature(crimsonWeightedBlockStateProvider);
        featureRegisterable.register(CRIMSON_FOREST_VEGETATION_PATCH, crimsonVegetation);

        featureRegisterable.register(
                CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL,
                new VegetationPatchFeature(
                        blockLookup.getOrThrow(CreatureBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE),
                        BlockStateProvider.holderOf(Blocks.CRIMSON_NYLIUM),
                        PlacementUtils.inlinePlaced(crimsonVegetation),
                        CaveSurface.FLOOR,
                        ConstantInt.of(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformInt.of(1, 2),
                        0.75F
                )
        );

        WeightedStateProvider warpedWeightedBlockStateProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.defaultBlockState(), 87)
                        .add(Blocks.WARPED_FUNGUS.defaultBlockState(), 13)
        );

        var warpedVegetation = new SimpleBlockFeature(warpedWeightedBlockStateProvider);
        featureRegisterable.register(WARPED_FOREST_VEGETATION_PATCH, warpedVegetation);

        featureRegisterable.register(
                WARPED_FOREST_VEGETATION_PATCH_BONEMEAL,
                new VegetationPatchFeature(
                        blockLookup.getOrThrow(CreatureBlockTags.WARPED_BONE_MEAL_REPLACEABLE),
                        BlockStateProvider.holderOf(Blocks.WARPED_NYLIUM),
                        PlacementUtils.inlinePlaced(warpedVegetation),
                        CaveSurface.FLOOR,
                        ConstantInt.of(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformInt.of(1, 2),
                        0.75F
                )
        );
    }

    public static ResourceKey<Feature> of(String id) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }
}
