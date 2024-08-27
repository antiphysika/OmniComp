/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class Registrar
{
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

  private static DeferredBlock<Block> registerBlock (String name, float strength, MapColor colour)
  {
    return BLOCKS.registerSimpleBlock(name,
      BlockBehaviour.Properties.of()
        .strength(strength)
        .mapColor(colour)
        .requiresCorrectToolForDrops()
    );
  }

  // Cobblestone
  //

  public static final DeferredBlock<Block> COBBLESTONE_1X =
    registerBlock("cobblestone_1x", 0.8f, MapColor.STONE);

  public static final DeferredBlock<Block> COBBLESTONE_2X =
    registerBlock("cobblestone_2x", 0.8f, MapColor.STONE);

  public static final DeferredBlock<Block> COBBLESTONE_3X =
    registerBlock("cobblestone_3x", 0.8f, MapColor.STONE);

  public static final DeferredItem<BlockItem> COBBLESTONE_1X_ITEM =
    ITEMS.registerSimpleBlockItem("cobblestone_1x", COBBLESTONE_1X);

  public static final DeferredItem<BlockItem> COBBLESTONE_2X_ITEM =
    ITEMS.registerSimpleBlockItem("cobblestone_2x", COBBLESTONE_2X);

  public static final DeferredItem<BlockItem> COBBLESTONE_3X_ITEM =
    ITEMS.registerSimpleBlockItem("cobblestone_3x", COBBLESTONE_3X);

  // Creative mode tab
  //

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OMNICOMP_TAB =
    CREATIVE_MODE_TABS.register("omnicomp_tab", () -> CreativeModeTab.builder()
      .title(Component.literal("OmniComp"))
      .withTabsBefore(CreativeModeTabs.COMBAT)
      .icon(() -> COBBLESTONE_1X_ITEM.get().getDefaultInstance())
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

  // Registration
  //

  public static void register (IEventBus bus)
  {
    // Register blocks and items
    BLOCKS.register(bus);
    ITEMS.register(bus);

    // Register creative mode tab
    CREATIVE_MODE_TABS.register(bus);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :