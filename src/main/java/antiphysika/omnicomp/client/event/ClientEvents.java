/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.client.event;

import antiphysika.omnicomp.client.texture.DynamicTextureManager;
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
    DynamicTextureManager.generateTextures();
  }

  @SubscribeEvent
  public static void onClientSetup (FMLClientSetupEvent event)
  {
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :