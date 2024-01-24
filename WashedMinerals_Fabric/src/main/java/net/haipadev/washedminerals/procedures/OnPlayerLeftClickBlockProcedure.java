package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.InteractionResult;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;

public class OnPlayerLeftClickBlockProcedure {
	public OnPlayerLeftClickBlockProcedure() {
		AttackBlockCallback.EVENT.register((player, level, hand, pos, direction) -> {
			if (hand != player.getUsedItemHand())
				return InteractionResult.PASS;
			execute(level);
			return InteractionResult.PASS;
		});
	}

	public static void execute(LevelAccessor world) {
		ConfigWriteProcedure.execute(world);
	}
}
