
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.haipadev.washedminerals.block.entity.WashingFanPoweredBlockEntity;
import net.haipadev.washedminerals.block.entity.WashingFanBlockEntity;
import net.haipadev.washedminerals.WashedMineralsMod;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class WashedMineralsModBlockEntities {
	public static BlockEntityType<?> WASHING_FAN;
	public static BlockEntityType<?> WASHING_FAN_POWERED;

	public static void load() {
		WASHING_FAN = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(WashedMineralsMod.MODID, "washing_fan"),
				FabricBlockEntityTypeBuilder.create(WashingFanBlockEntity::new, WashedMineralsModBlocks.WASHING_FAN).build(null));
		WASHING_FAN_POWERED = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(WashedMineralsMod.MODID, "washing_fan_powered"),
				FabricBlockEntityTypeBuilder.create(WashingFanPoweredBlockEntity::new, WashedMineralsModBlocks.WASHING_FAN_POWERED).build(null));
	}
}
