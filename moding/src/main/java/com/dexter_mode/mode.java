package com.dexter_mode;

import javax.swing.text.html.parser.Entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.dexter_mode.item._foodItem;
import com.dexter_mode.item._item;
import com.dexter_mode.item.testItem;

import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("dm")
public class mode {
	
	public static mode instance;
	public static final String modid="dm";
	public static final Logger logger = (Logger) LogManager.getLogger(modid);
	
	public mode() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent e) {
		logger.info("commonSetup registered");
	}
	
	private void clientSetup(final FMLClientSetupEvent e) {
		logger.info("clientSetup registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {	
			event.getRegistry().registerAll(
					
					//FOOD-ITEM
					_foodItem.itemFood =  (ItemFood) new ItemFood(3, 0, false, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("taco"),
					_foodItem.itemFood =  (ItemFood) new ItemFood(3, 0, true, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("tomato"),
					_foodItem.itemFood =  (ItemFood) new ItemFood(3, 0, false, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("masala_dosa"),
					_foodItem.itemFood =  (ItemFood) new ItemFood(0, 2, true, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("roti"),
					_foodItem.itemFood =  (ItemFood) new ItemFood(0, 2, false, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("vadapav")
					);
		}
	}
	


	public static ResourceLocation location(String name) {
		return new ResourceLocation(modid,name);
	}
}