
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.haipadev.washedminerals.block.DeadRedstoneBlockBlock;
import net.haipadev.washedminerals.block.CopperDynamoBlock;
import net.haipadev.washedminerals.block.AmethystTurbinePoweredBlock;
import net.haipadev.washedminerals.block.AmethystTurbineBlock;
import net.haipadev.washedminerals.WashedMineralsMod;

public class WashedMineralsModBlocks {
	public static Block COPPER_DYNAMO;
	public static Block DEAD_REDSTONE_BLOCK;
	public static Block AMETHYST_TURBINE;
	public static Block AMETHYST_TURBINE_POWERED;

	public static void load() {
		COPPER_DYNAMO = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "copper_dynamo"), new CopperDynamoBlock());
		DEAD_REDSTONE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "dead_redstone_block"), new DeadRedstoneBlockBlock());
		AMETHYST_TURBINE = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_turbine"), new AmethystTurbineBlock());
		AMETHYST_TURBINE_POWERED = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_turbine_powered"), new AmethystTurbinePoweredBlock());
	}

	public static void clientLoad() {
		CopperDynamoBlock.clientInit();
		DeadRedstoneBlockBlock.clientInit();
		AmethystTurbineBlock.clientInit();
		AmethystTurbinePoweredBlock.clientInit();
	}
}
