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

  /**
   * Generate the three textures for a given compressed block variant
   *
   * @param parent Variant block parent
   */
  public static void generateCompBlockTextures (String parent)
  {
    generateCompBlockTexture(parent, 1);
    generateCompBlockTexture(parent, 2);
    generateCompBlockTexture(parent, 3);
  }

  /**
   * Mark texture as dynamically generated
   *
   * @param location Texture location
   */
  private static void trackGenerated (ResourceLocation location)
  {
    GENERATED.add(location);
  }

  /**
   * Get list of {@link ResourceLocation} instances for generated textures
   *
   * @return Returns list of generated textures
   */
  public static List<ResourceLocation> getGenerated ()
  {
    return GENERATED;
  }

  /**
   * Get path part for block texture resource location
   *
   * @param name Block to get texture path for
   *
   * @return Returns a {@link String} representing the block's texture path
   */
  private static String getBlockTexturePath (String name)
  {
    return switch (name)
    {
      // Basalt and quartz blocks have only `_side` and `_top` textures
      case "basalt" -> "block/" + name + "_top";
      case "quartz_block" -> "block/" + name + "_top";

      // Vanilla tech debt, yay!
      case "lapis_lazuli_block" -> "block/" + "lapis_block";

      // Default: "block/$name"
      default -> "block/" + name;
    };
  }

  /**
   * Generate a single compressed block variant's texture
   *
   * @param parent  Variant block parent
   * @param level   Compression level (1-3)
   */
  private static void generateCompBlockTexture (String parent, int level)
  {
    ResourceLocation outputLoc = OmniComp.blockLocation("block/" + parent, level);
    OverlayTextureGenerator gen = new OverlayTextureGenerator(outputLoc);

    gen.addLayer(OmniComp.location(String.format("overlay/%dx", level)));
    gen.addLayer(OmniComp.location("minecraft", getBlockTexturePath(parent)));

    gen.generate(DynamicTextureManager.getAssetCache());
    OmniComp.getLogger().debug("Generated texture: " + outputLoc.toString());

    trackGenerated(outputLoc);
  }

  /**
   * Generate textures for all compressed block variants
   */
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