package cf.revstudios.revsbetterstructures;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class Util {
    public static @NotNull Identifier id(String path) {
        return new Identifier(RevsBetterStructures.MODID, path);
    }

    public static Identifier prefix(Identifier baseIdentifier, String prefix) {
        return new Identifier(baseIdentifier.getNamespace(), prefix + '/' + baseIdentifier.getPath());
    }
}
