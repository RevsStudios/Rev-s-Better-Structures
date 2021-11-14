package cf.revstudios.revsbetterstructures.registry;

import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class RevsConfiguredStructures {

    public static StructureFeature<?, ?> CONFIGURED_WINDMILL = RevsStructures.WINDMILL.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_SMALLHOUSE = RevsStructures.SMALLHOUSE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_CASTLE = RevsStructures.CASTLE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_BARN = RevsStructures.BARN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_BLUETEEPE = RevsStructures.BLUETEEPE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_BROWNTEEPE = RevsStructures.BROWNTEEPE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_YELLOWTEEPE = RevsStructures.YELLOWTEEPE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_COTTAGE = RevsStructures.COTTAGE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WANDERCAMP = RevsStructures.WANDERCAMP.get().configured(IFeatureConfig.NONE);

    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_windmill"), CONFIGURED_WINDMILL);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_smallhouse"), CONFIGURED_SMALLHOUSE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_castle"), CONFIGURED_CASTLE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_barn"), CONFIGURED_BARN);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_blueteepe"), CONFIGURED_BLUETEEPE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_brownteepe"), CONFIGURED_BROWNTEEPE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_yellowteepe"), CONFIGURED_YELLOWTEEPE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_cottage"), CONFIGURED_COTTAGE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_wandercamp"), CONFIGURED_WANDERCAMP);

        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.WINDMILL.get(), CONFIGURED_WINDMILL);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.SMALLHOUSE.get(), CONFIGURED_SMALLHOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.CASTLE.get(), CONFIGURED_CASTLE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.BARN.get(), CONFIGURED_BARN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.BLUETEEPE.get(), CONFIGURED_BLUETEEPE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.BROWNTEEPE.get(), CONFIGURED_BROWNTEEPE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.YELLOWTEEPE.get(), CONFIGURED_YELLOWTEEPE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.COTTAGE.get(), CONFIGURED_COTTAGE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.COTTAGE.get(), CONFIGURED_WANDERCAMP);
    }
}