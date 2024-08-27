/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.common.registry.Registrar;

public class OmniCompBlockLoot extends BlockLootSubProvider
{
  public OmniCompBlockLoot (HolderLookup.Provider lookupProvider)
  {
    super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
  }

  @Override
  @NotNull
  protected Iterable<Block> getKnownBlocks ()
  {
    return Registrar.BLOCKS.getEntries()
      .stream()
      .map(e -> (Block) e.value())
      .toList();
  }

  @Override
  protected void generate ()
  {
    dropSelf(Registrar.COBBLESTONE_1X.get());
    dropSelf(Registrar.COBBLESTONE_2X.get());
    dropSelf(Registrar.COBBLESTONE_3X.get());

    dropSelf(Registrar.STONE_1X.get());
    dropSelf(Registrar.STONE_2X.get());
    dropSelf(Registrar.STONE_3X.get());
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :