/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.staticdata;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import antiphysika.omnicomp.common.registry.block.*;

public class StaticRecipeData
{
  public static final ItemLike[] COBBLESTONE_MATERIALS = new ItemLike[]{
    Items.COBBLESTONE,
    CompressedCobblestone.ITEM_1X,
    CompressedCobblestone.ITEM_2X,
    CompressedCobblestone.ITEM_3X
  };

  public static final ItemLike[] STONE_MATERIALS = new ItemLike[]{
    Items.STONE,
    CompressedStone.ITEM_1X,
    CompressedStone.ITEM_2X,
    CompressedStone.ITEM_3X
  };

  public static final ItemLike[] COBBLED_DEEPSLATE_MATERIALS = new ItemLike[]{
    Items.COBBLED_DEEPSLATE,
    CompressedCobbledDeepslate.ITEM_1X,
    CompressedCobbledDeepslate.ITEM_2X,
    CompressedCobbledDeepslate.ITEM_3X
  };

  public static final ItemLike[] DEEPSLATE_MATERIALS = new ItemLike[]{
    Items.DEEPSLATE,
    CompressedDeepslate.ITEM_1X,
    CompressedDeepslate.ITEM_2X,
    CompressedDeepslate.ITEM_3X
  };

  public static final ItemLike[] DIRT_MATERIALS = new ItemLike[]{
    Items.DIRT,
    CompressedDirt.ITEM_1X,
    CompressedDirt.ITEM_2X,
    CompressedDirt.ITEM_3X
  };

  public static final ItemLike[] COARSE_DIRT_MATERIALS = new ItemLike[]{
    Items.COARSE_DIRT,
    CompressedCoarseDirt.ITEM_1X,
    CompressedCoarseDirt.ITEM_2X,
    CompressedCoarseDirt.ITEM_3X
  };
}

//
// vim: ts=2 sw=2 et fdm=marker :