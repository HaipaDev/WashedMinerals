
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.haipadev.washedminerals.block.entity.AmethystTurbinePoweredBlockEntity;
import net.haipadev.washedminerals.block.entity.AmethystTurbineBlockEntity;
import net.haipadev.washedminerals.WashedMineralsMod;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class WashedMineralsModBlockEntities {
	public static BlockEntityType<?> AMETHYST_TURBINE;
	public static BlockEntityType<?> AMETHYST_TURBINE_POWERED;

	public static void load() {
		AMETHYST_TURBINE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_turbine"),
				FabricBlockEntityTypeBuilder.create(AmethystTurbineBlockEntity::new, WashedMineralsModBlocks.AMETHYST_TURBINE).build(null));
		AMETHYST_TURBINE_POWERED = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(WashedMineralsMod.MODID, "amethyst_turbine_powered"),
				FabricBlockEntityTypeBuilder.create(AmethystTurbinePoweredBlockEntity::new, WashedMineralsModBlocks.AMETHYST_TURBINE_POWERED).build(null));
	}
}
