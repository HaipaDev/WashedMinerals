package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.haipadev.washedminerals.init.WashedMineralsModBlocks;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class AmethystTurbineSetDeathTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subJson = new com.google.gson.JsonObject();
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
		double total_ticks = 0;
		double start_ticks = 0;
		double amntStartedAs0Slot = 0;
		start_ticks = 6000;
		templateAmnt = 60;
		amntStartedAs0Slot = 7;
		templateSlot = 8;
		factor22Slot = 9;
		factor2Slot = 10;
		factorSlot = 11;
		counterSlot = 12;
		file = (File) new File((Minecraft.getInstance().gameDirectory + "/config/washed_minerals/"), File.separator + "config.json");
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					json = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (json.has("redstoneBlockDeathTicks")) {
						start_ticks = Math.round(json.get("redstoneBlockDeathTicks").getAsDouble());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		start_ticks = Math.floor(Math.min(42300, Math.max(start_ticks, 0)));
		if (start_ticks > templateAmnt * 10) {
			factor22Amnt = 10;
			factor2Amnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 10);
		} else {
			if (start_ticks > templateAmnt) {
				factor22Amnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 10);
				counterSlotAmnt = (start_ticks - templateAmnt * factor22Amnt * factor2Amnt) - templateAmnt * factorAmnt;
				factor22Amnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 10) + Math.abs(Math.floor(counterSlotAmnt / templateAmnt));
				factor2Amnt = 1;
			}
		}
		if (start_ticks <= 39000) {
			if (start_ticks > templateAmnt * 10) {
				factorAmnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 10);
				counterSlotAmnt = (start_ticks - templateAmnt * factor22Amnt * factor2Amnt) - templateAmnt * factorAmnt;
				factorAmnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 10) - Math.abs(Math.floor(counterSlotAmnt / templateAmnt));
			} else {
				factorAmnt = 0;
			}
		} else {
			factorAmnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 64);
			counterSlotAmnt = (start_ticks - templateAmnt * factor22Amnt * factor2Amnt) - templateAmnt * factorAmnt;
			factorAmnt = Math.floor(Math.floor(start_ticks / templateAmnt) / 10) - Math.abs(Math.floor(counterSlotAmnt / templateAmnt));
		}
		if (factor2Amnt > 64) {
			factor2Amnt = 64;
			if (factorAmnt < 9) {
				factorAmnt = 9;
			}
		}
		counterSlotAmnt = (start_ticks - templateAmnt * factor22Amnt * factor2Amnt) - templateAmnt * factorAmnt;
		if (start_ticks < templateAmnt * 10 && counterSlotAmnt < 0) {
			counterSlotAmnt = templateAmnt - Math.abs(counterSlotAmnt);
			factor22Amnt = factor22Amnt - 1;
		}
		factor22Amnt = Math.floor(factor22Amnt);
		factor2Amnt = Math.floor(factor2Amnt);
		factorAmnt = Math.floor(factorAmnt);
		counterSlotAmnt = Math.floor(counterSlotAmnt);
		if (start_ticks > 0) {
			if (counterSlotAmnt <= 0) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					ItemStack stack = new ItemStack(Blocks.COBBLESTONE);
					stack.setCount(1);
					if (_ent != null) {
						((RandomizableContainerBlockEntity) _ent).setItem((int) amntStartedAs0Slot, stack);
					}
				}
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
				stack.setCount((int) counterSlotAmnt);
				if (_ent != null) {
					((RandomizableContainerBlockEntity) _ent).setItem((int) counterSlot, stack);
				}
			}
		}
	}
}
