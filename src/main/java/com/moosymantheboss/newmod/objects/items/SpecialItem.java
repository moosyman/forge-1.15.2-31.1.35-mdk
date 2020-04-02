package com.moosymantheboss.newmod.objects.items;

import java.util.List;

import com.moosymantheboss.newmod.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SpecialItem extends Item
{
	public SpecialItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if(KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("Test Information"));
		}
		else
		{
			tooltip.add(new StringTextComponent("Hold shift for more information."));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 5));
		return super.onItemRightClick(world, playerIn, handIn);
	}
}
