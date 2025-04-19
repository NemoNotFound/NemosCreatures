package com.nemonotfound.datagen;

import com.nemonotfound.entity.ModEntityTypes;
import com.nemonotfound.item.ModItemGroups;
import com.nemonotfound.item.ModItems;
import com.nemonotfound.registry.tag.ModBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnglishLanguageProvider extends FabricLanguageProvider {

    public EnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModEntityTypes.VENOMOUS_SKELETON, "Venomous Skeleton");
        translationBuilder.add(ModItems.VENOMOUS_SKELETON_SPAWN_EGG, "Venomous Skeleton Spawn Egg");
        translationBuilder.add(ModEntityTypes.VENOMOUS_SPIDER, "Venomous Spider");
        translationBuilder.add(ModItems.VENOMOUS_SPIDER_SPAWN_EGG, "Venomous Spider Spawn Egg");
        translationBuilder.add(ModEntityTypes.VENOMOUS_ZOMBIE, "Venomous Zombie");
        translationBuilder.add(ModItems.VENOMOUS_ZOMBIE_SPAWN_EGG, "Venomous Zombie Spawn Egg");
        translationBuilder.add(ModEntityTypes.VENOMOUS_CREEPER, "Venomous Creeper");
        translationBuilder.add(ModItems.VENOMOUS_CREEPER_SPAWN_EGG, "Venomous Creeper Spawn Egg");
        translationBuilder.add(ModEntityTypes.SCORCHED_SKELETON, "Scorched Skeleton");
        translationBuilder.add(ModItems.SCORCHED_SKELETON_SPAWN_EGG, "Scorched Skeleton Spawn Egg");
        translationBuilder.add(ModEntityTypes.SAND_SPIDER, "Sand Spider");
        translationBuilder.add(ModItems.SAND_SPIDER_SPAWN_EGG, "Sand Spider Spawn Egg");
        translationBuilder.add(ModEntityTypes.MUMMY, "Mummy");
        translationBuilder.add(ModItems.MUMMY_SPAWN_EGG, "Mummy Spawn Egg");
        translationBuilder.add(ModEntityTypes.SCORCHED_CREEPER, "Scorched Creeper");
        translationBuilder.add(ModItems.SCORCHED_CREEPER_SPAWN_EGG, "Scorched Creeper Spawn Egg");
        translationBuilder.add(ModEntityTypes.CRIMSON_SKELETON, "Crimson Skeleton");
        translationBuilder.add(ModItems.CRIMSON_SKELETON_SPAWN_EGG, "Crimson Skeleton Spawn Egg");
        translationBuilder.add(ModEntityTypes.WARPED_SKELETON, "Warped Skeleton");
        translationBuilder.add(ModItems.WARPED_SKELETON_SPAWN_EGG, "Warped Skeleton Spawn Egg");
        translationBuilder.add(ModEntityTypes.WILD_BOAR, "Wild Boar");
        translationBuilder.add(ModItems.WILD_BOAR_SPAWN_EGG, "Wild Boar Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOWY_SKELETON, "Snowy Skeleton");
        translationBuilder.add(ModItems.SNOWY_SKELETON_SPAWN_EGG, "Snowy Skeleton Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOWY_PIG, "Snowy Pig");
        translationBuilder.add(ModItems.SNOWY_PIG_SPAWN_EGG, "Snowy Pig Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOWY_COW, "Snowy Cow");
        translationBuilder.add(ModItems.SNOWY_COW_SPAWN_EGG, "Snowy Cow Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOWY_SPIDER, "Snowy Spider");
        translationBuilder.add(ModItems.SNOWY_SPIDER_SPAWN_EGG, "Snowy Spider Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOW_SPIDER, "Snow Spider");
        translationBuilder.add(ModItems.SNOW_SPIDER_SPAWN_EGG, "Snow Spider Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOWY_CREEPER, "Snowy Creeper");
        translationBuilder.add(ModItems.SNOWY_CREEPER_SPAWN_EGG, "Snowy Creeper Spawn Egg");
        translationBuilder.add(ModEntityTypes.SNOWY_ZOMBIE, "Snowy Zombie");
        translationBuilder.add(ModItems.SNOWY_ZOMBIE_SPAWN_EGG, "Snowy Zombie Spawn Egg");
        translationBuilder.add(ModEntityTypes.FROZEN_SKELETON, "Frozen Skeleton");
        translationBuilder.add(ModItems.FROZEN_SKELETON_SPAWN_EGG, "Frozen Skeleton Spawn Egg");
        translationBuilder.add(ModEntityTypes.FROZEN_CREEPER, "Frozen Creeper");
        translationBuilder.add(ModItems.FROZEN_CREEPER_SPAWN_EGG, "Frozen Creeper Spawn Egg");
        translationBuilder.add(ModEntityTypes.FROZEN_SPIDER, "Frozen Spider");
        translationBuilder.add(ModItems.FROZEN_SPIDER_SPAWN_EGG, "Frozen Spider Spawn Egg");
        translationBuilder.add(ModEntityTypes.ICE_SPIDER, "Ice Spider");
        translationBuilder.add(ModItems.ICE_SPIDER_SPAWN_EGG, "Ice Spider Spawn Egg");
        translationBuilder.add(ModEntityTypes.FROZEN_ZOMBIE, "Frozen Zombie");
        translationBuilder.add(ModItems.FROZEN_ZOMBIE_SPAWN_EGG, "Frozen Zombie Spawn Egg");
        translationBuilder.add(ModBiomeTags.IS_CRIMSON_FOREST, "Crimson Forest");
        translationBuilder.add(ModBiomeTags.IS_WARPED_FOREST, "Warped Forest");
        translationBuilder.add(ModBiomeTags.IS_SNOWY_TAIGA, "Snowy Taiga");
        translationBuilder.add(ModItemGroups.NEMOS_CREATURES_KEY, "Nemo's Creatures");
        translationBuilder.add(ModItems.SAND_DUST, "Sand Dust");
    }
}
