package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class OnPlayerRespawnProcedure {
	public OnPlayerRespawnProcedure() {
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
			execute(newPlayer.level());
		});
	}

	public static void execute(LevelAccessor world) {
		ConfigWriteProcedure.execute(world);
	}
}
