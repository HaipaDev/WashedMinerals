
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.haipadev.washedminerals.procedures.RedstoneProbeRightclickedOnBlockProcedure;
import net.haipadev.washedminerals.procedures.OnPlayerRespawnProcedure;
import net.haipadev.washedminerals.procedures.OnPlayerLeftClickBlockProcedure;
import net.haipadev.washedminerals.procedures.OnPlayerJoinProcedure;
import net.haipadev.washedminerals.procedures.OnBlockBrokenProcedure;
import net.haipadev.washedminerals.procedures.ConfigWriteProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbineUpdateTickProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbineSetDeathTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredUpdateTickProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredTickProcessTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredTickDeathTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredSetProcessTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredRestartProcessTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredRestartDeathTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredLoopSoundProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredClearProcessTimerProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbinePoweredBlockAddedProcedure;
import net.haipadev.washedminerals.procedures.AmethystTurbineBlockAddedProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class WashedMineralsModProcedures {
	public static void load() {
		new AmethystTurbinePoweredTickDeathTimerProcedure();
		new AmethystTurbinePoweredRestartDeathTimerProcedure();
		new AmethystTurbinePoweredRestartProcessTimerProcedure();
		new AmethystTurbinePoweredTickProcessTimerProcedure();
		new AmethystTurbinePoweredLoopSoundProcedure();
		new AmethystTurbineUpdateTickProcedure();
		new AmethystTurbinePoweredUpdateTickProcedure();
		new AmethystTurbinePoweredBlockAddedProcedure();
		new AmethystTurbineSetDeathTimerProcedure();
		new AmethystTurbineBlockAddedProcedure();
		new ConfigWriteProcedure();
		new OnPlayerJoinProcedure();
		new OnBlockBrokenProcedure();
		new OnPlayerRespawnProcedure();
		new RedstoneProbeRightclickedOnBlockProcedure();
		new OnPlayerLeftClickBlockProcedure();
		new AmethystTurbinePoweredSetProcessTimerProcedure();
		new AmethystTurbinePoweredClearProcessTimerProcedure();
	}
}
