/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.omnicomp.common.registry.init;

import antiphysika.omnicomp.common.registry.block.*;

public class BlockInit
{
  /**
   * Initialise all compressed block variants
   */
  public static void init ()
  {
    CompressedDirt.init();
    CompressedCoarseDirt.init();

    CompressedCobblestone.init();
    CompressedMossyCobblestone.init();
    CompressedStone.init();

    CompressedAndesite.init();
    CompressedDiorite.init();
    CompressedGranite.init();
    CompressedCalcite.init();

    CompressedDeepslate.init();
    CompressedCobbledDeepslate.init();
    CompressedTuff.init();
    CompressedDripstoneBlock.init();

    CompressedGravel.init();
    CompressedSand.init();
    CompressedSandstone.init();
    CompressedRedSand.init();
    CompressedRedSandstone.init();
    CompressedClay.init();
    CompressedMud.init();

    CompressedObsidian.init();
    CompressedGlowstone.init();

    CompressedNetherrack.init();
    CompressedSoulSand.init();
    CompressedSoulSoil.init();
    CompressedBasalt.init();
    CompressedBlackstone.init();

    CompressedEndStone.init();

    CompressedCopperBlock.init();
    CompressedCoalBlock.init();
    CompressedIronBlock.init();
    CompressedGoldBlock.init();
    CompressedLapisLazuliBlock.init();
    CompressedRedstoneBlock.init();
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :