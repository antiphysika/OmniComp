/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.registry.block.CompressedCobblestone;
import antiphysika.omnicomp.common.staticdata.StaticLangData;

public class OmniCompAdvancements extends AdvancementProvider
{
  /**
   * [JAVADOC-PLACEHOLDER]
   *
   * @param output
   * @param lookupProvider
   * @param exFileHelper
   */
  public OmniCompAdvancements (PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               ExistingFileHelper exFileHelper)
  {
    super(output, lookupProvider, exFileHelper, List.of(new OmniCompAdvancementGenerator()));
  }

  private static final class OmniCompAdvancementGenerator
    implements AdvancementProvider.AdvancementGenerator
  {
    /**
     * [JAVADOC-PLACEHOLDER]
     *
     * @param provider
     * @param consumer
     * @param exFileHelper
     */
    @Override
    public void generate (@NotNull HolderLookup.Provider provider,
                          @NotNull Consumer<AdvancementHolder> consumer,
                          @NotNull ExistingFileHelper exFileHelper)
    {
      Advancement.Builder builder = Advancement.Builder.advancement();

      // FIXME: It'd be nice if we had our own advancement tree some day...
      builder.parent(AdvancementSubProvider.createPlaceholder("minecraft:story/root"));

      builder.display(
        new ItemStack(CompressedCobblestone.ITEM_1X.get()),
        Component.translatable(StaticLangData.ADVANCEMENT_TITLE_KEY),
        Component.translatable(StaticLangData.ADVANCEMENT_DESCRIPTION_KEY),
        null, AdvancementType.GOAL, true, true, false
      );

      builder.addCriterion(
        "recipe_crafted",
        InventoryChangeTrigger.TriggerInstance.hasItems(CompressedCobblestone.ITEM_1X)
      );

      builder.requirements(
        AdvancementRequirements.allOf(List.of("recipe_crafted"))
      );

      builder.save(consumer, OmniComp.location("craft_compressed_block"), exFileHelper);
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :