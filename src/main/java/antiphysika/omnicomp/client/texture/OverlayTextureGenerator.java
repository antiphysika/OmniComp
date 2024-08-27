/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.client.texture;

import dev.lukebemish.dynamicassetgenerator.api.client.AssetResourceCache;
import dev.lukebemish.dynamicassetgenerator.api.client.generators.TexSource;
import dev.lukebemish.dynamicassetgenerator.api.client.generators.TextureGenerator;
import dev.lukebemish.dynamicassetgenerator.api.client.generators.texsources.OverlaySource;
import dev.lukebemish.dynamicassetgenerator.api.client.generators.texsources.TextureReaderSource;

import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;

public class OverlayTextureGenerator
{
  private final ResourceLocation output;
  private final ArrayList<TexSource> layers;

  public OverlayTextureGenerator (ResourceLocation output)
  {
    this.output = output;
    this.layers = new ArrayList<>();
  }

  public void addLayer (ResourceLocation location)
  {
    this.layers.add(new TextureReaderSource.Builder().setPath(location).build());
  }

  public void addLayer (String location)
  {
    addLayer(ResourceLocation.parse(location));
  }

  public void generate (AssetResourceCache cache)
  {
    cache.planSource(
      new TextureGenerator(output, new OverlaySource.Builder().setSources(layers).build())
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :