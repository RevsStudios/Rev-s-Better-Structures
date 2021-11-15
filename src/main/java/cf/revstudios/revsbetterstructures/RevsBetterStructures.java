package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.events.CommonSetupEvent;
import cf.revstudios.revsbetterstructures.registry.RevsStructures;
import cf.revstudios.revsbetterstructures.worldgen.BiomeLoadEventSubscriber;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("revsbetterstructures")
public class RevsBetterStructures {

    public static final String MODID = "revsbetterstructures";
    public static final String MODNAME = "Revs Better Structures";
    public static final String VERSION = "1.4.0";
    public static final Logger LOGGER = LogManager.getLogger();
    public static RevsBetterStructures INSTANCE;

    public RevsBetterStructures() {
        INSTANCE = this;

        LOGGER.debug(MODNAME + " Version is: " + VERSION);
        LOGGER.debug("Mod ID for " + MODNAME + " is: " + MODID);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register to the mod event bus
        eventBus.addListener(CommonSetupEvent::onFMLCommonSetupEvent);

        RevsStructures.STRUCTURES.register(eventBus);

        //Register to the forge event bus
        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, CommonSetupEvent::addDimensionalSpacing);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeLoadEventSubscriber::onBiomeLoadingEvent);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
