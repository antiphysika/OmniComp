/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.staticdata.StaticRecipeData;

public class OmniCompRecipes extends RecipeProvider
{
  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param lookupProvider
   */
  public OmniCompRecipes (PackOutput output,
                          CompletableFuture<HolderLookup.Provider> lookupProvider)
  {
    super(output, lookupProvider);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param material
   * @param result
   */
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

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param item
   * @return
   */
  private ResourceLocation itemLikeToId (ItemLike item)
  {
    Holder<Item> itemHolder = item.asItem().getDefaultInstance().getItemHolder();
    return ResourceLocation.parse(itemHolder.getRegisteredName());
  }

  private Object[] reverseArray (Object[] array)
  {
    Object[] reversed = array.clone();

    for (int i = 0; i < array.length / 2; ++i)
    {
      var tmp = reversed[i];
      reversed[i] = reversed[reversed.length - i - 1];
      reversed[reversed.length - i - 1] = tmp;
    }

    return reversed;
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param materials
   * @return
   */
  private ItemLike[] reverseMaterials (ItemLike[] materials)
  {
    return (ItemLike[]) reverseArray(materials);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param material
   * @param result
   */
  private void decompBlockRecipe (@NotNull RecipeOutput output,
                                  ItemLike material,
                                  ItemLike result)
  {
    ResourceLocation materialLoc = itemLikeToId(material);
    ResourceLocation recipeId = OmniComp.location(materialLoc.getPath() + "/decompressed");
    ItemStack resultStack = new ItemStack(result, 9);

    ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, resultStack)
      .requires(material)
      .unlockedBy("has_result", has(result))
      .unlockedBy("has_material", has(material))
      .save(output, recipeId);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param materials
   */
  private void compBlockRecipes (@NotNull RecipeOutput output, ItemLike[] materials)
  {
    compBlockRecipe(output, materials[0], materials[1]);
    compBlockRecipe(output, materials[1], materials[2]);
    compBlockRecipe(output, materials[2], materials[3]);

    ItemLike[] revMaterials = reverseMaterials(materials);
    decompBlockRecipe(output, revMaterials[0], revMaterials[1]);
    decompBlockRecipe(output, revMaterials[1], revMaterials[2]);
    decompBlockRecipe(output, revMaterials[2], revMaterials[3]);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   */
  @Override
  protected void buildRecipes (@NotNull RecipeOutput output)
  {
    compBlockRecipes(output, StaticRecipeData.DIRT_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.COARSE_DIRT_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.COBBLESTONE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.MOSSY_COBBLESTONE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.STONE_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.DEEPSLATE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.COBBLED_DEEPSLATE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.TUFF_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.DRIPSTONE_BLOCK_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.GRAVEL_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.CLAY_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.MUD_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.OBSIDIAN_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.GLOWSTONE_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.SAND_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.SANDSTONE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.RED_SAND_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.RED_SANDSTONE_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.ANDESITE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.DIORITE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.GRANITE_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.CALCITE_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.NETHERRACK_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.SOUL_SAND_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.SOUL_SOIL_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.BASALT_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.BLACKSTONE_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.END_STONE_MATERIALS);

    compBlockRecipes(output, StaticRecipeData.COAL_BLOCK_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.COPPER_BLOCK_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.IRON_BLOCK_MATERIALS);
    compBlockRecipes(output, StaticRecipeData.GOLD_BLOCK_MATERIALS);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :