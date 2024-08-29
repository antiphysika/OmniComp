/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static antiphysika.omnicomp.OmniComp.MOD_ID;
import antiphysika.omnicomp.common.staticdata.StaticLangData;

import antiphysika.omnicomp.common.registry.block.*;

public class Registrar
{
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OMNICOMP_TAB =
    CREATIVE_MODE_TABS.register("omnicomp_tab", () -> CreativeModeTab.builder()
      .title(Component.translatable(StaticLangData.CREATIVE_MOD_TAB_TITLE_KEY))
      .withTabsBefore(CreativeModeTabs.COMBAT)
      .icon(() -> CompressedCobblestone.ITEM_1X.get().getDefaultInstance())
      .displayItems((parameters, output) ->
      {
        BLOCKS.getEntries().forEach(e ->
        {
          Item item = e.get().asItem();
          output.accept(item);
        });
        ITEMS.getEntries().forEach(e ->
        {
          Item item = e.get();
          output.accept(item);
        });
      }).build()
    );

  /**
   * Register a simple block
   *
   * @param name      Registry name for block
   * @param strength  Block strength property
   * @param colour    Block map colour property
   *
   * @return Returns {@link DeferredBlock} for block to register
   */
  public static DeferredBlock<Block> registerBlock (String name, float strength, MapColor colour)
  {
    BlockBehaviour.Properties blockProps = BlockBehaviour.Properties.of()
      .strength(strength)
      .mapColor(colour)
      .requiresCorrectToolForDrops();

    return BLOCKS.registerSimpleBlock(name, blockProps);
  }

  /**
   * Get an {@link Iterable<Block>} for all known mod blocks.
   *
   * Helper to fetch a list of all blocks registered by the mod, primarily used
   * by the datagen code for block models, loot and tags.
   *
   * @return Returns an iterable list of blocks
   */
  public static Iterable<Block> getKnownBlocks ()
  {
    return BLOCKS.getEntries()
      .stream()
      .map(entry -> (Block) entry.value())
      .toList();
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   */
  public static void initCompBlocks ()
  {
    CompressedDirt.init();
    CompressedCoarseDirt.init();

    CompressedCobblestone.init();
    CompressedMossyCobblestone.init();
    CompressedStone.init();

    CompressedAndesite.init();
    CompressedDiorite.init();
    CompressedGranite.init();
    CompressedCalcite.init();

    CompressedDeepslate.init();
    CompressedCobbledDeepslate.init();

    CompressedGravel.init();
    CompressedSand.init();
    CompressedSandstone.init();

    CompressedNetherrack.init();
    CompressedSoulSand.init();
    CompressedSoulSoil.init();

    CompressedEndStone.init();
  }

  /**
   * Register mod blocks, items and creative mode tab
   *
   * @param bus Mod event bus
   */
  public static void register (IEventBus bus)
  {
    // Initialise compressed block variants
    initCompBlocks();

    // Register blocks and items
    BLOCKS.register(bus);
    ITEMS.register(bus);

    // Register creative mode tab
    CREATIVE_MODE_TABS.register(bus);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :