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
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.common.registry.Registrar;

public class OmniCompRecipes extends RecipeProvider
{
  public OmniCompRecipes (PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
  {
    super(output, lookupProvider);
  }

  private void compBlockRecipe (@NotNull RecipeOutput output, ItemLike result, ItemLike material)
  {
    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', material)
      .unlockedBy("has_item", has(material))
      .save(output);
  }

  @Override
  protected void buildRecipes (@NotNull RecipeOutput output)
  {
    compBlockRecipe(output, Registrar.COBBLESTONE_1X_ITEM, Items.COBBLESTONE);
    compBlockRecipe(output, Registrar.COBBLESTONE_2X_ITEM, Registrar.COBBLESTONE_1X_ITEM);
    compBlockRecipe(output, Registrar.COBBLESTONE_3X_ITEM, Registrar.COBBLESTONE_2X_ITEM);

    compBlockRecipe(output, Registrar.STONE_1X_ITEM, Items.STONE);
    compBlockRecipe(output, Registrar.STONE_2X_ITEM, Registrar.STONE_1X_ITEM);
    compBlockRecipe(output, Registrar.STONE_3X_ITEM, Registrar.STONE_2X_ITEM);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :