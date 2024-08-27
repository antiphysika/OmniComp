/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.client.texture;

import antiphysika.omnicomp.OmniComp;
import dev.lukebemish.dynamicassetgenerator.api.ResourceCache;
import dev.lukebemish.dynamicassetgenerator.api.client.AssetResourceCache;

public class DynamicTextureManager
{
  public static final AssetResourceCache ASSET_CACHE =
    ResourceCache.register(new AssetResourceCache(OmniComp.id("assets")));

  public static AssetResourceCache getAssetCache ()
  {
    return ASSET_CACHE;
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :