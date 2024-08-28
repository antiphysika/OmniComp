/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.staticdata.StaticBlockData;

public class OmniCompTranslations extends LanguageProvider
{
  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param locale
   */
  public OmniCompTranslations (PackOutput output, String locale)
  {
    super(output, OmniComp.MOD_ID, locale);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param type
   * @param key
   * @return
   */
  private String transKey (String type, String key)
  {
    return String.format("%s.%s.%s", type, OmniComp.MOD_ID, key);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param key
   * @return
   */
  private String blockTransKey (String key)
  {
    return transKey("block", key);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param key
   * @return
   */
  private String advTransKey (String key)
  {
    return transKey("advancement", key);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param id
   * @param name
   */
  private void compBlockTranslations (String id, String name)
  {
    for (int level = 1; level < 4; ++level)
    {
      String key = blockTransKey(OmniComp.blockLocation(id, level).getPath());
      String str = String.format("Compressed %s (%dx) Block", name, level);
      add(key, str);
    }
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   */
  @Override
  protected void addTranslations()
  {
    // Blocks
    //

    for (var block : StaticBlockData.getAllBlocks())
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