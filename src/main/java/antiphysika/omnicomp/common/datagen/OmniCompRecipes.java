/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import antiphysika.omnicomp.common.registry.Registrar;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class OmniCompRecipes extends RecipeProvider
{
  public OmniCompRecipes (PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
  {
    super(output, lookupProvider);
  }

  @Override
  protected void buildRecipes (@NotNull RecipeOutput output)
  {
    // Cobblestone
    //

    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Registrar.COBBLESTONE_1X_ITEM)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', Items.COBBLESTONE)
      .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
      .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Registrar.COBBLESTONE_2X_ITEM)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', Registrar.COBBLESTONE_1X_ITEM)
      .unlockedBy("has_cobblestone_1x", has(Registrar.COBBLESTONE_1X_ITEM))
      .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Registrar.COBBLESTONE_3X_ITEM)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', Registrar.COBBLESTONE_2X_ITEM)
      .unlockedBy("has_cobblestone_1x", has(Registrar.COBBLESTONE_2X_ITEM))
      .save(output);

    // Stone
    //

    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Registrar.STONE_1X_ITEM)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', Items.STONE)
      .unlockedBy("has_cobblestone", has(Items.STONE))
      .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Registrar.STONE_2X_ITEM)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', Registrar.STONE_1X_ITEM)
      .unlockedBy("has_cobblestone_1x", has(Registrar.STONE_1X_ITEM))
      .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Registrar.STONE_3X_ITEM)
      .pattern("###")
      .pattern("###")
      .pattern("###")
      .define('#', Registrar.STONE_2X_ITEM)
      .unlockedBy("has_cobblestone_1x", has(Registrar.STONE_2X_ITEM))
      .save(output);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :