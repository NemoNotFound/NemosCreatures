package com.nemonotfound.datagen;

import com.nemonotfound.item.ModItems;
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
            }
        };
    }

    @Override
    public String getName() {
        return "Nemo's Creatures Recipes";
    }
}
