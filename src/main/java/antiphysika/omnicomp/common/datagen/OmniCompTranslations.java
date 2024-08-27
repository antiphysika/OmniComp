/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.config.StaticBlockConfig;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompTranslations extends LanguageProvider
{
  public OmniCompTranslations (PackOutput output, String locale)
  {
    super(output, MOD_ID, locale);
  }

  private String transKey (String type, String key)
  {
    return String.format("%s.%s.%s", type, MOD_ID, key);
  }

  private String blockTransKey (String key)
  {
    return transKey("block", key);
  }

  private String advTransKey (String key)
  {
    return transKey("advancement", key);
  }

  private void compBlockTranslations (String id, String name)
  {
    for (int level = 1; level < 4; ++level)
    {
      String key = blockTransKey(OmniComp.block(id, level).getPath());
      String str = String.format("Compressed %s (%dx) Block", name, level);
      add(key, str);
    }
  }

  @Override
  protected void addTranslations()
  {
    // Blocks
    //

    for (var block : StaticBlockConfig.getAllBlocks())
    {
      compBlockTranslations(block.id, block.name);
    }

    // Advancements
    //

    add(advTransKey(
      "craft_compressed_block.title"),
      "Compressed blocks all the way down!");

    add(advTransKey(
      "craft_compressed_block.description"),
      "Obtained when crafting any 1x compressed block variant"
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :