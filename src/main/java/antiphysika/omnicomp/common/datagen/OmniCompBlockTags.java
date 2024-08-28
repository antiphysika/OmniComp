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

import static antiphysika.omnicomp.OmniComp.MOD_ID;
import antiphysika.omnicomp.common.registry.Registrar;

public class OmniCompBlockTags extends BlockTagsProvider
{
  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param lookupProvider
   * @param exFileHelper
   */
  public OmniCompBlockTags (PackOutput output,
                            CompletableFuture<HolderLookup.Provider> lookupProvider,
                            @Nullable ExistingFileHelper exFileHelper)
  {
    super(output, lookupProvider, MOD_ID, exFileHelper);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param provider
   */
  @Override
  protected void addTags(HolderLookup.Provider provider)
  {
    for (var block : Registrar.getKnownBlocks())
    {
      tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :