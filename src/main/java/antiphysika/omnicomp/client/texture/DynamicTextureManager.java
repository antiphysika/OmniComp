/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.client.texture;

import antiphysika.omnicomp.common.staticdata.StaticBlockData;
import dev.lukebemish.dynamicassetgenerator.api.ResourceCache;
import dev.lukebemish.dynamicassetgenerator.api.client.AssetResourceCache;

import antiphysika.omnicomp.OmniComp;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class DynamicTextureManager
{
  private static final AssetResourceCache ASSET_CACHE =
    ResourceCache.register(new AssetResourceCache(OmniComp.location("assets")));

  private static final ArrayList<ResourceLocation> GENERATED = new ArrayList<>();

  public static AssetResourceCache getAssetCache ()
  {
    return ASSET_CACHE;
  }

  public static void generateCompBlockTextures (String parent)
  {
    generateCompBlockTexture(parent, 1);
    generateCompBlockTexture(parent, 2);
    generateCompBlockTexture(parent, 3);
  }

  private static void trackGenerated (ResourceLocation location)
  {
    GENERATED.add(location);
  }

  public static List<ResourceLocation> getGenerated ()
  {
    return GENERATED;
  }

  private static void generateCompBlockTexture (String parent, int level)
  {
    ResourceLocation outputLoc = OmniComp.blockLocation("block/" + parent, level);
    OverlayTextureGenerator gen = new OverlayTextureGenerator(outputLoc);

    gen.addLayer(OmniComp.location(String.format("overlay/%dx", level)));
    gen.addLayer(OmniComp.location("minecraft", "block/" + parent));

    gen.generate(DynamicTextureManager.getAssetCache());
    OmniComp.getLogger().debug("Generated texture: " + outputLoc.toString());

    trackGenerated(outputLoc);
  }

  public static void generateTextures ()
  {
    OmniComp.getLogger().debug("Generating textures...");

    for (var block : StaticBlockData.getAllBlocks())
    {
      DynamicTextureManager.generateCompBlockTextures(block.id);
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :