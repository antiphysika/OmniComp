/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp;

import net.minecraft.resources.ResourceLocation;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompBase
{
  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param path
   * @return
   */
  public static ResourceLocation location (String path)
  {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param namespace
   * @param path
   * @return
   */
  public static ResourceLocation location (String namespace, String path)
  {
    return ResourceLocation.fromNamespaceAndPath(namespace, path);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param id
   * @param level
   * @return
   */
  public static ResourceLocation blockLocation (String id, int level)
  {
    return location(String.format("%s_%dx", id, level));
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :