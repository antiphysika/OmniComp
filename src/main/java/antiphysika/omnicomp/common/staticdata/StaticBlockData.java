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

  public static final Block CLAY =
    new Block("clay", "Clay");

  public static final Block MUD =
    new Block("mud", "Mud");

  public static final Block TUFF =
    new Block("tuff", "Tuff");

  public static final Block RED_SAND =
    new Block("red_sand", "Red Sand");

  public static final Block RED_SANDSTONE =
    new Block("red_sandstone", "Red Sandstone");

  public static final Block BASALT =
    new Block("basalt", "Basalt");

  public static final Block BLACKSTONE =
    new Block("blackstone", "Blackstone");

  public static final Block DRIPSTONE =
    new Block("dripstone_block", "Dripstone Block");

  public static final Block OBSIDIAN =
    new Block("obsidian", "Obsidian");

  public static final Block GLOWSTONE =
    new Block("glowstone", "Glowstone");

  public static final Block COAL_BLOCK =
    new Block("coal_block", "Block of Coal");

  public static final Block COPPER_BLOCK =
    new Block("copper_block", "Block of Copper");

  public static final Block IRON_BLOCK =
    new Block("iron_block", "Block of Iron");

  public static final Block GOLD_BLOCK =
    new Block("gold_block", "Block of Gold");

  public static final Block LAPIS_LAZULI_BLOCK =
    new Block("lapis_lazuli_block", "Block of Lapis Lazuli");

  public static final Block REDSTONE_BLOCK =
    new Block("redstone_block", "Block of Redstone");

  public static final Block EMERALD_BLOCK =
    new Block("emerald_block", "Block of Emerald");

  public static final Block DIAMOND_BLOCK =
    new Block("diamond_block", "Block of Diamond");

  public static final Block NETHERITE_BLOCK =
    new Block("netherite_block", "Block of Netherite");

  public static final Block QUARTZ_BLOCK =
    new Block("quartz_block", "Quartz Block");

  public static final Block AMETHYST_BLOCK =
    new Block("amethyst_block", "Amethyst Block");

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
      END_STONE,
      CLAY,
      MUD,
      TUFF,
      RED_SAND,
      RED_SANDSTONE,
      BASALT,
      BLACKSTONE,
      DRIPSTONE,
      OBSIDIAN,
      GLOWSTONE,
      COAL_BLOCK,
      COPPER_BLOCK,
      IRON_BLOCK,
      GOLD_BLOCK,
      LAPIS_LAZULI_BLOCK,
      REDSTONE_BLOCK,
      EMERALD_BLOCK,
      DIAMOND_BLOCK,
      NETHERITE_BLOCK,
      QUARTZ_BLOCK,
      AMETHYST_BLOCK
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :