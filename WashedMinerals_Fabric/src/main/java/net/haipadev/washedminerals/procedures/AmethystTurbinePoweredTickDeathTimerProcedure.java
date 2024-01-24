package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class AmethystTurbinePoweredTickDeathTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double factor22Slot = 0;
		double totalTicks = 0;
		double factor2Slot = 0;
		double amntSlot = 0;
		double templateSlot = 0;
		double factorSlot = 0;
		double amntStartedAs0Slot = 0;
		amntStartedAs0Slot = 7;
		templateSlot = 8;
		factor22Slot = 9;
		factor2Slot = 10;
		factorSlot = 11;
		amntSlot = 12;
		if (new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (BlockPos.containing(x, y, z)), (int) amntStartedAs0Slot) == 0) {
			BlockEntity _ent1 = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent1 != null) {
				((RandomizableContainerBlockEntity) _ent1).removeItem((int) amntSlot, 1);
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
		}.getAmount(world, (BlockPos.containing(x, y, z)), (int) amntSlot) == 0) {
			if (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factorSlot) == 0) {
				if (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor2Slot) == 1) {
					if (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor22Slot) == 1) {
						BlockEntity _ent6 = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent6 != null) {
							((RandomizableContainerBlockEntity) _ent6).removeItemNoUpdate((int) factor2Slot);
						}
					} else if (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor22Slot) > 1) {
						BlockEntity _ent8 = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent8 != null) {
							((RandomizableContainerBlockEntity) _ent8).removeItem((int) factor22Slot, 1);
						}
					}
				} else if (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor2Slot) == 0) {
					BlockEntity _ent10 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent10 != null) {
						((RandomizableContainerBlockEntity) _ent10).removeItem((int) factor22Slot, 1);
					}
				} else if (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor2Slot) > 1 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor22Slot) > 1) {
					BlockEntity _ent13 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent13 != null) {
						((RandomizableContainerBlockEntity) _ent13).removeItemNoUpdate((int) factorSlot);
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						ItemStack stack = new ItemStack(Items.COAL);
						stack.setCount(9);
						if (_ent != null) {
							((RandomizableContainerBlockEntity) _ent).setItem((int) factorSlot, stack);
						}
					}
					BlockEntity _ent15 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent15 != null) {
						((RandomizableContainerBlockEntity) _ent15).removeItem((int) factor2Slot, 1);
					}
				}
			} else if (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factorSlot) > 0) {
				BlockEntity _ent17 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent17 != null) {
					((RandomizableContainerBlockEntity) _ent17).removeItem((int) factorSlot, 1);
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
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor22Slot) != 0) {
				BlockEntity _ent19 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent19 != null) {
					((RandomizableContainerBlockEntity) _ent19).removeItemNoUpdate((int) amntSlot);
				}
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					ItemStack stack = new ItemStack(Blocks.REDSTONE_TORCH);
					stack.setCount((int) (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), (int) templateSlot)));
					if (_ent != null) {
						((RandomizableContainerBlockEntity) _ent).setItem((int) amntSlot, stack);
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
				}.getAmount(world, (BlockPos.containing(x, y, z)), (int) amntStartedAs0Slot) != 0) {
					BlockEntity _ent23 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent23 != null) {
						((RandomizableContainerBlockEntity) _ent23).removeItem((int) amntSlot, 1);
					}
					BlockEntity _ent24 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent24 != null) {
						((RandomizableContainerBlockEntity) _ent24).removeItemNoUpdate((int) amntStartedAs0Slot);
					}
				}
			}
		}
	}
}
