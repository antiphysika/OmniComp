/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static antiphysika.omnicomp.OmniComp.MOD_ID;

public class OmniCompTranslations extends LanguageProvider
{
  public OmniCompTranslations (PackOutput output, String locale)
  {
    super(output, MOD_ID, locale);
  }

  private String blockTransKey (String name)
  {
    return String.format("block.%s.%s", MOD_ID, name);
  }

  @Override
  protected void addTranslations()
  {
    add(blockTransKey("cobblestone_1x"), "Cobblestone 1x Block");
    add(blockTransKey("cobblestone_2x"), "Cobblestone 2x Block");
    add(blockTransKey("cobblestone_3x"), "Cobblestone 3x Block");
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :