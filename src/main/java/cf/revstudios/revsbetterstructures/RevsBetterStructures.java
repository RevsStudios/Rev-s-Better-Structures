package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.structure.RevStructures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RevsBetterStructures implements ModInitializer {
    public static final String MODID = "revsbetterstructures";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        RevStructures.register();
    }
}
