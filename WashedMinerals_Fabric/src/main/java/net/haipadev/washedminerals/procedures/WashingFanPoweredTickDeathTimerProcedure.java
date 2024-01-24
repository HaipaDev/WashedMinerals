package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class WashingFanPoweredTickDeathTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double currentSlot = 0;
		double lowerSlotLimit = 0;
		double totalTicks = 0;
		double slotChecked = 0;
		double factorSlot = 0;
		double templateSlot = 0;
		double amntSlot = 0;
		double factor2Slot = 0;
		double factor22Slot = 0;
		templateSlot = 5;
		factor22Slot = 6;
		factor2Slot = 7;
		factorSlot = 8;
		amntSlot = 9;
		totalTicks = new Object() {
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
		}.getAmount(world, (BlockPos.containing(x, y, z)), (int) amntSlot);
		BlockEntity _ent6 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent6 != null) {
			((RandomizableContainerBlockEntity) _ent6).removeItem((int) amntSlot, 1);
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
						BlockEntity _ent11 = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent11 != null) {
							((RandomizableContainerBlockEntity) _ent11).removeItemNoUpdate((int) factor2Slot);
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
						BlockEntity _ent13 = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent13 != null) {
							((RandomizableContainerBlockEntity) _ent13).removeItem((int) factor22Slot, 1);
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
					BlockEntity _ent15 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent15 != null) {
						((RandomizableContainerBlockEntity) _ent15).removeItem((int) factor22Slot, 1);
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
					BlockEntity _ent18 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent18 != null) {
						((RandomizableContainerBlockEntity) _ent18).removeItemNoUpdate((int) factorSlot);
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						ItemStack stack = new ItemStack(Items.COAL);
						stack.setCount(9);
						if (_ent != null) {
							((RandomizableContainerBlockEntity) _ent).setItem((int) factorSlot, stack);
						}
					}
					BlockEntity _ent20 = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent20 != null) {
						((RandomizableContainerBlockEntity) _ent20).removeItem((int) factor2Slot, 1);
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
				BlockEntity _ent22 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent22 != null) {
					((RandomizableContainerBlockEntity) _ent22).removeItem((int) factorSlot, 1);
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
				BlockEntity _ent24 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent24 != null) {
					((RandomizableContainerBlockEntity) _ent24).removeItemNoUpdate((int) amntSlot);
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
			}
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("f22: " + (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor22Slot)) + " | f2: " + (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor2Slot)) + " | f: " + (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factorSlot)) + " | a: " + (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger count = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
					if (_ent != null)
						count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
					return count.get();
				}
			}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factorSlot)) + " | total: " + totalTicks + " (" + totalTicks / 20 + "s)")), false);
	}
}
