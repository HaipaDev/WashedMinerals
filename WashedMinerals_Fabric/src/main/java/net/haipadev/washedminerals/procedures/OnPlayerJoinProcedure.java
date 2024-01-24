package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class OnPlayerJoinProcedure {
	public OnPlayerJoinProcedure() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			execute(handler.getPlayer().level());
		});
	}

	public static void execute(LevelAccessor world) {
		ConfigWriteProcedure.execute(world);
	}
}
