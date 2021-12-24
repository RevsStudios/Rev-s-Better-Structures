package cf.revstudios.revsbetterstructures.events;

import cf.revstudios.revsbetterstructures.registry.RevsConfiguredStructures;
import cf.revstudios.revsbetterstructures.registry.RevsStructures;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommonSetupEvent {

    private static Method codecMethod;

    public static void onFMLCommonSetupEvent(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            RevsStructures.setupStructures();
            RevsConfiguredStructures.registerConfiguredStructures();
        });
    }

    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if (!(event.getWorld() instanceof ServerWorld)) return;

        ServerWorld serverWorld = (ServerWorld) event.getWorld();
        ServerChunkProvider chunkProvider = serverWorld.getChunkSource();

        if (serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator && serverWorld.dimension().equals(World.OVERWORLD))
            return;

        Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(chunkProvider.generator.getSettings().structureConfig());

        tempMap.putIfAbsent(RevsStructures.WINDMILL.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.WINDMILL.get()));
        tempMap.putIfAbsent(RevsStructures.SMALLHOUSE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.SMALLHOUSE.get()));
        tempMap.putIfAbsent(RevsStructures.CASTLE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.CASTLE.get()));
        tempMap.putIfAbsent(RevsStructures.BARN.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.BARN.get()));
        tempMap.putIfAbsent(RevsStructures.BLUETEEPE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.BLUETEEPE.get()));
        tempMap.putIfAbsent(RevsStructures.BROWNTEEPE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.BROWNTEEPE.get()));
        tempMap.putIfAbsent(RevsStructures.YELLOWTEEPE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.YELLOWTEEPE.get()));
        tempMap.putIfAbsent(RevsStructures.COTTAGE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.COTTAGE.get()));
        tempMap.putIfAbsent(RevsStructures.WANDERCAMP.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.WANDERCAMP.get()));
        tempMap.putIfAbsent(RevsStructures.ROUNDEDHOUSE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.ROUNDEDHOUSE.get()));
        tempMap.putIfAbsent(RevsStructures.TENTGREEN.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.TENTGREEN.get()));
        tempMap.putIfAbsent(RevsStructures.TENTRED.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.TENTRED.get()));
        tempMap.putIfAbsent(RevsStructures.RUINEDHOUSE.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.RUINEDHOUSE.get()));
        tempMap.putIfAbsent(RevsStructures.RUINEDHOUSE2.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.RUINEDHOUSE2.get()));
        tempMap.putIfAbsent(RevsStructures.RUINEDHOUSE3.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.RUINEDHOUSE3.get()));
        tempMap.putIfAbsent(RevsStructures.SPRUCETOWER.get(), DimensionStructuresSettings.DEFAULTS.get(RevsStructures.SPRUCETOWER.get()));


        chunkProvider.generator.getSettings().structureConfig = tempMap;
    }
}