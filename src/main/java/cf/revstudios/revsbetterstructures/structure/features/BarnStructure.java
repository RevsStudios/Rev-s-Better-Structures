package cf.revstudios.revsbetterstructures.structure.features;

import cf.revstudios.revsbetterstructures.Util;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class BarnStructure extends StructureFeature<DefaultFeatureConfig> {
    public BarnStructure(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return BarnStructure.Start::new;
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long worldSeed, ChunkRandom random, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, DefaultFeatureConfig config) {
        BlockPos chunkCenter = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);
        int surfaceHeight = chunkGenerator.getHeightInGround(chunkCenter.getX(), chunkCenter.getZ(), Heightmap.Type.WORLD_SURFACE_WG);
        BlockView blockColumn = chunkGenerator.getColumnSample(chunkCenter.getX(), chunkCenter.getZ());
        BlockState surfaceBlock = blockColumn.getBlockState(chunkCenter.up(surfaceHeight));
        return surfaceBlock.getFluidState().isEmpty(); //Disable spawning on water
    }

    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
            super(structureFeature, i, j, blockBox, k, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig config) {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            BlockPos.Mutable blockPos = new BlockPos.Mutable(x, 0, z);

            StructurePoolBasedGenerator.method_30419(
                    registryManager,
                    new StructurePoolFeatureConfig(() -> registryManager.get(Registry.TEMPLATE_POOL_WORLDGEN)
                            .get(Util.id("barn/start_pool")), 1),
                    PoolStructurePiece::new,
                    chunkGenerator,
                    manager,
                    blockPos,
                    this.children,
                    this.random,
                    false,
                    true
            );

            this.setBoundingBoxFromChildren();
        }
    }
}
