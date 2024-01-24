package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class OnBlockBrokenProcedure {
	public OnBlockBrokenProcedure() {
		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockentity) -> {
			execute(world);
			return true;
		});
	}

	public static void execute(LevelAccessor world) {
		ConfigWriteProcedure.execute(world);
	}
}
