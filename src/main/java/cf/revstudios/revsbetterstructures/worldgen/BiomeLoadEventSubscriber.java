package cf.revstudios.revsbetterstructures.worldgen;

import cf.revstudios.revsbetterstructures.registry.RevsConfiguredStructures;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BiomeLoadEventSubscriber {
	
	public static void onBiomeLoadingEvent(final BiomeLoadingEvent event) {
		StructureHandler.addStructureSpawns(event);
	}

	private static class StructureHandler {
		public static void addStructureSpawns(BiomeLoadingEvent event) {
			BiomeGenerationSettingsBuilder builder = event.getGeneration();

			RegistryKey<Biome> biome = RegistryKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName(), "Who registered null name biome, naming criticism!"));

			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) {
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_WINDMILL);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_SMALLHOUSE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_CASTLE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_BARN);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_BLUETEEPE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_BROWNTEEPE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_YELLOWTEEPE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_COTTAGE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_WANDERCAMP);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_ROUNDEDHOUSE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_TENTGREEN);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_TENTRED);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_RUINEDHOUSE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_RUINEDHOUSE2);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_RUINEDHOUSE3);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_SPRUCETOWER);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_DIORITECHAMP);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_FALLENTREE1);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_FALLENTREE2);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_GIGATREE);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_GIGACACTUS);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_ROCKCHAMP);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_ROCKCHAMP2);
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_ROCKCHAMP3);

			}
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)) {
				builder.addStructureStart(RevsConfiguredStructures.CONFIGURED_NETHERTOWER);
//
			}
		}
	}
}
