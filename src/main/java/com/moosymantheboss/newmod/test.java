package com.moosymantheboss.newmod;

import com.moosymantheboss.newmod.init.Iteminit;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class test {
	public test() {
		ResourceLocation testTagItem = new ResourceLocation(NewMod.MOD_ID, "testtagitem");
		Item item = Iteminit.test_item;
		boolean isInTag = ItemTags.getCollection().get(testTagItem).contains(item);
		if(isInTag) {
			item.setDamage(item.getDefaultInstance(), 15);
		}
	}
}
