package cf.revstudios.revsbetterstructures;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class Util {
    public static @NotNull Identifier id(String path) {
        return new Identifier(RevsBetterStructures.MODID, path);
    }

    public static @NotNull String strId(String path) {
        return RevsBetterStructures.MODID + ':' + path;
    }
}
