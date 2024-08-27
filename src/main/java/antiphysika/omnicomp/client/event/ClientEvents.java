/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.client.event;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.client.texture.DynamicTextureManager;
import antiphysika.omnicomp.client.texture.OverlayTextureGenerator;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents
{
  static
  {
    generateCobblestoneTextures();
    generateStoneTextures();
  }

  @SubscribeEvent
  public static void onClientSetup (FMLClientSetupEvent event)
  {
  }

  private static void generateCobblestoneTextures ()
  {
    OverlayTextureGenerator gen1x =
      new OverlayTextureGenerator(OmniComp.id("block/cobblestone_1x"));
    gen1x.addLayer(OmniComp.id("overlay/1x"));
    gen1x.addLayer("minecraft:block/cobblestone");
    gen1x.generate(DynamicTextureManager.ASSET_CACHE);

    OverlayTextureGenerator gen2x =
      new OverlayTextureGenerator(OmniComp.id("block/cobblestone_2x"));
    gen2x.addLayer(OmniComp.id("overlay/2x"));
    gen2x.addLayer("minecraft:block/cobblestone");
    gen2x.generate(DynamicTextureManager.ASSET_CACHE);

    OverlayTextureGenerator gen3x =
      new OverlayTextureGenerator(OmniComp.id("block/cobblestone_3x"));
    gen3x.addLayer(OmniComp.id("overlay/3x"));
    gen3x.addLayer("minecraft:block/cobblestone");
    gen3x.generate(DynamicTextureManager.ASSET_CACHE);
  }

  private static void generateStoneTextures ()
  {
    OverlayTextureGenerator gen1x =
      new OverlayTextureGenerator(OmniComp.id("block/stone_1x"));
    gen1x.addLayer(OmniComp.id("overlay/1x"));
    gen1x.addLayer("minecraft:block/stone");
    gen1x.generate(DynamicTextureManager.ASSET_CACHE);

    OverlayTextureGenerator gen2x =
      new OverlayTextureGenerator(OmniComp.id("block/stone_2x"));
    gen2x.addLayer(OmniComp.id("overlay/2x"));
    gen2x.addLayer("minecraft:block/stone");
    gen2x.generate(DynamicTextureManager.ASSET_CACHE);

    OverlayTextureGenerator gen3x =
      new OverlayTextureGenerator(OmniComp.id("block/stone_3x"));
    gen3x.addLayer(OmniComp.id("overlay/3x"));
    gen3x.addLayer("minecraft:block/stone");
    gen3x.generate(DynamicTextureManager.ASSET_CACHE);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :