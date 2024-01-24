
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.haipadev.washedminerals.procedures.WashingFanUpdateTickProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredUpdateTickProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredTickProcessTimerProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredTickDeathTimerProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredRestartProcessTimerProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredRestartDeathTimerProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredLoopSoundProcedure;
import net.haipadev.washedminerals.procedures.WashingFanPoweredBlockAddedProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class WashedMineralsModProcedures {
	public static void load() {
		new WashingFanUpdateTickProcedure();
		new WashingFanPoweredUpdateTickProcedure();
		new WashingFanPoweredBlockAddedProcedure();
		new WashingFanPoweredRestartDeathTimerProcedure();
		new WashingFanPoweredTickDeathTimerProcedure();
		new WashingFanPoweredRestartProcessTimerProcedure();
		new WashingFanPoweredTickProcessTimerProcedure();
		new WashingFanPoweredLoopSoundProcedure();
	}
}
