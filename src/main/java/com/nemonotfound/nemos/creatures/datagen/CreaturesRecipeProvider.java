package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class CreaturesRecipeProvider extends FabricRecipeProvider {

    public CreaturesRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(
            HolderLookup.@NonNull Provider wrapperLookup,
            @NonNull BootstrapContext<Recipe<?>> recipeOutput,
            @NonNull BootstrapContext<Advancement> advancementOutput
    ) {
        return new RecipeProvider(recipeOutput, advancementOutput) {

            @Override
            public void buildRecipes() {
                this.nineBlockStorageRecipes(RecipeCategory.MISC, CreaturesItems.SAND_DUST, RecipeCategory.BUILDING_BLOCKS, Items.SAND);

                this.shapeless(RecipeCategory.MISC, CreaturesItems.FROZEN_BONE_MEAL, 3)
                        .requires(CreaturesItems.FROZEN_BONE)
                        .group("bonemeal")
                        .unlockedBy("has_frozen_bone", this.has(CreaturesItems.FROZEN_BONE))
                        .save(this.output);
                
                this.shapeless(RecipeCategory.MISC, CreaturesItems.PARCHED_BONE_MEAL, 3)
                        .requires(CreaturesItems.PARCHED_BONE)
                        .group("bonemeal")
                        .unlockedBy("has_parched_bone", this.has(CreaturesItems.PARCHED_BONE))
                        .save(this.output);

                this.shapeless(RecipeCategory.MISC, CreaturesItems.CRIMSON_BONE_MEAL, 3)
                        .requires(CreaturesItems.CRIMSON_BONE)
                        .group("bonemeal")
                        .unlockedBy("has_crimson_bone", this.has(CreaturesItems.CRIMSON_BONE))
                        .save(this.output);

                this.shapeless(RecipeCategory.MISC, CreaturesItems.WARPED_BONE_MEAL, 3)
                        .requires(CreaturesItems.WARPED_BONE)
                        .group("bonemeal")
                        .unlockedBy("has_crimson_bone", this.has(CreaturesItems.WARPED_BONE))
                        .save(this.output);

                this.nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.FROZEN_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.FROZEN_BONE_BLOCK,
                        getSimpleRecipeName(CreaturesItems.FROZEN_BONE_BLOCK),
                        "bone_meal_block",
                        "frozen_bone_meal_from_frozen_bone_block",
                        "bonemeal"
                );
                
                this.nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.PARCHED_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.PARCHED_BONE_BLOCK,
                        getSimpleRecipeName(CreaturesItems.PARCHED_BONE_BLOCK),
                        "bone_meal_block",
                        "parched_bone_meal_from_parched_bone_block",
                        "bonemeal"
                );

                this.nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.CRIMSON_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.CRIMSON_BONE_BLOCK,
                        getSimpleRecipeName(CreaturesItems.CRIMSON_BONE_BLOCK),
                        "bone_meal_block",
                        "crimson_bone_meal_from_crimson_bone_block",
                        "bonemeal"
                );

                this.nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.WARPED_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.WARPED_BONE_BLOCK,
                        getSimpleRecipeName(CreaturesItems.WARPED_BONE_BLOCK),
                        "bone_meal_block",
                        "warped_bone_meal_from_warped_bone_block",
                        "bonemeal"
                );
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Nemo's Creatures Recipes";
    }
}
