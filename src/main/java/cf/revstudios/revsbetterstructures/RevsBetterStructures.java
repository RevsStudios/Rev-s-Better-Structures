package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.structure.RevsStructureFeatures;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RevsBetterStructures implements ModInitializer {
    public static final String MODID = "revsbetterstructures";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        RevsStructureFeatures.register();
    }
}
