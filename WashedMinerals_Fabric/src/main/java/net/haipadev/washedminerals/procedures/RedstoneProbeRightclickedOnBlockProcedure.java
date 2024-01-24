package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class RedstoneProbeRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double counterSlot = 0;
		double total_ticks = 0;
		double factor22Slot = 0;
		double factor2Slot = 0;
		double templateSlot = 0;
		double factorSlot = 0;
		double process_ticks = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BuiltInRegistries.BLOCK.get(new ResourceLocation("washed_minerals:amethyst_turbine_powered"))) {
			if (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), 6) >= 1) {
				if (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), 5) >= 1 || new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), 4) >= 1) {
					process_ticks = new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 3) * new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 4) + new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 5);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.process_life_left").getString() + "" + process_ticks / 20 + "s")), true);
				} else {
					templateSlot = 8;
					factor22Slot = 9;
					factor2Slot = 10;
					factorSlot = 11;
					counterSlot = 12;
					total_ticks = new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) templateSlot) * new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor22Slot) * new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor2Slot) + new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) templateSlot) * new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factorSlot) + new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) counterSlot);
					if (total_ticks > 0) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.redstone_block_life_left").getString() + "" + total_ticks / 20 + "s")), true);
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.redstone_block_life_left").getString() + "\u221E")), true);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.invalid_processing_setup").getString())), true);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BuiltInRegistries.BLOCK.get(new ResourceLocation("washed_minerals:amethyst_turbine"))) {
			if (!(world.isEmptyBlock(BlockPos.containing(x - (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))).getStepX(), y - (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))).getStepY(), z - (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))).getStepZ())))) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.back_requires_air").getString())), true);
			} else if (world.getBlockState(BlockPos.containing(x + (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))).getStepX(), y + (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))).getStepY(), z + (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))).getStepZ())).canOcclude()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.front_requires_air").getString())), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.requires_redstone_block").getString())), true);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BuiltInRegistries.BLOCK.get(new ResourceLocation("washed_minerals:dead_redstone_block"))) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.dead_redstone_block_lore").getString())), true);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BuiltInRegistries.BLOCK.get(new ResourceLocation("washed_minerals:copper_dynamo"))) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("translation.washed_minerals.copper_dynamo_lore").getString())), true);
		}
	}
}
