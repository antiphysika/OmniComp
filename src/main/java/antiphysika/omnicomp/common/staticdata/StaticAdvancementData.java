/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.staticdata;

import antiphysika.omnicomp.OmniComp;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import static antiphysika.omnicomp.common.staticdata.StaticLangData.*;

public class StaticAdvancementData
{
  // Root advancement
  //

  public static final MutableComponent ROOT_TITLE =
    Component.translatable(ADVANCEMENT_ROOT_TITLE_KEY);

  public static final MutableComponent ROOT_DESCRIPTION =
    Component.translatable(ADVANCEMENT_ROOT_DESCRIPTION_KEY);

  public static final ResourceLocation ROOT_LOCATION =
    OmniComp.location("story/root");

  public static final String ROOT_LOCATION_STRING =
    ROOT_LOCATION.toString();

  public static final String ROOT_CRITERION_KEY =
    "crafting_table";

  // Cobblestone 1x
  //

  public static final MutableComponent COBBLESTONE_1X_TITLE =
    Component.translatable(ADVANCEMENT_COBBLESTONE_1X_TITLE_KEY);

  public static final MutableComponent COBBLESTONE_1X_DESCRIPTION =
    Component.translatable(ADVANCEMENT_COBBLESTONE_1X_DESCRIPTION_KEY);

  public static final ResourceLocation COBBLESTONE_1X_LOCATION =
    ROOT_LOCATION.withSuffix("/cobblestone_1x");

  public static final String COBBLESTONE_1X_LOCATION_STRING =
    COBBLESTONE_1X_LOCATION.toString();

  public static final String COBBLESTONE_1X_CRITERION_KEY =
    "cobblestone_1x";
}

//
// vim: ts=2 sw=2 et fdm=marker :