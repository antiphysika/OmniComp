/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp;

import net.minecraft.resources.ResourceLocation;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompBase
{
  /**
   * Get {@link ResourceLocation} for mod resource
   *
   * @param path Path of resource
   *
   * @return Returns {@link ResourceLocation} instance for resource
   */
  public static ResourceLocation location (String path)
  {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }

  /**
   * Get {@link ResourceLocation} for namespaced resource
   *
   * @param namespace  Resource namespace
   * @param path       Resource path
   *
   * @return Returns {@link ResourceLocation} instance for resource
   */
  public static ResourceLocation location (String namespace, String path)
  {
    return ResourceLocation.fromNamespaceAndPath(namespace, path);
  }

  /**
   * Helper to get {@link ResourceLocation} for compressed block variant
   *
   * @param name   Block name
   * @param level  Compression level (1-3)
   *
   * @return Returns {@link ResourceLocation} instance for block
   */
  public static ResourceLocation blockLocation (String name, int level)
  {
    return location(String.format("%s_%dx", name, level));
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :