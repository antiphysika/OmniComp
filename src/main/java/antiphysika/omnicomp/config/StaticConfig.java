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
    new Block("stone", "stone");

  public static List<Block> getAllBlocks ()
  {
    return List.of(COBBLESTONE, STONE);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :