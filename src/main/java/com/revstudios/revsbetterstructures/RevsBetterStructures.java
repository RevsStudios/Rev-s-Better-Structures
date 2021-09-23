package com.revstudios.revsbetterstructures;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("revsbetterstructures")
public class RevsBetterStructures{

    public static final String MODID = "revsbetterstructures";
    public static final String MODNAME = "Revs Better Structures";
    public static final String VERSION = "1.0.0";
    public static final Logger LOGGER = LogManager.getLogger();
    public static RevsBetterStructures INSTANCE;

    public RevsBetterStructures() {
        INSTANCE = this;

        LOGGER.debug(MODNAME + " Version is: " + VERSION);
        LOGGER.debug("Mod ID for " + MODNAME + " is: " + MODID);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
