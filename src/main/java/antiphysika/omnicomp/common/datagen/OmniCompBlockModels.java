/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import antiphysika.omnicomp.client.texture.DynamicTextureManager;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import org.jetbrains.annotations.NotNull;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

import antiphysika.omnicomp.common.registry.Registrar;

public class OmniCompBlockModels extends BlockStateProvider
{
  public OmniCompBlockModels (PackOutput output, ExistingFileHelper exFileHelper)
  {
    super(output, MOD_ID, exFileHelper);

    for (var location : DynamicTextureManager.getGenerated().toArray())
    {
      // The `exFileHelper.trackGenerated()` call tricks the existing file helper into
      // thinking that the assets we'll dynamically generate at runtime actually exists
      // on-disk.
      //
      exFileHelper.trackGenerated((ResourceLocation) location, ModelProvider.TEXTURE);
    }
  }

  private void simpleBlockWithItem (@NotNull Block block)
  {
    simpleBlockWithItem(block, cubeAll(block));
  }

  private Iterable<Block> getKnownBlocks ()
  {
    return Registrar.getKnownBlocks();
  }

  @Override
  protected void registerStatesAndModels()
  {
    for (var block : getKnownBlocks())
    {
      simpleBlockWithItem(block);
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :