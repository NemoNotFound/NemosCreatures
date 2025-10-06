package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.block.CreaturesBlocks;
import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class CreaturesModelProvider extends FabricModelProvider {

    public CreaturesModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(CreaturesBlocks.FROZEN_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(CreaturesBlocks.SCORCHED_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(CreaturesBlocks.CRIMSON_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(CreaturesBlocks.WARPED_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(CreaturesItems.VENOMOUS_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.VENOMOUS_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.VENOMOUS_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.VENOMOUS_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SCORCHED_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SAND_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.MUMMY_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SCORCHED_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.CRIMSON_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.WARPED_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.WILD_BOAR_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOWY_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOWY_PIG_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOWY_COW_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOWY_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOW_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOWY_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SNOWY_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.FROZEN_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.FROZEN_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.FROZEN_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.ICE_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.FROZEN_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SAND_DUST, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.FROZEN_BONE, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.FROZEN_BONE_MEAL, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SCORCHED_BONE, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.SCORCHED_BONE_MEAL, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.CRIMSON_BONE, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.CRIMSON_BONE_MEAL, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.WARPED_BONE, Models.GENERATED);
        itemModelGenerator.register(CreaturesItems.WARPED_BONE_MEAL, Models.GENERATED);
    }
}
