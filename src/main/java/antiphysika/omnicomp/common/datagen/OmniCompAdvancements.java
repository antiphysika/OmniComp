/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.datagen;

import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import antiphysika.omnicomp.OmniComp;
import antiphysika.omnicomp.common.registry.block.CompressedCobblestone;

import static antiphysika.omnicomp.common.staticdata.StaticAdvancementData.*;

public class OmniCompAdvancements extends AdvancementProvider
{
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
     * Get {@link AdvancementHolder} for advancement
     *
     * @param location Advancement location string
     *
     * @return Returns {@link AdvancementHolder} for advancement
     */
    private AdvancementHolder getAdvHolder (String location)
    {
      return AdvancementSubProvider.createPlaceholder(location);
    }

    /**
     * Get {@link ResourceLocation} for advancement UI background texture
     *
     * @return Returns {@link ResourceLocation} for texture
     */
    private ResourceLocation getBackgroundTextureLocation ()
    {
      return ResourceLocation.withDefaultNamespace(
        "textures/gui/advancements/backgrounds/stone.png"
      );
    }

    /**
     * Get {@link Criterion} for item in inventory
     *
     * @param item Required item
     *
     * @return Returns {@link Criterion} for item
     */
    private Criterion<InventoryChangeTrigger.TriggerInstance> itemCriterion (ItemLike item)
    {
      return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

    /**
     * Datagen mod addvancements
     *
     * @param provider      Registry provider
     * @param consumer      Advancement consumer
     * @param exFileHelper  Instance of {@link ExistingFileHelper}
     */
    @Override
    public void generate (@NotNull HolderLookup.Provider provider,
                          @NotNull Consumer<AdvancementHolder> consumer,
                          @NotNull ExistingFileHelper exFileHelper)
    {
      Advancement.Builder.advancement().display(
        Blocks.PISTON,
        ROOT_TITLE,
        ROOT_DESCRIPTION,
        getBackgroundTextureLocation(),
        AdvancementType.TASK,
        false,
        false,
        false
      )
      .addCriterion(ROOT_CRITERION_KEY, itemCriterion(Blocks.CRAFTING_TABLE))
      .save(consumer, ROOT_LOCATION, exFileHelper);

      Advancement.Builder.advancement()
        .parent(getAdvHolder(ROOT_LOCATION_STRING))
        .display(
          new ItemStack(CompressedCobblestone.ITEM_1X.get()),
          COBBLESTONE_1X_TITLE,
          COBBLESTONE_1X_DESCRIPTION,
          null,
          AdvancementType.GOAL,
          true,
          true,
          false
        )
        .addCriterion("cobblestone_1x_crafted", itemCriterion(CompressedCobblestone.ITEM_1X))
        .requirements(AdvancementRequirements.allOf(List.of("cobblestone_1x_crafted")))
        .save(consumer, COBBLESTONE_1X_LOCATION, exFileHelper);
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :