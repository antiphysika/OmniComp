/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.registry.block;

import antiphysika.omnicomp.common.registry.Registrar;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static antiphysika.omnicomp.common.registry.Registrar.ITEMS;

public class CompressedDeepslate
{
  public static DeferredBlock<Block> BLOCK_1X;
  public static DeferredBlock<Block> BLOCK_2X;
  public static DeferredBlock<Block> BLOCK_3X;

  public static DeferredItem<BlockItem> ITEM_1X;
  public static DeferredItem<BlockItem> ITEM_2X;
  public static DeferredItem<BlockItem> ITEM_3X;

  public static void init ()
  {
    BLOCK_1X = Registrar.registerBlock("deepslate_1x", 0.8f, MapColor.DEEPSLATE);
    BLOCK_2X = Registrar.registerBlock("deepslate_2x", 0.8f, MapColor.DEEPSLATE);
    BLOCK_3X = Registrar.registerBlock("deepslate_3x", 0.8f, MapColor.DEEPSLATE);

    ITEM_1X = ITEMS.registerSimpleBlockItem("deepslate_1x", BLOCK_1X);
    ITEM_2X = ITEMS.registerSimpleBlockItem("deepslate_2x", BLOCK_2X);
    ITEM_3X = ITEMS.registerSimpleBlockItem("deepslate_3x", BLOCK_3X);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :