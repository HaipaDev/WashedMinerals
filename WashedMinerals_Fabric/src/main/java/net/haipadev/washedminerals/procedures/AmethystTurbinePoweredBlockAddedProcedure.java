package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;

public class AmethystTurbinePoweredBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AmethystTurbinePoweredRestartProcessTimerProcedure.execute(world, x, y, z);
	}
}
