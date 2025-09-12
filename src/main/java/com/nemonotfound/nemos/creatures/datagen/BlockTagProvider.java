package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.registry.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.NETHERRACK)
                .add(Blocks.WARPED_NYLIUM);

        valueLookupBuilder(ModBlockTags.WARPED_BONE_MEAL_REPLACEABLE)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.NETHERRACK)
                .add(Blocks.CRIMSON_NYLIUM);
    }
}
