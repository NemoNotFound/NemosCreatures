package com.nemonotfound.datagen;

import com.nemonotfound.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerSpawnEgg(ModItems.VENOMOUS_SKELETON_SPAWN_EGG, 0xC1C1C1, 5884716);
        itemModelGenerator.registerSpawnEgg(ModItems.VENOMOUS_SPIDER_SPAWN_EGG, 1657614, 11013646);
        itemModelGenerator.registerSpawnEgg(ModItems.VENOMOUS_ZOMBIE_SPAWN_EGG, 44975, 5884716);
        itemModelGenerator.registerSpawnEgg(ModItems.VENOMOUS_CREEPER_SPAWN_EGG, 894731, 87040);
        itemModelGenerator.registerSpawnEgg(ModItems.SCORCHED_SKELETON_SPAWN_EGG, 7497817, 5262145);
        itemModelGenerator.registerSpawnEgg(ModItems.SAND_SPIDER_SPAWN_EGG, 14009494, 15394254);
        itemModelGenerator.registerSpawnEgg(ModItems.MUMMY_SPAWN_EGG, 11572567, 5326381);
        itemModelGenerator.registerSpawnEgg(ModItems.SCORCHED_CREEPER_SPAWN_EGG, 7497817, 15000247);
        itemModelGenerator.registerSpawnEgg(ModItems.CRIMSON_SKELETON_SPAWN_EGG, 11439758, 11280416);
        itemModelGenerator.registerSpawnEgg(ModItems.WARPED_SKELETON_SPAWN_EGG, 12909551, 1474182);
        itemModelGenerator.registerSpawnEgg(ModItems.WILD_BOAR_SPAWN_EGG, 1971725, 4798503);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOWY_SKELETON_SPAWN_EGG, 8225707, 16777215);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOWY_PIG_SPAWN_EGG, 15771042, 16777215);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOWY_COW_SPAWN_EGG, 4470310, 16777215);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOWY_SPIDER_SPAWN_EGG, 3419431, 16777215);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOW_SPIDER_SPAWN_EGG, 16777215, 955560);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOWY_CREEPER_SPAWN_EGG, 5856370, 16777215);
        itemModelGenerator.registerSpawnEgg(ModItems.SNOWY_ZOMBIE_SPAWN_EGG, 3565947, 16777215);
        itemModelGenerator.registerSpawnEgg(ModItems.FROZEN_SKELETON_SPAWN_EGG, 6652326, 6658544);
        itemModelGenerator.registerSpawnEgg(ModItems.FROZEN_CREEPER_SPAWN_EGG, 5856370, 6658544);
        itemModelGenerator.registerSpawnEgg(ModItems.FROZEN_SPIDER_SPAWN_EGG, 7501217, 6658544);
        itemModelGenerator.registerSpawnEgg(ModItems.ICE_SPIDER_SPAWN_EGG, 6658544, 594512);
        itemModelGenerator.registerSpawnEgg(ModItems.FROZEN_ZOMBIE_SPAWN_EGG, 7501217, 9541527);
    }
}
