package cf.revstudios.revsbetterstructures;

import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class RevsBiomeTags {
    public static final TagKey<Biome> OVERWORLD_SURFACE = register("overworld_surface");
    public static final TagKey<Biome> OVERWORLD_UNDERGROUND = register("overworld_underground");
    public static final TagKey<Biome> NETHER = register("nether");
    public static final TagKey<Biome> END = register("end");

    private static TagKey<Biome> register(String tagName) {
        return TagKey.of(Registry.BIOME_KEY, Util.prefix(Util.id(tagName), "has_structure"));
    }
}
