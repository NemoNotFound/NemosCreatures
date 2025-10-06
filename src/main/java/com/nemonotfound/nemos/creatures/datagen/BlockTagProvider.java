package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.block.CreaturesBlocks;
import com.nemonotfound.nemos.creatures.registry.tag.CreatureBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(CreatureBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.NETHERRACK)
                .add(Blocks.WARPED_NYLIUM);

        valueLookupBuilder(CreatureBlockTags.WARPED_BONE_MEAL_REPLACEABLE)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.NETHERRACK)
                .add(Blocks.CRIMSON_NYLIUM);

        valueLookupBuilder(PICKAXE_MINEABLE)
                .add(CreaturesBlocks.FROZEN_BONE_BLOCK)
                .add(CreaturesBlocks.CRIMSON_BONE_BLOCK)
                .add(CreaturesBlocks.SCORCHED_BONE_BLOCK)
                .add(CreaturesBlocks.WARPED_BONE_BLOCK);
    }
}
