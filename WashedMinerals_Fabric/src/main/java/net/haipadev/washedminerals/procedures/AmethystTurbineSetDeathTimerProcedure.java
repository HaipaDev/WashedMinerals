package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.haipadev.washedminerals.init.WashedMineralsModBlocks;

public class AmethystTurbineSetDeathTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double counterSlotAmnt = 0;
		double counterSlot = 0;
		double factor22Amnt = 0;
		double factorAmnt = 0;
		double factor22Slot = 0;
		double templateAmnt = 0;
		double factor2Slot = 0;
		double factor2Amnt = 0;
		double templateSlot = 0;
		double factorSlot = 0;
		templateAmnt = 60;
		factor22Amnt = 10;
		factor2Amnt = 9;
		factorAmnt = 9;
		counterSlotAmnt = 60;
		templateSlot = 5;
		factor22Slot = 6;
		factor2Slot = 7;
		factorSlot = 8;
		counterSlot = 9;
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
			stack.setCount((int) counterSlotAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem((int) counterSlot, stack);
			}
		}
	}
}
