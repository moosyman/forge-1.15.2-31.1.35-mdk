package com.moosymantheboss.newmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moosymantheboss.newmod.init.BiomeInit;
import com.moosymantheboss.newmod.init.BlockInitNew;
import com.moosymantheboss.newmod.init.ItemInitNew;
import com.moosymantheboss.newmod.init.Iteminit;
import com.moosymantheboss.newmod.world.gen.TutorialOreGen;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("newmod")
@Mod.EventBusSubscriber(modid = NewMod.MOD_ID, bus = Bus.MOD)
public class NewMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "newmod";
    public static NewMod instance;

    public NewMod() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        ItemInitNew.ITEMS.register(modEventBus);
        BlockInitNew.BLOCKS.register(modEventBus);
        
        BiomeInit.BIOMES.register(modEventBus);
        
        instance = this;
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(NewItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});   	
    	LOGGER.debug("Registered BlockItems!");
    }
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event)
    {
    	BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {

    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	TutorialOreGen.generateOre();
    }
    
    public static class NewItemGroup extends ItemGroup
    {
    	public static final NewItemGroup instance = new NewItemGroup(ItemGroup.GROUPS.length, "newtab");
    	private NewItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(Iteminit.example_item);
    	}
    }
}
