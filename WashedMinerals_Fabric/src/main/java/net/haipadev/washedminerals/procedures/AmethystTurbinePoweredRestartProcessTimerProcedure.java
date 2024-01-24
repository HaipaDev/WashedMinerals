package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class AmethystTurbinePoweredRestartProcessTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double tickAmntPerSlot = 0;
		double startSlot = 0;
		double maxSlot = 0;
		double counterSlot = 0;
		double factorAmnt = 0;
		double counterAmnt = 0;
		tickAmntPerSlot = 60;
		maxSlot = 2;
		counterAmnt = 60;
		BlockEntity _ent0 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent0 != null) {
			((RandomizableContainerBlockEntity) _ent0).removeItemNoUpdate(2);
		}
		BlockEntity _ent1 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent1 != null) {
			((RandomizableContainerBlockEntity) _ent1).removeItemNoUpdate(3);
		}
		BlockEntity _ent2 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent2 != null) {
			((RandomizableContainerBlockEntity) _ent2).removeItemNoUpdate(4);
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.YELLOW_DYE);
			stack.setCount((int) tickAmntPerSlot);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem(2, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.LIME_DYE);
			stack.setCount((int) maxSlot);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem(3, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.GREEN_DYE);
			stack.setCount((int) counterAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem(4, stack);
			}
		}
	}
}
