package com.dexter_mode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import net.minecraftforge.common.MinecraftForge;
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
}
