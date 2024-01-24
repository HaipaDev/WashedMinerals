package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class AmethystTurbineBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AmethystTurbineSetDeathTimerProcedure.execute(world, x, y, z);
		BlockEntity _ent0 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent0 != null) {
			((RandomizableContainerBlockEntity) _ent0).removeItemNoUpdate(0);
		}
	}
}
