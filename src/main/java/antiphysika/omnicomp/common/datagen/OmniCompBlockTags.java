/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;

import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import antiphysika.omnicomp.common.registry.Registrar;
import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompBlockTags extends BlockTagsProvider
{
  public OmniCompBlockTags (PackOutput output,
                            CompletableFuture<HolderLookup.Provider> lookupProvider,
                            @Nullable ExistingFileHelper exFileHelper)
  {
    super(output, lookupProvider, MOD_ID, exFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider)
  {
    // Cobblestone
    //

    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.COBBLESTONE_1X.get());
    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.COBBLESTONE_2X.get());
    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.COBBLESTONE_3X.get());

    // Stone
    //

    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.STONE_1X.get());
    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.STONE_2X.get());
    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.STONE_3X.get());
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :