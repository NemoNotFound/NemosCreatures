package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import com.nemonotfound.nemos.creatures.item.CreaturesItemGroups;
import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import com.nemonotfound.nemos.creatures.registry.tag.ModBiomeTags;
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
        translationBuilder.add(CreaturesEntityTypes.VENOMOUS_SKELETON, "Venomous Skeleton");
        translationBuilder.add(CreaturesItems.VENOMOUS_SKELETON_SPAWN_EGG, "Venomous Skeleton Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.VENOMOUS_SPIDER, "Venomous Spider");
        translationBuilder.add(CreaturesItems.VENOMOUS_SPIDER_SPAWN_EGG, "Venomous Spider Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.VENOMOUS_ZOMBIE, "Venomous Zombie");
        translationBuilder.add(CreaturesItems.VENOMOUS_ZOMBIE_SPAWN_EGG, "Venomous Zombie Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.VENOMOUS_CREEPER, "Venomous Creeper");
        translationBuilder.add(CreaturesItems.VENOMOUS_CREEPER_SPAWN_EGG, "Venomous Creeper Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SCORCHED_SKELETON, "Scorched Skeleton");
        translationBuilder.add(CreaturesItems.SCORCHED_SKELETON_SPAWN_EGG, "Scorched Skeleton Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SAND_SPIDER, "Sand Spider");
        translationBuilder.add(CreaturesItems.SAND_SPIDER_SPAWN_EGG, "Sand Spider Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.MUMMY, "Mummy");
        translationBuilder.add(CreaturesItems.MUMMY_SPAWN_EGG, "Mummy Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SCORCHED_CREEPER, "Scorched Creeper");
        translationBuilder.add(CreaturesItems.SCORCHED_CREEPER_SPAWN_EGG, "Scorched Creeper Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.CRIMSON_SKELETON, "Crimson Skeleton");
        translationBuilder.add(CreaturesItems.CRIMSON_SKELETON_SPAWN_EGG, "Crimson Skeleton Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.WARPED_SKELETON, "Warped Skeleton");
        translationBuilder.add(CreaturesItems.WARPED_SKELETON_SPAWN_EGG, "Warped Skeleton Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.WILD_BOAR, "Wild Boar");
        translationBuilder.add(CreaturesItems.WILD_BOAR_SPAWN_EGG, "Wild Boar Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOWY_SKELETON, "Snowy Skeleton");
        translationBuilder.add(CreaturesItems.SNOWY_SKELETON_SPAWN_EGG, "Snowy Skeleton Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOWY_PIG, "Snowy Pig");
        translationBuilder.add(CreaturesItems.SNOWY_PIG_SPAWN_EGG, "Snowy Pig Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOWY_COW, "Snowy Cow");
        translationBuilder.add(CreaturesItems.SNOWY_COW_SPAWN_EGG, "Snowy Cow Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOWY_SPIDER, "Snowy Spider");
        translationBuilder.add(CreaturesItems.SNOWY_SPIDER_SPAWN_EGG, "Snowy Spider Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOW_SPIDER, "Snow Spider");
        translationBuilder.add(CreaturesItems.SNOW_SPIDER_SPAWN_EGG, "Snow Spider Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOWY_CREEPER, "Snowy Creeper");
        translationBuilder.add(CreaturesItems.SNOWY_CREEPER_SPAWN_EGG, "Snowy Creeper Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.SNOWY_ZOMBIE, "Snowy Zombie");
        translationBuilder.add(CreaturesItems.SNOWY_ZOMBIE_SPAWN_EGG, "Snowy Zombie Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.FROZEN_SKELETON, "Frozen Skeleton");
        translationBuilder.add(CreaturesItems.FROZEN_SKELETON_SPAWN_EGG, "Frozen Skeleton Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.FROZEN_CREEPER, "Frozen Creeper");
        translationBuilder.add(CreaturesItems.FROZEN_CREEPER_SPAWN_EGG, "Frozen Creeper Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.FROZEN_SPIDER, "Frozen Spider");
        translationBuilder.add(CreaturesItems.FROZEN_SPIDER_SPAWN_EGG, "Frozen Spider Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.ICE_SPIDER, "Ice Spider");
        translationBuilder.add(CreaturesItems.ICE_SPIDER_SPAWN_EGG, "Ice Spider Spawn Egg");
        translationBuilder.add(CreaturesEntityTypes.FROZEN_ZOMBIE, "Frozen Zombie");
        translationBuilder.add(CreaturesItems.FROZEN_ZOMBIE_SPAWN_EGG, "Frozen Zombie Spawn Egg");
        translationBuilder.add(ModBiomeTags.IS_CRIMSON_FOREST, "Crimson Forest");
        translationBuilder.add(ModBiomeTags.IS_WARPED_FOREST, "Warped Forest");
        translationBuilder.add(ModBiomeTags.IS_SNOWY_TAIGA, "Snowy Taiga");
        translationBuilder.add(CreaturesItemGroups.NEMOS_CREATURES_KEY, "Nemo's Creatures");
        translationBuilder.add(CreaturesItems.SAND_DUST, "Sand Dust");
        translationBuilder.add(CreaturesItems.FROZEN_BONE, "Frozen Bone");
        translationBuilder.add(CreaturesItems.FROZEN_BONE_MEAL, "Frozen Bone Meal");
        translationBuilder.add(CreaturesItems.FROZEN_BONE_BLOCK, "Frozen Bone Block");
        translationBuilder.add(CreaturesItems.SCORCHED_BONE, "Scorched Bone");
        translationBuilder.add(CreaturesItems.SCORCHED_BONE_MEAL, "Scorched Bone Meal");
        translationBuilder.add(CreaturesItems.SCORCHED_BONE_BLOCK, "Scorched Bone Block");
        translationBuilder.add(CreaturesItems.CRIMSON_BONE, "Crimson Bone");
        translationBuilder.add(CreaturesItems.CRIMSON_BONE_MEAL, "Crimson Bone Meal");
        translationBuilder.add(CreaturesItems.CRIMSON_BONE_BLOCK, "Crimson Bone Block");
        translationBuilder.add(CreaturesItems.WARPED_BONE, "Warped Bone");
        translationBuilder.add(CreaturesItems.WARPED_BONE_MEAL, "Warped Bone Meal");
        translationBuilder.add(CreaturesItems.WARPED_BONE_BLOCK, "Warped Bone Block");
    }
}
