package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.Util;
import cf.revstudios.revsbetterstructures.mixin.StructureFeatureInvoker;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class RevStructures {
    public static final StructureFeature<?> WINDMILL = register("windmill");
    public static final StructureFeature<?> SMALLHOUSE = register("smallhouse");
    public static final StructureFeature<?> CASTLE = register("castle");
    public static final StructureFeature<?> BARN = register("barn");
    public static final StructureFeature<?> BLUETEEPEE = register("blueteepee");
    public static final StructureFeature<?> BROWNTEEPEE = register("brownteepee");
    public static final StructureFeature<?> YELLOWTEEPEE = register("yellowteepee");
    public static final StructureFeature<?> COTTAGE = register("cottage");
    public static final StructureFeature<?> WANDERCAMP = register("wandercamp");
    public static final StructureFeature<?> ROUNDEDHOUSE = register("roundedhouse");
    public static final StructureFeature<?> TENTGREEN = register("tentgreen");
    public static final StructureFeature<?> TENTRED = register("tentred");
    public static final StructureFeature<?> RUINEDHOUSE = register("ruinedhouse");
    public static final StructureFeature<?> RUINEDHOUSE2 = register("ruinedhouse2");
    public static final StructureFeature<?> RUINEDHOUSE3 = register("ruinedhouse3");
    public static final StructureFeature<?> SPRUCETOWER = register("sprucetower");
    public static final StructureFeature<?> NETHERTOWER = register("nethertower");
    public static final StructureFeature<?> DIORITECHAMP = register("dioritechamp");
    public static final StructureFeature<?> FALLENTREE1 = register("fallentree1");
    public static final StructureFeature<?> FALLENTREE2 = register("fallentree2");
    public static final StructureFeature<?> GIGATREE = register("gigatree");
    public static final StructureFeature<?> GIGACACTUS = register("gigacactus");
    public static final StructureFeature<?> ROCKCHAMP = register("rockchamp");
    public static final StructureFeature<?> ROCKCHAMP2 = register("rockchamp2");

    public static void register() {}

    private static StructureFeature<?> register(String structureName) {
        StructureFeature<?> structureFeature = new GenericStructure(structureName);
        ConfiguredStructureFeature<?, ?> configuredStructureFeature = structureFeature.configure(StructurePoolFeatureConfig.DEFAULT, TagKey.of(Registry.BIOME_KEY, new Identifier("minecraft", "is_overworld")));
        StructureFeatureInvoker.invokeRegister(Util.strId(structureName), structureFeature, GenerationStep.Feature.SURFACE_STRUCTURES);
        return structureFeature;
    }
}
