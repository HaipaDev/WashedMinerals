/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.haipadev.washedminerals;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.haipadev.washedminerals.init.WashedMineralsModSounds;
import net.haipadev.washedminerals.init.WashedMineralsModProcedures;
import net.haipadev.washedminerals.init.WashedMineralsModItems;
import net.haipadev.washedminerals.init.WashedMineralsModItemExtensions;
import net.haipadev.washedminerals.init.WashedMineralsModBlocks;
import net.haipadev.washedminerals.init.WashedMineralsModBlockEntities;

import net.fabricmc.api.ModInitializer;

public class WashedMineralsMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "washed_minerals";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing WashedMineralsMod");

		WashedMineralsModBlocks.load();
		WashedMineralsModItems.load();
		WashedMineralsModBlockEntities.load();

		WashedMineralsModProcedures.load();

		WashedMineralsModItemExtensions.load();

		WashedMineralsModSounds.load();

	}
}
