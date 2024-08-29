/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.staticdata.StaticBlockData;
import static antiphysika.omnicomp.common.staticdata.StaticLangData.*;

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
      String str = String.format("Compressed %s (%dx)", name, level);
      add(key, str);
    }
  }

  private void creativeModeTabTranslations ()
  {
    add(CREATIVE_MOD_TAB_TITLE_KEY, CREATIVE_MOD_TAB_TITLE);
  }

  private void blockTranslations ()
  {
    for (var block : StaticBlockData.getAllBlocks())
    {
      compBlockTranslations(block.id, block.name);
    }
  }

  private void advancementTranslations ()
  {
    add(ADVANCEMENT_ROOT_TITLE_KEY, ADVANCEMENT_ROOT_TITLE);
    add(ADVANCEMENT_ROOT_DESCRIPTION_KEY, ADVANCEMENT_ROOT_DESCRIPTION);

    add(ADVANCEMENT_COBBLESTONE_1X_TITLE_KEY, ADVANCEMENT_COBBLESTONE_1X_TITLE);
    add(ADVANCEMENT_COBBLESTONE_1X_DESCRIPTION_KEY, ADVANCEMENT_COBBLESTONE_1X_DESCRIPTION);
  }

  /**
   * [JAVADOC-PLACEHOLDER]
   */
  @Override
  protected void addTranslations()
  {
    creativeModeTabTranslations();
    blockTranslations();
    advancementTranslations();
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :