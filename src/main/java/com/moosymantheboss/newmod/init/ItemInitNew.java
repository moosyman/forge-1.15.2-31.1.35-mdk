package com.moosymantheboss.newmod.init;

import com.moosymantheboss.newmod.NewMod;
import com.moosymantheboss.newmod.NewMod.NewItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, NewMod.MOD_ID);
	
	public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new Item(new Item.Properties().group(NewItemGroup.instance)));
}
