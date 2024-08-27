/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import antiphysika.omnicomp.common.registry.block.CompressedCobblestone;
import antiphysika.omnicomp.common.registry.block.CompressedStone;
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
    compBlockRecipe(output, CompressedCobblestone.ITEM_1X, Items.COBBLESTONE);
    compBlockRecipe(output, CompressedCobblestone.ITEM_2X, CompressedCobblestone.ITEM_1X);
    compBlockRecipe(output, CompressedCobblestone.ITEM_3X, CompressedCobblestone.ITEM_2X);

    compBlockRecipe(output, CompressedStone.ITEM_1X, Items.STONE);
    compBlockRecipe(output, CompressedStone.ITEM_2X, CompressedStone.ITEM_1X);
    compBlockRecipe(output, CompressedStone.ITEM_3X, CompressedStone.ITEM_2X);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :