/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.config;

import java.util.List;

public class StaticConfig
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

  public static List<Block> getAllBlocks ()
  {
    return List.of(
      COBBLESTONE,
      STONE,
      COBBLED_DEEPSLATE,
      DEEPSLATE,
      DIRT,
      COARSE_DIRT
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :