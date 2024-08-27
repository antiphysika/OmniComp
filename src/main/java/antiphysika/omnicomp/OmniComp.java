/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp;

import net.minecraft.resources.ResourceLocation;

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
public class OmniComp
{
  public static final String MOD_ID = "omnicomp";

  private static OmniComp INSTANCE;
  private static final Logger LOGGER = LogUtils.getLogger();

  public OmniComp (IEventBus bus, ModContainer container)
  {
    INSTANCE = this;

    // Add listener for FMLCommonSetupEvent event
    bus.addListener(this::initCommon);

    // Deferred registers
    Registrar.register(bus);
  }

  public static OmniComp getInstance ()
  {
    return INSTANCE;
  }

  public static Logger getLogger ()
  {
    return LOGGER;
  }

  public static ResourceLocation id (String path)
  {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }

  public static ResourceLocation id (String namespace, String path)
  {
    return ResourceLocation.fromNamespaceAndPath(namespace, path);
  }

  public static ResourceLocation block (String id, int level)
  {
    return id(String.format("%s_%dx", id, level));
  }

  private void initCommon (final FMLCommonSetupEvent event)
  {
    LOGGER.debug("In {}.initCommon()", MOD_ID);

    LOGGER.debug("Registered blocks:");
    for (var block : Registrar.getKnownBlocks())
    {
      LOGGER.debug("- " + block.toString());
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