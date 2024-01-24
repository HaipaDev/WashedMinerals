package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.concurrent.atomic.AtomicReference;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class AmethystTurbinePoweredSetProcessTimerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		double tickAmntPerSlot = 0;
		double c = 0;
		double start_ticks = 0;
		double factorAmnt = 0;
		double i = 0;
		double counterAmnt = 0;
		String categoryToCheck = "";
		com.google.gson.JsonObject subJson = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subJsonCategory = new com.google.gson.JsonObject();
		start_ticks = 180;
		tickAmntPerSlot = 60;
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
					subJson = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					categoryToCheck = "washing";
					c = 1;
					i = 1;
					for (int index0 = 0; index0 < 3; index0++) {
						if (c == 2) {
							categoryToCheck = "haunting";
						} else if (c == 3) {
							categoryToCheck = "blasting";
						}
						if (subJson.has(categoryToCheck)) {
							subJsonCategory = subJson.get(categoryToCheck).getAsJsonObject();
							for (int index1 = 0; index1 < (int) subJsonCategory.size(); index1++) {
								if (subJsonCategory.has(("item" + Math.round(i)))) {
									subJson = subJsonCategory.get(("item" + Math.round(i))).getAsJsonObject();
									if (subJson.has("item")) {
										if (!((new Object() {
											public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
												AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
												BlockEntity _ent = world.getBlockEntity(pos);
												if (_ent != null)
													stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
												return stack.get();
											}
										}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == Blocks.AIR.asItem()) && !(BuiltInRegistries.ITEM.get(new ResourceLocation(subJson.get("item").getAsString())) == Blocks.AIR.asItem())
												&& (new Object() {
													public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
														AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
														BlockEntity _ent = world.getBlockEntity(pos);
														if (_ent != null)
															stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
														return stack.get();
													}
												}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == BuiltInRegistries.ITEM.get(new ResourceLocation(subJson.get("item").getAsString()))) {
											if (subJson.has("processingTimeTicks")) {
												start_ticks = Math.round(subJson.get("processingTimeTicks").getAsDouble());
											}
										}
									}
								}
								i = i + 1;
							}
							i = 1;
						}
						c = c + 1;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		start_ticks = Math.round(Math.min(3900, Math.max(Math.round(start_ticks), 0)));
		if (start_ticks <= tickAmntPerSlot) {
			counterAmnt = start_ticks;
			factorAmnt = 0;
		} else {
			factorAmnt = Math.floor(start_ticks / tickAmntPerSlot);
			counterAmnt = start_ticks - tickAmntPerSlot * factorAmnt;
			factorAmnt = Math.floor(start_ticks / tickAmntPerSlot) + Math.abs(Math.floor(counterAmnt / tickAmntPerSlot));
		}
		counterAmnt = start_ticks - tickAmntPerSlot * factorAmnt;
		if (factorAmnt > 64) {
			factorAmnt = 64;
			counterAmnt = tickAmntPerSlot;
		}
		if (counterAmnt == 0 && factorAmnt > 0) {
			counterAmnt = tickAmntPerSlot;
			factorAmnt = factorAmnt - 1;
		}
		counterAmnt = Math.round(counterAmnt);
		factorAmnt = Math.round(factorAmnt);
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.YELLOW_DYE);
			stack.setCount((int) tickAmntPerSlot);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem(3, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.LIME_DYE);
			stack.setCount((int) factorAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem(4, stack);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			ItemStack stack = new ItemStack(Items.GREEN_DYE);
			stack.setCount((int) counterAmnt);
			if (_ent != null) {
				((RandomizableContainerBlockEntity) _ent).setItem(5, stack);
			}
		}
	}
}
