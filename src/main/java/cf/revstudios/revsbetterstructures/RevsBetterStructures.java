package cf.revstudios.revsbetterstructures;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;

public class RevsBetterStructures implements ModInitializer {
    public static final String MODID = "revsbetterstructures";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((((dispatcher, registryAccess, environment) -> {
            //RevsLocateCommand.register(dispatcher);
        })));
    }
}
