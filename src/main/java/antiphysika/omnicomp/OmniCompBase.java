/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp;

import net.minecraft.resources.ResourceLocation;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompBase
{
  public static ResourceLocation location (String path)
  {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }

  public static ResourceLocation location (String namespace, String path)
  {
    return ResourceLocation.fromNamespaceAndPath(namespace, path);
  }

  public static ResourceLocation blockLocation (String id, int level)
  {
    return location(String.format("%s_%dx", id, level));
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :