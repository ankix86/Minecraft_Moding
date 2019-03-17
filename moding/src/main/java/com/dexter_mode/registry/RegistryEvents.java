package com.dexter_mode.registry;

import com.dexter_mode.mode;
import com.dexter_mode.block.BlockGreenChillie;
import com.dexter_mode.block.BlockPavbhaji;
import com.dexter_mode.block.BlockRedChillie;
import com.dexter_mode.block.Blocklist;
import com.dexter_mode.item.ItemList;
import com.dexter_mode.item.food.ItemGreenChillie;
import com.dexter_mode.item.food.ItemRedChillie;
import com.dexter_mode.itemGroup.DitemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {	
		event.getRegistry().registerAll(
				
//				_foodItem.itemFood =  (ItemFood) new ItemFood(3, 0, false, new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("taco"),
//				_foodItem.itemFood =  (ItemFood) new ItemFood(3, 0, true, new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("tomato"),
//				_foodItem.itemFood =  (ItemFood) new ItemFood(3, 0, false, new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("masala_dosa"),
//				_foodItem.itemFood =  (ItemFood) new ItemFood(0, 2, true, new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("roti"),
//				_foodItem.itemFood =  (ItemFood) new ItemFood(0, 2, false, new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("vadapav"),

				ItemList.redChillie =  (ItemRedChillie) new ItemRedChillie(1,0,Blocklist.BlockredChillie,new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("red_chillie"),
				ItemList.greenChillie =  (ItemGreenChillie) new ItemGreenChillie(1,0,Blocklist.BlockgreenChillie,new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName("green_chillie"),
				ItemList.pavBhaji = (ItemBlock) new ItemBlock(Blocklist.blockPavbhaji,new Item.Properties().group(DitemGroup.foodGroup)).setRegistryName(Blocklist.blockPavbhaji.getRegistryName()));
	}
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {	
		event.getRegistry().registerAll(
				Blocklist.BlockgreenChillie = (BlockGreenChillie) new BlockGreenChillie(BlockGreenChillie.Properties.create(Material.CACTUS).hardnessAndResistance(1.0F,0.1F).lightValue(1).sound(SoundType.WET_GRASS)).setRegistryName(location("greenchillie_plant")),
				Blocklist.BlockredChillie = (BlockRedChillie) new BlockRedChillie (BlockRedChillie.Properties.create(Material.CACTUS).hardnessAndResistance(1.0F,0.1F).lightValue(1).sound(SoundType.WET_GRASS)).setRegistryName(location("redchillie_plant")),
				Blocklist.blockPavbhaji = (BlockPavbhaji) new BlockPavbhaji(BlockPavbhaji.Properties.create(Material.CAKE).hardnessAndResistance(3.0f,0.1f).lightValue(6).sound(SoundType.METAL)).setRegistryName(location("pavbhaji"))
				);
	}
	
	@SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll
        (
             
        );
    }
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(mode.modid,name);
	}
}
