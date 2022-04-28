package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import com.google.common.collect.Lists;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.List;

public abstract class BasicStructureStart extends StructureStart<DefaultFeatureConfig> {
    public BasicStructureStart(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
        super(feature, chunkX, chunkZ, box, references, seed);
    }

    @Override
    public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig config) {
        RevsBetterStructures.LOGGER.info("Start Initialization Reached");
        if (getBiomeBlacklist().contains(biome.getCategory().getName())) {
            int x = chunkX * 16;
            int z = chunkZ * 16;
            int y = chunkGenerator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos pos = new BlockPos(x, y - 2, z);
            BlockRotation rotation = BlockRotation.random(this.random);
            this.children.add(this.getStructurePiece(manager, pos, rotation));
            this.setBoundingBoxFromChildren();
        }
    }

    public abstract StructurePiece getStructurePiece(StructureManager manager, BlockPos pos, BlockRotation rotation);

    public List<String> getBiomeBlacklist() {
        return Lists.newArrayList("none");
    };
}
