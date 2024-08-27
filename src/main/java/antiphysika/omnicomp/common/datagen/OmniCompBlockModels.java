/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import antiphysika.omnicomp.OmniComp;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.common.registry.Registrar;
import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompBlockModels extends BlockStateProvider
{
  public OmniCompBlockModels (PackOutput output, ExistingFileHelper exFileHelper)
  {
    super(output, MOD_ID, exFileHelper);

    // Trick data generators into thinking our dynamically-generated textures exist
    exFileHelper.trackGenerated(OmniComp.id("block/cobblestone_1x"), ModelProvider.TEXTURE);
    exFileHelper.trackGenerated(OmniComp.id("block/cobblestone_2x"), ModelProvider.TEXTURE);
    exFileHelper.trackGenerated(OmniComp.id("block/cobblestone_3x"), ModelProvider.TEXTURE);
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
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :