package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

import net.haipadev.washedminerals.init.WashedMineralsModSounds;

import java.util.concurrent.atomic.AtomicInteger;

public class WashingFanPoweredLoopSoundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double soundLengthInTicks = 0;
		soundLengthInTicks = 31;
		if (new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (BlockPos.containing(x, y, z)), 1) <= 0) {
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				ItemStack stack = new ItemStack(Items.MUSIC_DISC_11);
				stack.setCount((int) soundLengthInTicks);
				if (_ent != null) {
					((RandomizableContainerBlockEntity) _ent).setItem(1, stack);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), WashedMineralsModSounds.WASHING_FAN, SoundSource.BLOCKS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, WashedMineralsModSounds.WASHING_FAN, SoundSource.BLOCKS, (float) 0.5, 1, false);
				}
			}
		} else {
			BlockEntity _ent3 = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent3 != null) {
				((RandomizableContainerBlockEntity) _ent3).removeItem(1, 1);
			}
		}
	}
}
