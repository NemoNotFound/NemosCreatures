package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.item.ModItems;
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
                this.offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.SAND_DUST, RecipeCategory.BUILDING_BLOCKS, Items.SAND);

                this.createShapeless(RecipeCategory.MISC, ModItems.SCORCHED_BONE_MEAL, 3)
                        .input(ModItems.SCORCHED_BONE)
                        .group("bonemeal")
                        .criterion("has_scorched_bone", this.conditionsFromItem(ModItems.SCORCHED_BONE))
                        .offerTo(this.exporter);

                this.createShapeless(RecipeCategory.MISC, ModItems.CRIMSON_BONE_MEAL, 3)
                        .input(ModItems.CRIMSON_BONE)
                        .group("bonemeal")
                        .criterion("has_crimson_bone", this.conditionsFromItem(ModItems.CRIMSON_BONE))
                        .offerTo(this.exporter);

                this.createShapeless(RecipeCategory.MISC, ModItems.WARPED_BONE_MEAL, 3)
                        .input(ModItems.WARPED_BONE)
                        .group("bonemeal")
                        .criterion("has_crimson_bone", this.conditionsFromItem(ModItems.WARPED_BONE))
                        .offerTo(this.exporter);

                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.SCORCHED_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.SCORCHED_BONE_BLOCK,
                        getRecipeName(ModItems.SCORCHED_BONE_BLOCK),
                        "bone_meal_block",
                        "scorched_bone_meal_from_scorched_bone_block",
                        "bonemeal"
                );

                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.CRIMSON_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.CRIMSON_BONE_BLOCK,
                        getRecipeName(ModItems.CRIMSON_BONE_BLOCK),
                        "bone_meal_block",
                        "crimson_bone_meal_from_crimson_bone_block",
                        "bonemeal"
                );

                this.offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.WARPED_BONE_MEAL,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.WARPED_BONE_BLOCK,
                        getRecipeName(ModItems.WARPED_BONE_BLOCK),
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
