/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.staticdata;

import java.util.List;

public class StaticBlockData
{
  public static class Block
  {
    public final String id;
    public final String name;

    public Block (String id, String name)
    {
      this.id = id;
      this.name = name;
    }
  }

  public static final Block COBBLESTONE =
    new Block("cobblestone", "Cobblestone");

  public static final Block MOSSY_COBBLESTONE =
    new Block("mossy_cobblestone", "Mossy Cobblestone");

  public static final Block STONE =
    new Block("stone", "Stone");

  public static final Block COBBLED_DEEPSLATE =
    new Block("cobbled_deepslate", "Cobbled Deepslate");

  public static final Block DEEPSLATE =
    new Block("deepslate", "Deepslate");

  public static final Block DIRT =
    new Block("dirt", "Dirt");

  public static final Block COARSE_DIRT =
    new Block("coarse_dirt", "Coarse Dirt");

  public static final Block GRAVEL =
    new Block("gravel", "Gravel");

  public static final Block SAND =
    new Block("sand", "Sand");

  public static final Block SANDSTONE =
    new Block("sandstone", "Sandstone");

  public static final Block ANDESITE =
    new Block("andesite", "Andesite");

  public static final Block DIORITE =
    new Block("diorite", "Diorite");

  public static final Block GRANITE =
    new Block("granite", "Granite");

  public static final Block CALCITE =
    new Block("calcite", "Calcite");

  public static final Block NETHERRACK =
    new Block("netherrack", "Netherrack");

  public static final Block SOUL_SAND =
    new Block("soul_sand", "Soul Sand");

  public static final Block SOUL_SOIL =
    new Block("soul_soil", "Soul Soil");

  public static final Block END_STONE =
    new Block("end_stone", "End Stone");

  public static List<Block> getAllBlocks ()
  {
    return List.of(
      COBBLESTONE,
      MOSSY_COBBLESTONE,
      STONE,
      COBBLED_DEEPSLATE,
      DEEPSLATE,
      DIRT,
      COARSE_DIRT,
      GRAVEL,
      SAND,
      SANDSTONE,
      ANDESITE,
      DIORITE,
      GRANITE,
      CALCITE,
      NETHERRACK,
      SOUL_SAND,
      SOUL_SOIL,
      END_STONE
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :