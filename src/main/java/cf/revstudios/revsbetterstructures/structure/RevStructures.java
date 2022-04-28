package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.Util;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.function.Predicate;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class RevStructures {
    public static final ConfiguredStructureFeature<?, ?> WINDMILL = register("windmill", new StructureConfig(827, 825, 3203498));
    public static final ConfiguredStructureFeature<?, ?> SMALLHOUSE = register("smallhouse", new StructureConfig(396, 394, 451654774));
    public static final ConfiguredStructureFeature<?, ?> CASTLE = register("castle", new StructureConfig(706, 700, 9815654));
    public static final ConfiguredStructureFeature<?, ?> BARN = register("barn", new StructureConfig(915, 910, 451654774));
    public static final ConfiguredStructureFeature<?, ?> BLUETEEPEE = register("blueteepee", new StructureConfig(592, 587, 85414654));
    public static final ConfiguredStructureFeature<?, ?> BROWNTEEPEE = register("brownteepee", new StructureConfig(558, 550, 6154165));
    public static final ConfiguredStructureFeature<?, ?> YELLOWTEEPEE = register("yellowteepee", new StructureConfig(550, 540, 651657648));
    public static final ConfiguredStructureFeature<?, ?> COTTAGE = register("cottage", new StructureConfig(612, 604, 546541566));
    public static final ConfiguredStructureFeature<?, ?> WANDERCAMP = register("wandercamp", new StructureConfig(428, 414, 6157486));
    public static final ConfiguredStructureFeature<?, ?> ROUNDEDHOUSE = register("roundedhouse", new StructureConfig(498, 464, 454706451));
    public static final ConfiguredStructureFeature<?, ?> TENTGREEN = register("tentgreen", new StructureConfig(600, 586, 1536878));
    public static final ConfiguredStructureFeature<?, ?> TENTRED = register("tentred", new StructureConfig(600, 586, 648498484));
    public static final ConfiguredStructureFeature<?, ?> RUINEDHOUSE = register("ruinedhouse", new StructureConfig(586, 550, 564185715));
    public static final ConfiguredStructureFeature<?, ?> RUINEDHOUSE2 = register("ruinedhouse2", new StructureConfig(586, 550, 691545156));
    public static final ConfiguredStructureFeature<?, ?> RUINEDHOUSE3 = register("ruinedhouse3", new StructureConfig(586, 550, 23485623));
    public static final ConfiguredStructureFeature<?, ?> SPRUCETOWER = register("sprucetower", new StructureConfig(896, 859, 2743859));
    public static final ConfiguredStructureFeature<?, ?> NETHERTOWER = register("nethertower", new StructureConfig(896, 859, 2743859));
    public static final ConfiguredStructureFeature<?, ?> DIORITECHAMP = register("dioritechamp", new StructureConfig(96, 59, 15498198));
    public static final ConfiguredStructureFeature<?, ?> FALLENTREE1 = register("fallentree1", new StructureConfig(96, 59, 51951594));
    public static final ConfiguredStructureFeature<?, ?> FALLENTREE2 = register("fallentree2", new StructureConfig(96, 59, 841896415));
    public static final ConfiguredStructureFeature<?, ?> GIGATREE = register("gigatree", new StructureConfig(896, 859, 81951651));
    public static final ConfiguredStructureFeature<?, ?> GIGACACTUS = register("gigacactus", new StructureConfig(896, 859, 418494668));
    public static final ConfiguredStructureFeature<?, ?> ROCKCHAMP = register("rockchamp", new StructureConfig(96, 59, 98498164));
    public static final ConfiguredStructureFeature<?, ?> ROCKCHAMP2 = register("rockchamp2", new StructureConfig(96, 59, 18718974));

    public static void register() {}

    private static ConfiguredStructureFeature<?, ?> register(String structureName, StructureConfig structureConfig) {
        return register(structureName, structureConfig, BiomeSelectors.all());
    }

    private static ConfiguredStructureFeature<?, ?> register(String structureName, StructureConfig structureConfig, Predicate<BiomeSelectionContext> biomeSelectors) {
        StructureFeature<DefaultFeatureConfig> structure = new GenericStructure(DefaultFeatureConfig.CODEC, structureName);
        ConfiguredStructureFeature<?, ?> configuredStructure = structure.configure(FeatureConfig.DEFAULT);

        FabricStructureBuilder.create(Util.id(structureName), structure)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(structureConfig)
                .superflatFeature(structure.configure(FeatureConfig.DEFAULT))
                .adjustsSurface()
                .register();

        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, Util.id(structureName), configuredStructure);
        BiomeModifications.create(Util.id(structureName + "_addition"))
                .add(
                        ModificationPhase.ADDITIONS,
                        biomeSelectors,
                        ctx -> ctx.getGenerationSettings().addBuiltInStructure(configuredStructure)
                );

        return configuredStructure;
    }
}
