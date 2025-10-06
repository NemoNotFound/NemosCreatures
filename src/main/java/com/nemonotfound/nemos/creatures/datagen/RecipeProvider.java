package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {
                this.offerReversibleCompactingRecipes(RecipeCategory.MISC, CreaturesItems.SAND_DUST, RecipeCategory.BUILDING_BLOCKS, Items.SAND);

                this.createShapeless(RecipeCategory.MISC, CreaturesItems.FROZEN_BONE_MEAL, 3)
                        .input(CreaturesItems.FROZEN_BONE)
                        .group("bonemeal")
                        .criterion("has_frozen_bone", this.conditionsFromItem(CreaturesItems.FROZEN_BONE))
                        .offerTo(this.exporter);
                
                this.createShapeless(RecipeCategory.MISC, CreaturesItems.SCORCHED_BONE_MEAL, 3)
                        .input(CreaturesItems.SCORCHED_BONE)
                        .group("bonemeal")
                        .criterion("has_scorched_bone", this.conditionsFromItem(CreaturesItems.SCORCHED_BONE))
                        .offerTo(this.exporter);

                this.createShapeless(RecipeCategory.MISC, CreaturesItems.CRIMSON_BONE_MEAL, 3)
                        .input(CreaturesItems.CRIMSON_BONE)
                        .group("bonemeal")
                        .criterion("has_crimson_bone", this.conditionsFromItem(CreaturesItems.CRIMSON_BONE))
                        .offerTo(this.exporter);

                this.createShapeless(RecipeCategory.MISC, CreaturesItems.WARPED_BONE_MEAL, 3)
                        .input(CreaturesItems.WARPED_BONE)
                        .group("bonemeal")
                        .criterion("has_crimson_bone", this.conditionsFromItem(CreaturesItems.WARPED_BONE))
                        .offerTo(this.exporter);

                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.FROZEN_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.FROZEN_BONE_BLOCK,
                        getRecipeName(CreaturesItems.FROZEN_BONE_BLOCK),
                        "bone_meal_block",
                        "frozen_bone_meal_from_frozen_bone_block",
                        "bonemeal"
                );
                
                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.SCORCHED_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.SCORCHED_BONE_BLOCK,
                        getRecipeName(CreaturesItems.SCORCHED_BONE_BLOCK),
                        "bone_meal_block",
                        "scorched_bone_meal_from_scorched_bone_block",
                        "bonemeal"
                );

                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.CRIMSON_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.CRIMSON_BONE_BLOCK,
                        getRecipeName(CreaturesItems.CRIMSON_BONE_BLOCK),
                        "bone_meal_block",
                        "crimson_bone_meal_from_crimson_bone_block",
                        "bonemeal"
                );

                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        CreaturesItems.WARPED_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        CreaturesItems.WARPED_BONE_BLOCK,
                        getRecipeName(CreaturesItems.WARPED_BONE_BLOCK),
                        "bone_meal_block",
                        "warped_bone_meal_from_warped_bone_block",
                        "bonemeal"
                );
            }
        };
    }

    @Override
    public String getName() {
        return "Nemo's Creatures Recipes";
    }
}
