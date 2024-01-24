package net.haipadev.washedminerals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.haipadev.washedminerals.init.WashedMineralsModBlocks;

import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class WashingFanPoweredUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity processedItem = null;
		BlockState block_powering = Blocks.AIR.defaultBlockState();
		double bX = 0;
		double bY = 0;
		double bZ = 0;
		double i = 0;
		double pX = 0;
		double pY = 0;
		double pZ = 0;
		double amntPerProcess = 0;
		double chanceForDeath = 0;
		double processedType = 0;
		double chanceForSuccess1 = 0;
		double chanceForSuccess2 = 0;
		double amntPerProcess1 = 0;
		double amntPerProcess2 = 0;
		double chanceForSuccess = 0;
		double itemBlockRelX = 0;
		double itemBlockRelY = 0;
		double itemBlockRelZ = 0;
		double dropRatePerOne = 0;
		double dropRatePerOne1 = 0;
		double dropRatePerOne2 = 0;
		double chanceForSuccess3 = 0;
		double amntPerProcess3 = 0;
		double dropRatePerOne3 = 0;
		boolean strong_powered = false;
		boolean found_powersource = false;
		boolean checkChancePerSingleItem = false;
		boolean isValidProcessingSetup = false;
		boolean isWashing = false;
		boolean isHaunting = false;
		boolean wasSuccess = false;
		ItemStack dropItem1 = ItemStack.EMPTY;
		ItemStack dropItem2 = ItemStack.EMPTY;
		ItemStack dropItem3 = ItemStack.EMPTY;
		ItemStack dropItem = ItemStack.EMPTY;
		WashingFanPoweredLoopSoundProcedure.execute(world, x, y, z);
		chanceForDeath = 80;
		amntPerProcess = 1;
		dropRatePerOne = 1;
		chanceForSuccess = 100;
		checkChancePerSingleItem = true;
		dropItem1 = new ItemStack(Items.IRON_NUGGET);
		chanceForSuccess1 = 65;
		amntPerProcess1 = 8;
		dropRatePerOne1 = 1;
		dropItem2 = new ItemStack(Items.GOLD_NUGGET);
		chanceForSuccess2 = 50;
		amntPerProcess2 = 4;
		dropRatePerOne2 = 1;
		dropItem3 = new ItemStack(Items.ECHO_SHARD);
		chanceForSuccess3 = 1;
		amntPerProcess3 = 1;
		dropRatePerOne3 = 1;
		if (!world.isClientSide()) {
			bX = x + 1;
			bY = y + 0;
			bZ = z + 0;
			i = 0;
			for (int index0 = 0; index0 < 6; index0++) {
				if ((world.getBlockState(BlockPos.containing(bX, bY, bZ))).getBlock() == Blocks.REDSTONE_BLOCK) {
					block_powering = (world.getBlockState(BlockPos.containing(bX, bY, bZ)));
					{
						int _value = 15;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("power") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					strong_powered = true;
					found_powersource = true;
					pX = bX;
					pY = bY;
					pZ = bZ;
					break;
				}
				i = i + 1;
				bX = x + 0;
				bY = y + 0;
				bZ = z + 0;
				if (i == 1) {
					bX = x - 1;
				}
				if (i == 2) {
					bY = y + 1;
				}
				if (i == 3) {
					bY = y - 1;
				}
				if (i == 4) {
					bZ = z + 1;
				}
				if (i == 5) {
					bZ = z - 1;
				}
			}
		}
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
			WashingFanPoweredTickDeathTimerProcedure.execute(world, x, y, z);
		} else {
			if (Mth.nextInt(RandomSource.create(), 1, 100) <= chanceForDeath) {
				world.destroyBlock(BlockPos.containing(pX, pY, pZ), false);
				world.levelEvent(2001, BlockPos.containing(pX, pY, pZ), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
				world.setBlock(BlockPos.containing(pX, pY, pZ), WashedMineralsModBlocks.DEAD_REDSTONE_BLOCK.defaultBlockState(), 3);
			}
			WashingFanPoweredRestartDeathTimerProcedure.execute(world, x, y, z);
		}
		if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_BLOCK) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_BLOCK)
				&& !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.REDSTONE_BLOCK) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.REDSTONE_BLOCK)
				&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_BLOCK) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_BLOCK)
				|| !(world.isEmptyBlock(BlockPos.containing(x - (new Object() {
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
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = WashedMineralsModBlocks.WASHING_FAN.defaultBlockState();
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
		if ((world.getBlockState(BlockPos.containing(x + (new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getStepZ()))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x + (new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getStepZ()))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(BlockPos.containing(x + (new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getStepZ()))).getBlock() == Blocks.WATER || ((world.getBlockState(BlockPos.containing(x + (new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getStepZ()))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp61 && (world.getBlockState(BlockPos.containing(x + (new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getStepZ()))).getValue(_getbp61)) == true) {
			isValidProcessingSetup = true;
			isWashing = true;
		} else if ((world.getBlockState(BlockPos.containing(x + (new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getStepZ()))).getBlock() == Blocks.SOUL_FIRE) {
			isValidProcessingSetup = true;
			isHaunting = true;
		}
		if (isWashing == true) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE, (x + (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepX() + 1 * 0.5), (y + (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepY() + 1 * 0.5), (z + (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepZ() + 1 * 0.5), 5, 0.2, 0.2, 0.2, 0.2);
		} else if (isHaunting == true) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepX() + 1 * 0.5), (y + (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepY() + 1 * 0.5), (z + (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepZ() + 1 * 0.5), 5, ((new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepX() * 0.8), 0.2, ((new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepZ() * 0.8), 0.01);
		}
		if (isValidProcessingSetup == true) {
			{
				final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ItemEntity) {
						itemBlockRelX = entityiterator.getX() - x;
						itemBlockRelY = entityiterator.getY() - y;
						itemBlockRelZ = entityiterator.getZ() - z;
						if ((new Object() {
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
						}.getDirection(BlockPos.containing(x, y, z))) == Direction.NORTH && itemBlockRelZ <= 0 && itemBlockRelX >= -0.1 && itemBlockRelX <= 1.1 && itemBlockRelY < 1 && itemBlockRelY >= -0.3 || (new Object() {
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
						}.getDirection(BlockPos.containing(x, y, z))) == Direction.SOUTH && itemBlockRelZ >= 0 && itemBlockRelX >= -0.1 && itemBlockRelX <= 1.1 && itemBlockRelY < 1 && itemBlockRelY >= -0.3 || (new Object() {
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
						}.getDirection(BlockPos.containing(x, y, z))) == Direction.EAST && itemBlockRelX >= 0 && itemBlockRelZ >= -0.1 && itemBlockRelZ <= 1.1 && itemBlockRelY < 1 && itemBlockRelY >= -0.3 || (new Object() {
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
						}.getDirection(BlockPos.containing(x, y, z))) == Direction.WEST && itemBlockRelX <= 0 && itemBlockRelZ >= -0.1 && itemBlockRelZ <= 1.1 && itemBlockRelY < 1 && itemBlockRelY >= -0.3 || (new Object() {
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
						}.getDirection(BlockPos.containing(x, y, z))) == Direction.UP && itemBlockRelY >= 0 && itemBlockRelX >= -0.1 && itemBlockRelX <= 1.1 && itemBlockRelZ >= -0.1 && itemBlockRelZ <= 1.1 || (new Object() {
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
						}.getDirection(BlockPos.containing(x, y, z))) == Direction.DOWN && itemBlockRelY <= 0 && itemBlockRelX >= -0.1 && itemBlockRelX <= 1.1 && itemBlockRelZ >= -0.1 && itemBlockRelZ <= 1.1) {
							if (isWashing == true) {
								if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.GRAVEL.asItem()) {
									processedItem = entityiterator;
									processedType = 1;
									dropItem = dropItem1;
									chanceForSuccess = chanceForSuccess1;
									amntPerProcess = amntPerProcess1;
									dropRatePerOne = dropRatePerOne1;
								} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.RED_SAND.asItem()) {
									processedItem = entityiterator;
									processedType = 2;
									dropItem = dropItem2;
									chanceForSuccess = chanceForSuccess2;
									amntPerProcess = amntPerProcess2;
									dropRatePerOne = dropRatePerOne2;
								} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == WashedMineralsModBlocks.DEAD_REDSTONE_BLOCK.asItem()) {
									processedItem = entityiterator;
									processedType = 3;
									dropItem = dropItem3;
									chanceForSuccess = chanceForSuccess3;
									amntPerProcess = amntPerProcess3;
									dropRatePerOne = dropRatePerOne3;
								} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.SAND.asItem()) {
									processedItem = entityiterator;
									processedType = 4;
									dropItem = new ItemStack(Items.CLAY_BALL);
									chanceForSuccess = chanceForSuccess2;
									amntPerProcess = amntPerProcess2;
									dropRatePerOne = amntPerProcess2;
								}
							}
							if (isHaunting == true) {
								if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.COBBLESTONE.asItem()) {
									processedItem = entityiterator;
									processedType = 5;
									dropItem = new ItemStack(Blocks.NETHERRACK);
									chanceForSuccess = chanceForSuccess1;
									amntPerProcess = amntPerProcess1;
									dropRatePerOne = dropRatePerOne1;
								} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.SAND.asItem()) {
									processedItem = entityiterator;
									processedType = 6;
									dropItem = new ItemStack(Blocks.SOUL_SAND);
									chanceForSuccess = chanceForSuccess1;
									amntPerProcess = amntPerProcess1;
									dropRatePerOne = dropRatePerOne1;
								} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.DIRT.asItem()) {
									processedItem = entityiterator;
									processedType = 7;
									dropItem = new ItemStack(Blocks.SOUL_SOIL);
									chanceForSuccess = chanceForSuccess1;
									amntPerProcess = amntPerProcess1;
									dropRatePerOne = dropRatePerOne1;
								}
							}
						}
					}
				}
			}
			if (!(processedItem == null)) {
				if ((processedItem instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount() > 0) {
					if (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 3) > 0) {
						WashingFanPoweredTickProcessTimerProcedure.execute(world, x, y, z);
						if (isWashing == true) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CLOUD, (processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), 1, 0.01, 0.01, 0.01, 0.01);
						} else if (isHaunting == true) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SOUL, (processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), 1, 0.01, 0.01, 0.01, 0.01);
						}
					} else {
						WashingFanPoweredRestartProcessTimerProcedure.execute(world, x, y, z);
					}
				}
			}
			if (!(processedItem == null)) {
				if ((processedItem instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount() > 0) {
					if (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 3) <= 0) {
						if (checkChancePerSingleItem == false && Mth.nextInt(RandomSource.create(), 1, 100) <= chanceForSuccess) {
							wasSuccess = true;
						} else {
							wasSuccess = false;
						}
						for (int index1 = 0; index1 < (int) Math.min((processedItem instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount(), amntPerProcess); index1++) {
							if (checkChancePerSingleItem == false && wasSuccess == true || checkChancePerSingleItem == true && Mth.nextInt(RandomSource.create(), 1, 100) <= chanceForSuccess) {
								wasSuccess = true;
								for (int index2 = 0; index2 < (int) dropRatePerOne; index2++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (processedItem.getX() + 0.5), (processedItem.getY() + 0.5), (processedItem.getZ() + 0.5), dropItem);
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
							}
						}
						if (wasSuccess == true) {
							if (isWashing == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(processedItem.getX(), processedItem.getY(), processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.boat.paddle_water")),
												SoundSource.BLOCKS, (float) 0.5, 1);
									} else {
										_level.playLocalSound((processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.boat.paddle_water")), SoundSource.BLOCKS,
												(float) 0.5, 1, false);
									}
								}
							} else if (isHaunting == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(processedItem.getX(), processedItem.getY(), processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.blastfurnace.fire_crackle")),
												SoundSource.BLOCKS, (float) 0.3, 1);
									} else {
										_level.playLocalSound((processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS,
												(float) 0.3, 1, false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(processedItem.getX(), processedItem.getY(), processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS,
												(float) 0.5, 1);
									} else {
										_level.playLocalSound((processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, (float) 0.5, 1,
												false);
									}
								}
							}
						} else {
							if (isWashing == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(processedItem.getX(), processedItem.getY(), processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.gravel.step")), SoundSource.BLOCKS,
												(float) 0.5, 1);
									} else {
										_level.playLocalSound((processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.gravel.step")), SoundSource.BLOCKS, (float) 0.5, 1,
												false);
									}
								}
							} else if (isHaunting == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(processedItem.getX(), processedItem.getY(), processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.soul_soil.break")),
												SoundSource.BLOCKS, (float) 0.5, 1);
									} else {
										_level.playLocalSound((processedItem.getX()), (processedItem.getY()), (processedItem.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.soul_soil.break")), SoundSource.BLOCKS, (float) 0.5,
												1, false);
									}
								}
							}
						}
						(processedItem instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).shrink((int) Math.min((processedItem instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount(), amntPerProcess));
						WashingFanPoweredRestartProcessTimerProcedure.execute(world, x, y, z);
					}
				}
			}
		}
	}
}
