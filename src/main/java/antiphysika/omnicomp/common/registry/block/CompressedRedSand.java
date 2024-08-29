/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.registry.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import antiphysika.omnicomp.common.registry.Registrar;

public class CompressedRedSand
{
  public static DeferredBlock<Block> BLOCK_1X;
  public static DeferredBlock<Block> BLOCK_2X;
  public static DeferredBlock<Block> BLOCK_3X;

  public static DeferredItem<BlockItem> ITEM_1X;
  public static DeferredItem<BlockItem> ITEM_2X;
  public static DeferredItem<BlockItem> ITEM_3X;

  public static void init ()
  {
    BLOCK_1X = Registrar.registerBlock(
      "red_sand_1x",
      2.0f,
      MapColor.COLOR_ORANGE
    );

    BLOCK_2X = Registrar.registerBlock(
      "red_sand_2x",
      3.5f,
      MapColor.COLOR_ORANGE
    );

    BLOCK_3X = Registrar.registerBlock(
      "red_sand_3x",
      5.0f,
      MapColor.COLOR_ORANGE
    );

    ITEM_1X = Registrar.ITEMS.registerSimpleBlockItem("red_sand_1x", BLOCK_1X);
    ITEM_2X = Registrar.ITEMS.registerSimpleBlockItem("red_sand_2x", BLOCK_2X);
    ITEM_3X = Registrar.ITEMS.registerSimpleBlockItem("red_sand_3x", BLOCK_3X);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :