package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.haipadev.washedminerals.init.WashedMineralsModBlocks;

import java.util.Map;

public class WashingFanUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity processedItem = null;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_BLOCK || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_BLOCK
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.REDSTONE_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.REDSTONE_BLOCK
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_BLOCK || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_BLOCK) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = WashedMineralsModBlocks.WASHING_FAN_POWERED.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
