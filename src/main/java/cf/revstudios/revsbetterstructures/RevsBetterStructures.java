package cf.revstudios.revsbetterstructures;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RevsBetterStructures implements ModInitializer {
    public static final String MODID = "revsbetterstructures";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            RevsLocateCommand.register(dispatcher);
        }));
    }
}
