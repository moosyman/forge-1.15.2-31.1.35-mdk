package com.moosymantheboss.newmod.init;

import java.util.function.Supplier;

import com.moosymantheboss.newmod.NewMod;
import com.moosymantheboss.newmod.NewMod.NewItemGroup;
import com.moosymantheboss.newmod.objects.items.SpecialItem;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = NewMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(NewMod.MOD_ID)
public class Iteminit {
	@ObjectHolder(NewMod.MOD_ID + "example_item")
	public static final Item example_item = null;
	public static final Item gem_fissure = null;
	public static final Item  special_item = null;
	
	//Foods
	public static final Item test_item = null;
	
	//Tools
	public static final Item example_sword = null;
	public static final Item example_pickaxe = null;
	public static final Item example_axe = null;
	public static final Item example_shovel = null;
	public static final Item example_hoe = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(NewItemGroup.instance)).setRegistryName("gem_fissure"));
		event.getRegistry().register(new Item(new Item.Properties().group(NewItemGroup.instance).food(new Food.Builder().hunger(6).saturation(8.5f).setAlwaysEdible().meat().effect(new EffectInstance(Effects.ABSORPTION, 100, 1), 1.0f).build())).setRegistryName("test_item"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(NewItemGroup.instance)).setRegistryName("special_item"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 7, 2.5f, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 4, 2.5f, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.EXAMPLE, 2, 2.5f, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE, 4, 5.0f, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.EXAMPLE, 5.0f, new Item.Properties().group(NewItemGroup.instance)).setRegistryName("example_hoe"));
	}
	
	public enum ModItemTier implements IItemTier
	{
		EXAMPLE(4, 1750, 12.0f, 7.5f, 250, () -> {
			return Ingredient.fromItems(Iteminit.example_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantibility;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantibility, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantibility = enchantibility;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchantibility;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMaterial.getValue();
		}
	}
}
