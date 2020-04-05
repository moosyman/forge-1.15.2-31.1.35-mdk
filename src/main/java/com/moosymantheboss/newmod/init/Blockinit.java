package com.moosymantheboss.newmod.init;

import com.moosymantheboss.newmod.NewMod;
import com.moosymantheboss.newmod.NewMod.NewItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(NewMod.MOD_ID)
@Mod.EventBusSubscriber(modid = NewMod.MOD_ID, bus = Bus.MOD)
public class Blockinit 
{
	public static final Block example_block = null;
	public static final Block gem_vein = null;
	public static final Block jaden_ore = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(30.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2)).setRegistryName("example_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(20.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).lightValue(6)).setRegistryName("gem_vein"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(20.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2)).setRegistryName("jaden_ore"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(example_block, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_block"));
		event.getRegistry().register(new BlockItem(gem_vein, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("gem_vein"));
		event.getRegistry().register(new BlockItem(jaden_ore, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("jaden_ore"));
	}
}
