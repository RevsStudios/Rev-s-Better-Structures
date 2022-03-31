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
    public static StructureFeature<?, ?> CONFIGURED_ROUNDEDHOUSE = RevsStructures.ROUNDEDHOUSE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_TENTGREEN = RevsStructures.TENTGREEN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_TENTRED = RevsStructures.TENTRED.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUINEDHOUSE = RevsStructures.RUINEDHOUSE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUINEDHOUSE2 = RevsStructures.RUINEDHOUSE2.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUINEDHOUSE3 = RevsStructures.RUINEDHOUSE3.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_SPRUCETOWER = RevsStructures.SPRUCETOWER.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_NETHERTOWER = RevsStructures.NETHERTOWER.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_DIORITECHAMP = RevsStructures.DIORITECHAMP.get().configured(IFeatureConfig.NONE);


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
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_roundedhouse"), CONFIGURED_ROUNDEDHOUSE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_tentgreen"), CONFIGURED_TENTGREEN);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_tentred"), CONFIGURED_TENTRED);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_ruinedhouse"), CONFIGURED_RUINEDHOUSE);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_ruinedhouse2"), CONFIGURED_RUINEDHOUSE2);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_ruinedhouse3"), CONFIGURED_RUINEDHOUSE3);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_sprucetower"), CONFIGURED_SPRUCETOWER);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_nethertower"), CONFIGURED_NETHERTOWER);
        Registry.register(registry, new ResourceLocation(RevsBetterStructures.MODID, "configured_dioritechamp"), CONFIGURED_DIORITECHAMP);
//


        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.WINDMILL.get(), CONFIGURED_WINDMILL);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.SMALLHOUSE.get(), CONFIGURED_SMALLHOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.CASTLE.get(), CONFIGURED_CASTLE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.BARN.get(), CONFIGURED_BARN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.BLUETEEPE.get(), CONFIGURED_BLUETEEPE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.BROWNTEEPE.get(), CONFIGURED_BROWNTEEPE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.YELLOWTEEPE.get(), CONFIGURED_YELLOWTEEPE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.COTTAGE.get(), CONFIGURED_COTTAGE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.WANDERCAMP.get(), CONFIGURED_WANDERCAMP);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.ROUNDEDHOUSE.get(), CONFIGURED_ROUNDEDHOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.TENTGREEN.get(), CONFIGURED_TENTGREEN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.TENTRED.get(), CONFIGURED_TENTRED);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.RUINEDHOUSE.get(), CONFIGURED_RUINEDHOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.RUINEDHOUSE2.get(), CONFIGURED_RUINEDHOUSE2);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.RUINEDHOUSE3.get(), CONFIGURED_RUINEDHOUSE3);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.SPRUCETOWER.get(), CONFIGURED_SPRUCETOWER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.NETHERTOWER.get(), CONFIGURED_NETHERTOWER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(RevsStructures.DIORITECHAMP.get(), CONFIGURED_DIORITECHAMP);
//
    }
}