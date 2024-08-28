/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import antiphysika.omnicomp.common.registry.Registrar;
import antiphysika.omnicomp.client.texture.DynamicTextureManager;

@Mod(OmniComp.MOD_ID)
public class OmniComp extends OmniCompBase
{
  public static final String MOD_ID = "omnicomp";

  private static OmniComp INSTANCE;
  private static final Logger LOGGER = LogUtils.getLogger();

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param bus
   * @param container
   */
  public OmniComp (IEventBus bus, ModContainer container)
  {
    INSTANCE = this;

    // Add listener for FMLCommonSetupEvent event
    bus.addListener(OmniCompCommon::initCommon);

    // Deferred registers
    Registrar.register(bus);
  }

  /**
   *[JAVADOC-PLACEHOLDER]
   *
   * @return
   */
  public static OmniComp getInstance ()
  {
    return INSTANCE;
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @return
   */
  public static Logger getLogger ()
  {
    return LOGGER;
  }

  private static class OmniCompCommon
  {
    /**
     * [JAVADOC-PLACEHOLDER]
     *
     * @param event
     */
    private static void initCommon (final FMLCommonSetupEvent event)
    {
      LOGGER.debug("In {}.initCommon()", MOD_ID);

      LOGGER.debug("Registered blocks:");
      for (var block : Registrar.getKnownBlocks())
      {
        LOGGER.debug("- " + block.toString());
      }
    }
  }

  @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
  public static class OmniCompServer
  {
    @SubscribeEvent
    public static void onServerStarting (final ServerStartingEvent event)
    {
      LOGGER.debug("In OmniCompServer.onServerStarting()");
    }
  }

  @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class OmniCompClient
  {
    static
    {
      DynamicTextureManager.generateTextures();
    }

    @SubscribeEvent
    public static void onClientSetup (final FMLClientSetupEvent event)
    {
      LOGGER.debug("In OmniCompClient.onClientSetup()");
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :