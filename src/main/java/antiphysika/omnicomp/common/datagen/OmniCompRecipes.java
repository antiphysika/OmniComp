/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.common.staticdata.StaticRecipeData;

public class OmniCompRecipes extends RecipeProvider
{
  public OmniCompRecipes (PackOutput output,
                          CompletableFuture<HolderLookup.Provider> lookupProvider)
  {
    super(output, lookupProvider);
  }

  private void compBlockRecipe (@NotNull RecipeOutput output,
                                ItemLike material,
                                ItemLike result)
  {
    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', material)
      .unlockedBy("has_item", has(material))
      .save(output);
  }

  private void compBlockRecipes (@NotNull RecipeOutput output, ItemLike[] materials)
  {
    compBlockRecipe(output, materials[0], materials[1]);
    compBlockRecipe(output, materials[1], materials[2]);
    compBlockRecipe(output, materials[2], materials[3]);
  }

  @Override
  protected void buildRecipes (@NotNull RecipeOutput output)
  {
    compBlockRecipes(output, StaticRecipeData.COBBLESTONE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.STONE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.DEEPSLATE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.COBBLED_DEEPSLATE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.DIRT_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.COARSE_DIRT_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.GRAVEL_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.SAND_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.SANDSTONE_MATERIALS);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :