package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.haipadev.washedminerals.init.WashedMineralsModBlocks;

import java.util.concurrent.atomic.AtomicInteger;

public class WashingFanPoweredRestartDeathTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double tickAmntPerSlot = 0;
		double startSlot = 0;
		double maxSlot = 0;
		double i = 0;
		double templateSlot = 0;
		double factorSlot = 0;
		double templateAmnt = 0;
		double startSlotAmnt = 0;
		double factorAmnt = 0;
		double factor2Slot = 0;
		double factor2Amnt = 0;
		double factor22Slot = 0;
		double factor22Amnt = 0;
		double totalTicks = 0;
		templateAmnt = 60;
		factor22Amnt = 10;
		factor2Amnt = 9;
		factorAmnt = 9;
		startSlotAmnt = 60;
		templateSlot = 5;
		factor22Slot = 6;
		factor2Slot = 7;
		factorSlot = 8;
		startSlot = 9;
		BlockEntity _ent0 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent0 != null) {
			((RandomizableContainerBlockEntity) _ent0).removeItemNoUpdate((int) templateSlot);
		}
		BlockEntity _ent1 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent1 != null) {
			((RandomizableContainerBlockEntity) _ent1).removeItemNoUpdate((int) factor22Slot);
		}
		BlockEntity _ent2 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent2 != null) {
			((RandomizableContainerBlockEntity) _ent2).removeItemNoUpdate((int) factor2Slot);
		}
		BlockEntity _ent3 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent3 != null) {
			((RandomizableContainerBlockEntity) _ent3).removeItemNoUpdate((int) factorSlot);
		}
		BlockEntity _ent4 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent4 != null) {
			((RandomizableContainerBlockEntity) _ent4).removeItemNoUpdate((int) startSlot);
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.PAPER);
			stack.setCount((int) templateAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem((int) templateSlot, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(WashedMineralsModBlocks.DEAD_REDSTONE_BLOCK);
			stack.setCount((int) factor22Amnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem((int) factor22Slot, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Blocks.COAL_BLOCK);
			stack.setCount((int) factor2Amnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem((int) factor2Slot, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.COAL);
			stack.setCount((int) factorAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem((int) factorSlot, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Blocks.REDSTONE_TORCH);
			stack.setCount((int) startSlotAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem((int) startSlot, stack);
			}
		}
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
		}.getAmount(world, (BlockPos.containing(x, y, z)), (int) factor2Slot) + new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (BlockPos.containing(x, y, z)), (int) startSlot);
	}
}
