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

    public static void setupStructures() {
        setupMapSpacingAndLand(WINDMILL.get(), new StructureSeparationSettings(227, 225, 32034987), true);
        setupMapSpacingAndLand(SMALLHOUSE.get(), new StructureSeparationSettings(196, 194, 45165474), true);
        setupMapSpacingAndLand(CASTLE.get(), new StructureSeparationSettings(202, 200, 98156546), true);
        setupMapSpacingAndLand(BARN.get(), new StructureSeparationSettings(302, 300, 15616465), true);
        setupMapSpacingAndLand(BLUETEEPE.get(), new StructureSeparationSettings(302, 300, 85414654), true);
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