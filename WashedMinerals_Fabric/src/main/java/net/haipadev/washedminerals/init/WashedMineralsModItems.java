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
	public static Item WASHING_FAN;
	public static Item AMETHYST_PROPELLER;
	public static Item WASHING_FAN_POWERED;
	public static Item DEAD_REDSTONE_BLOCK;

	public static void load() {
		WASHING_FAN = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "washing_fan"), new BlockItem(WashedMineralsModBlocks.WASHING_FAN, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> content.accept(WASHING_FAN));
		AMETHYST_PROPELLER = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_propeller"), new AmethystPropellerItem());
		WASHING_FAN_POWERED = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "washing_fan_powered"), new BlockItem(WashedMineralsModBlocks.WASHING_FAN_POWERED, new Item.Properties()));
		DEAD_REDSTONE_BLOCK = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(WashedMineralsMod.MODID, "dead_redstone_block"), new BlockItem(WashedMineralsModBlocks.DEAD_REDSTONE_BLOCK, new Item.Properties()));
	}

	public static void clientLoad() {
	}
}
