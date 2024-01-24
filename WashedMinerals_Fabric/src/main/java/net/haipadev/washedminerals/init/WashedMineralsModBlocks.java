
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.haipadev.washedminerals.block.WashingFanPoweredBlock;
import net.haipadev.washedminerals.block.WashingFanBlock;
import net.haipadev.washedminerals.block.DeadRedstoneBlockBlock;
import net.haipadev.washedminerals.WashedMineralsMod;

public class WashedMineralsModBlocks {
	public static Block WASHING_FAN;
	public static Block WASHING_FAN_POWERED;
	public static Block DEAD_REDSTONE_BLOCK;

	public static void load() {
		WASHING_FAN = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "washing_fan"), new WashingFanBlock());
		WASHING_FAN_POWERED = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "washing_fan_powered"), new WashingFanPoweredBlock());
		DEAD_REDSTONE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "dead_redstone_block"), new DeadRedstoneBlockBlock());
	}

	public static void clientLoad() {
		WashingFanBlock.clientInit();
		WashingFanPoweredBlock.clientInit();
		DeadRedstoneBlockBlock.clientInit();
	}
}
