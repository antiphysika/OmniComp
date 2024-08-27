/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import org.jetbrains.annotations.NotNull;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.registry.Registrar;

public class OmniCompBlockModels extends BlockStateProvider
{
  public OmniCompBlockModels (PackOutput output, ExistingFileHelper exFileHelper)
  {
    super(output, MOD_ID, exFileHelper);

    // The `exFileHelper.trackGenerated()` calls trick the existing file helper into
    // thinking that the assets we'll dynamically generate at runtime actually exist
    // on disk.
    //

    exFileHelper.trackGenerated(OmniComp.id("block/cobblestone_1x"), ModelProvider.TEXTURE);
    exFileHelper.trackGenerated(OmniComp.id("block/cobblestone_2x"), ModelProvider.TEXTURE);
    exFileHelper.trackGenerated(OmniComp.id("block/cobblestone_3x"), ModelProvider.TEXTURE);

    exFileHelper.trackGenerated(OmniComp.id("block/stone_1x"), ModelProvider.TEXTURE);
    exFileHelper.trackGenerated(OmniComp.id("block/stone_2x"), ModelProvider.TEXTURE);
    exFileHelper.trackGenerated(OmniComp.id("block/stone_3x"), ModelProvider.TEXTURE);
  }

  private void simpleBlockWithItem (@NotNull DeferredBlock<Block> block)
  {
    simpleBlockWithItem(block.get(), cubeAll(block.get()));
  }

  @Override
  protected void registerStatesAndModels()
  {
    simpleBlockWithItem(Registrar.COBBLESTONE_1X);
    simpleBlockWithItem(Registrar.COBBLESTONE_2X);
    simpleBlockWithItem(Registrar.COBBLESTONE_3X);

    simpleBlockWithItem(Registrar.STONE_1X);
    simpleBlockWithItem(Registrar.STONE_2X);
    simpleBlockWithItem(Registrar.STONE_3X);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :