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
import antiphysika.omnicomp.common.registry.block.*;

public class Registrar
{
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param name
   * @param strength
   * @param colour
   * @return
   */
  public static DeferredBlock<Block> registerBlock (String name, float strength, MapColor colour)
  {
    return BLOCKS.registerSimpleBlock(name,
      BlockBehaviour.Properties.of()
        .strength(strength)
        .mapColor(colour)
        .requiresCorrectToolForDrops()
    );
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @return
   */
  public static Iterable<Block> getKnownBlocks ()
  {
    return BLOCKS.getEntries()
      .stream()
      .map(e -> (Block) e.value())
      .toList();
  }

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OMNICOMP_TAB =
    CREATIVE_MODE_TABS.register("omnicomp_tab", () -> CreativeModeTab.builder()
      .title(Component.literal("OmniComp"))
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
   * [JAVADOC-PLACEHOLDER]
   */
  public static void initCompBlocks ()
  {
    CompressedDirt.init();
    CompressedCoarseDirt.init();

    CompressedCobblestone.init();
    CompressedStone.init();

    CompressedDeepslate.init();
    CompressedCobbledDeepslate.init();

    CompressedGravel.init();
    CompressedSand.init();
    CompressedSandstone.init();
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param bus
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