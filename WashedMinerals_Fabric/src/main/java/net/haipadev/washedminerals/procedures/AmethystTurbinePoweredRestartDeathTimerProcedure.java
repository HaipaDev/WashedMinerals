package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class AmethystTurbinePoweredRestartDeathTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double factor22Amnt = 0;
		double factorAmnt = 0;
		double factor22Slot = 0;
		double templateAmnt = 0;
		double factor2Slot = 0;
		double factor2Amnt = 0;
		double templateSlot = 0;
		double factorSlot = 0;
		double counterSlot = 0;
		double counterSlotAmnt = 0;
		double total_ticks = 0;
		double amntStartedAs0Slot = 0;
		amntStartedAs0Slot = 7;
		templateSlot = 8;
		factor22Slot = 9;
		factor2Slot = 10;
		factorSlot = 11;
		counterSlot = 12;
		BlockEntity _ent0 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent0 != null) {
			((RandomizableContainerBlockEntity) _ent0).removeItemNoUpdate((int) amntStartedAs0Slot);
		}
		BlockEntity _ent1 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent1 != null) {
			((RandomizableContainerBlockEntity) _ent1).removeItemNoUpdate((int) templateSlot);
		}
		BlockEntity _ent2 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent2 != null) {
			((RandomizableContainerBlockEntity) _ent2).removeItemNoUpdate((int) factor22Slot);
		}
		BlockEntity _ent3 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent3 != null) {
			((RandomizableContainerBlockEntity) _ent3).removeItemNoUpdate((int) factor2Slot);
		}
		BlockEntity _ent4 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent4 != null) {
			((RandomizableContainerBlockEntity) _ent4).removeItemNoUpdate((int) factorSlot);
		}
		BlockEntity _ent5 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent5 != null) {
			((RandomizableContainerBlockEntity) _ent5).removeItemNoUpdate((int) counterSlot);
		}
		AmethystTurbineSetDeathTimerProcedure.execute(world, x, y, z);
	}
}
