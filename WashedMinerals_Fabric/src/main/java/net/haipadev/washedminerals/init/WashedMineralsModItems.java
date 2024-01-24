/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.haipadev.washedminerals.item.AmethystPropellerItem;
import net.haipadev.washedminerals.WashedMineralsMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class WashedMineralsModItems {
	public static Item COPPER_DYNAMO;
	public static Item AMETHYST_PROPELLER;
	public static Item DEAD_REDSTONE_BLOCK;
	public static Item AMETHYST_TURBINE;
	public static Item AMETHYST_TURBINE_POWERED;

	public static void load() {
		COPPER_DYNAMO = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "copper_dynamo"), new BlockItem(WashedMineralsModBlocks.COPPER_DYNAMO, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> content.accept(COPPER_DYNAMO));
		AMETHYST_PROPELLER = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_propeller"), new AmethystPropellerItem());
		DEAD_REDSTONE_BLOCK = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "dead_redstone_block"), new BlockItem(WashedMineralsModBlocks.DEAD_REDSTONE_BLOCK, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> content.accept(DEAD_REDSTONE_BLOCK));
		AMETHYST_TURBINE = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_turbine"), new BlockItem(WashedMineralsModBlocks.AMETHYST_TURBINE, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> content.accept(AMETHYST_TURBINE));
		AMETHYST_TURBINE_POWERED = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_turbine_powered"), new BlockItem(WashedMineralsModBlocks.AMETHYST_TURBINE_POWERED, new Item.Properties()));
	}

	public static void clientLoad() {
	}
}
