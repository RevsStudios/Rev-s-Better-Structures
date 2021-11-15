package cf.revstudios.revsbetterstructures.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import cf.revstudios.revsbetterstructures.worldgen.structures.SurfaceDungeonStructure;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RevsStructures {

    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, RevsBetterStructures.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> WINDMILL = STRUCTURES.register("windmill", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "windmill/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> SMALLHOUSE = STRUCTURES.register("smallhouse", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "smallhouse/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> CASTLE = STRUCTURES.register("castle", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "castle/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> BARN = STRUCTURES.register("barn", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "barn/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> BLUETEEPE = STRUCTURES.register("blueteepe", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "blueteepe/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> BROWNTEEPE = STRUCTURES.register("brownteepe", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "brownteepe/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> YELLOWTEEPE = STRUCTURES.register("yellowteepe", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "yellowteepe/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> COTTAGE = STRUCTURES.register("cottage", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "cottage/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> WANDERCAMP = STRUCTURES.register("wandercamp", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "wandercamp/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> ROUNDEDHOUSE = STRUCTURES.register("roundedhouse", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "roundedhouse/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> TENTGREEN = STRUCTURES.register("tentgreen", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "tentgreen/start_pool")));
    public static final RegistryObject<Structure<NoFeatureConfig>> TENTRED = STRUCTURES.register("tentred", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "tentred/start_pool")));

    public static void setupStructures() {
        setupMapSpacingAndLand(WINDMILL.get(), new StructureSeparationSettings(327, 325, 32034987), true);
        setupMapSpacingAndLand(SMALLHOUSE.get(), new StructureSeparationSettings(296, 294, 45165474), true);
        setupMapSpacingAndLand(CASTLE.get(), new StructureSeparationSettings(306, 300, 98156546), true);
        setupMapSpacingAndLand(BARN.get(), new StructureSeparationSettings(415, 410, 15616465), true);
        setupMapSpacingAndLand(BLUETEEPE.get(), new StructureSeparationSettings(492, 487, 85414654), true);
        setupMapSpacingAndLand(BROWNTEEPE.get(), new StructureSeparationSettings(458, 450, 61541645), true);
        setupMapSpacingAndLand(YELLOWTEEPE.get(), new StructureSeparationSettings(450, 440, 65165748), true);
        setupMapSpacingAndLand(COTTAGE.get(), new StructureSeparationSettings(312, 304, 54654156), true);
        setupMapSpacingAndLand(WANDERCAMP.get(), new StructureSeparationSettings(328, 314, 61567486), true);
        setupMapSpacingAndLand(ROUNDEDHOUSE.get(), new StructureSeparationSettings(398, 364, 45476451), true);
        setupMapSpacingAndLand(TENTGREEN.get(), new StructureSeparationSettings(500, 486, 15368478), true);
        setupMapSpacingAndLand(TENTRED.get(), new StructureSeparationSettings(500, 486, 648498484), true);
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {

        Structure.STRUCTURES_REGISTRY.put(Objects.requireNonNull(structure.getRegistryName()).toString(), structure);

        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder().addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();
        }

        DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                .putAll(DimensionStructuresSettings.DEFAULTS).put(structure, structureSeparationSettings).build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig;

            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
}