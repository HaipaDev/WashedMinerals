package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WashingFanPoweredBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double power = 0;
		WashingFanPoweredRestartDeathTimerProcedure.execute(world, x, y, z);
		WashingFanPoweredRestartProcessTimerProcedure.execute(world, x, y, z);
	}
}
