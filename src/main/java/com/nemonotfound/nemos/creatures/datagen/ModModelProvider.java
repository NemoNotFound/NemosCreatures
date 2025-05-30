package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.block.ModBlocks;
import com.nemonotfound.nemos.creatures.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(ModBlocks.SCORCHED_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.CRIMSON_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.WARPED_BONE_BLOCK, TexturedModel.CUBE_COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VENOMOUS_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.VENOMOUS_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.VENOMOUS_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.VENOMOUS_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCORCHED_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAND_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUMMY_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCORCHED_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.WILD_BOAR_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_PIG_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_COW_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOW_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_CREEPER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SPIDER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAND_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCORCHED_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCORCHED_BONE_MEAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_BONE_MEAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_BONE_MEAL, Models.GENERATED);
    }
}
