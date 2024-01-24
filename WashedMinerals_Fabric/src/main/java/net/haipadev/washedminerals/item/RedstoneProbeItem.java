
package net.haipadev.washedminerals.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.InteractionResult;

import net.haipadev.washedminerals.procedures.RedstoneProbeRightclickedOnBlockProcedure;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class RedstoneProbeItem extends Item {
	public RedstoneProbeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> content.accept(this));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		RedstoneProbeRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return retval;
	}
}
