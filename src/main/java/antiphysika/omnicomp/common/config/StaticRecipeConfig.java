/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.config;

import antiphysika.omnicomp.common.registry.block.CompressedStone;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import antiphysika.omnicomp.common.registry.block.CompressedCobblestone;

public class StaticRecipeConfig
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
}

//
// vim: ts=2 sw=2 et fdm=marker :