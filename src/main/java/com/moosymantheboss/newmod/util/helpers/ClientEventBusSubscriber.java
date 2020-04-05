package com.moosymantheboss.newmod.util.helpers;

import com.moosymantheboss.newmod.NewMod;
import com.moosymantheboss.newmod.init.BlockInitNew;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = NewMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)

public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInitNew.EXAMPLE_SAPLING.get(), RenderType.getCutout());

	}

}
