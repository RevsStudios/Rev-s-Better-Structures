package cf.revstudios.revsbetterstructures.registry;

import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import cf.revstudios.revsbetterstructures.worldgen.structures.SurfaceDungeonStructure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
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
	public static final RegistryObject<Structure<NoFeatureConfig>> BLUETEEPEE = STRUCTURES.register("blueteepee", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "blueteepee/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> BROWNTEEPEE = STRUCTURES.register("brownteepee", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "brownteepee/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> YELLOWTEEPEE = STRUCTURES.register("yellowteepee", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "yellowteepee/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> COTTAGE = STRUCTURES.register("cottage", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "cottage/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> WANDERCAMP = STRUCTURES.register("wandercamp", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "wandercamp/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> ROUNDEDHOUSE = STRUCTURES.register("roundedhouse", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "roundedhouse/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> TENTGREEN = STRUCTURES.register("tentgreen", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "tentgreen/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> TENTRED = STRUCTURES.register("tentred", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "tentred/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> RUINEDHOUSE = STRUCTURES.register("ruinedhouse", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "ruinedhouse/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> RUINEDHOUSE2 = STRUCTURES.register("ruinedhouse2", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "ruinedhouse2/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> RUINEDHOUSE3 = STRUCTURES.register("ruinedhouse3", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "ruinedhouse3/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> SPRUCETOWER = STRUCTURES.register("sprucetower", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "sprucetower/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> NETHERTOWER = STRUCTURES.register("nethertower", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "nethertower/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> DIORITECHAMP = STRUCTURES.register("dioritechamp", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "dioritechamp/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> FALLENTREE1 = STRUCTURES.register("fallentree1", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "fallentree1/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> FALLENTREE2 = STRUCTURES.register("fallentree2", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "fallentree2/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> GIGATREE = STRUCTURES.register("gigatree", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "gigatree/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> GIGACACTUS = STRUCTURES.register("gigacactus", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "gigacactus/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> ROCKCHAMP = STRUCTURES.register("rockchamp", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "rockchamp/start_pool")));
	public static final RegistryObject<Structure<NoFeatureConfig>> ROCKCHAMP2 = STRUCTURES.register("rockchamp2", () -> (new SurfaceDungeonStructure(NoFeatureConfig.CODEC, "rockchamp2/start_pool")));

	public static void setupStructures() {
		setupMapSpacingAndLand(WINDMILL.get(), new StructureSeparationSettings(827, 825, 3203498), true);
		setupMapSpacingAndLand(SMALLHOUSE.get(), new StructureSeparationSettings(396, 394, 451654774), true);
		setupMapSpacingAndLand(CASTLE.get(), new StructureSeparationSettings(706, 700, 9815654), true);
		setupMapSpacingAndLand(BARN.get(), new StructureSeparationSettings(915, 910, 156164566), true);
		setupMapSpacingAndLand(BLUETEEPEE.get(), new StructureSeparationSettings(592, 587, 85414654), true);
		setupMapSpacingAndLand(BROWNTEEPEE.get(), new StructureSeparationSettings(558, 550, 6154165), true);
		setupMapSpacingAndLand(YELLOWTEEPEE.get(), new StructureSeparationSettings(550, 540, 651657648), true);
		setupMapSpacingAndLand(COTTAGE.get(), new StructureSeparationSettings(612, 604, 546541566), true);
		setupMapSpacingAndLand(WANDERCAMP.get(), new StructureSeparationSettings(428, 414, 6157486), true);
		setupMapSpacingAndLand(ROUNDEDHOUSE.get(), new StructureSeparationSettings(498, 464, 454706451), true);
		setupMapSpacingAndLand(TENTGREEN.get(), new StructureSeparationSettings(600, 586, 1536878), true);
		setupMapSpacingAndLand(TENTRED.get(), new StructureSeparationSettings(600, 586, 648498484), true);
		setupMapSpacingAndLand(RUINEDHOUSE.get(), new StructureSeparationSettings(586, 550, 564185715), true);
		setupMapSpacingAndLand(RUINEDHOUSE2.get(), new StructureSeparationSettings(586, 550, 691545156), true);
		setupMapSpacingAndLand(RUINEDHOUSE3.get(), new StructureSeparationSettings(586, 550, 23485623), true);
		setupMapSpacingAndLand(SPRUCETOWER.get(), new StructureSeparationSettings(896, 859, 2743859), true);
		setupMapSpacingAndLand(NETHERTOWER.get(), new StructureSeparationSettings(896, 859, 2743859), true);
		setupMapSpacingAndLand(DIORITECHAMP.get(), new StructureSeparationSettings(96, 59, 15498198), true);
		setupMapSpacingAndLand(FALLENTREE1.get(), new StructureSeparationSettings(96, 59, 51951594), true);
		setupMapSpacingAndLand(FALLENTREE2.get(), new StructureSeparationSettings(96, 59, 841896415), true);
		setupMapSpacingAndLand(GIGATREE.get(), new StructureSeparationSettings(896, 859, 81951651), true);
		setupMapSpacingAndLand(GIGACACTUS.get(), new StructureSeparationSettings(896, 859, 418494668), true);
		setupMapSpacingAndLand(ROCKCHAMP.get(), new StructureSeparationSettings(96, 59, 98498164), true);
		setupMapSpacingAndLand(ROCKCHAMP2.get(), new StructureSeparationSettings(96, 59, 18718974), true);
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
