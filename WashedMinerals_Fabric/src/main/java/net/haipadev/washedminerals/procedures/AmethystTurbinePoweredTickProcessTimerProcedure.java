package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class AmethystTurbinePoweredTickProcessTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockEntity _ent0 = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (_ent0 != null) {
			((RandomizableContainerBlockEntity) _ent0).removeItem(4, 1);
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
		}.getAmount(world, (BlockPos.containing(x, y, z)), 4) == 0) {
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
				BlockEntity _ent3 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent3 != null) {
					((RandomizableContainerBlockEntity) _ent3).removeItem(3, 1);
				}
				BlockEntity _ent4 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent4 != null) {
					((RandomizableContainerBlockEntity) _ent4).removeItemNoUpdate(4);
				}
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					ItemStack stack = new ItemStack(Items.GREEN_DYE);
					stack.setCount((int) (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 2)));
					if (_ent != null) {
						((RandomizableContainerBlockEntity) _ent).setItem(4, stack);
					}
				}
			}
		}
	}
}
