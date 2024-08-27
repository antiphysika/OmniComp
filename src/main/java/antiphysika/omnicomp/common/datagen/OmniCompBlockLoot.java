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
    return Registrar.getKnownBlocks();
  }

  @Override
  protected void generate ()
  {
    for (var block : Registrar.BLOCKS.getEntries())
    {
      dropSelf(block.get());
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :