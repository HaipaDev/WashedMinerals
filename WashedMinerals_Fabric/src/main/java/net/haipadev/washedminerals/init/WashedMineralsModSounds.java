
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.washedminerals.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class WashedMineralsModSounds {
	public static SoundEvent FAN = SoundEvent.createVariableRangeEvent(new ResourceLocation("washed_minerals", "fan"));

	public static void load() {
		Registry.register(BuiltInRegistries.SOUND_EVENT, new ResourceLocation("washed_minerals", "fan"), FAN);
	}
}
