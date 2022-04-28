package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.Util;
import cf.revstudios.revsbetterstructures.structure.features.BarnStructure;
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

public class RevStructures {
    public static StructureFeature<DefaultFeatureConfig> BARN = new BarnStructure(DefaultFeatureConfig.CODEC);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_BARN = BARN.configure(FeatureConfig.DEFAULT);

    public static void register() {
        register("barn", BARN, 1319041);

        configure("barn", CONFIGURED_BARN, BiomeSelectors.all());
    }

    private static void register(String structureName, StructureFeature<DefaultFeatureConfig> structureFeature, int salt) {
        FabricStructureBuilder.create(Util.id(structureName), structureFeature)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(new StructureConfig(10, 5, salt))
                .superflatFeature(structureFeature.configure(FeatureConfig.DEFAULT))
                .adjustsSurface()
                .register();
    }

    private static void configure(String structureName, ConfiguredStructureFeature<?, ?> configuredStructureFeature, Predicate<BiomeSelectionContext> biomeSelectors) {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, Util.id(structureName), configuredStructureFeature);
        BiomeModifications.create(Util.id(structureName + "_addition"))
                .add(
                        ModificationPhase.ADDITIONS,
                        biomeSelectors,
                        ctx -> ctx.getGenerationSettings().addBuiltInStructure(configuredStructureFeature)
                );
    }
}
