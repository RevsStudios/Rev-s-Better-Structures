package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.Util;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.BlockView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class GenericStructure extends StructureFeature<DefaultFeatureConfig> {
    private final String structureName;

    public GenericStructure(Codec<DefaultFeatureConfig> codec, String structureName) {
        super(codec);
        this.structureName = structureName;
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return GenericStructure.Start::new;
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long worldSeed, ChunkRandom random, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, DefaultFeatureConfig config) {
        BlockPos chunkCenter = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);
        int surfaceHeight = chunkGenerator.getHeightInGround(chunkCenter.getX(), chunkCenter.getZ(), Heightmap.Type.WORLD_SURFACE_WG);
        BlockView blockColumn = chunkGenerator.getColumnSample(chunkCenter.getX(), chunkCenter.getZ());
        BlockState surfaceBlock = blockColumn.getBlockState(chunkCenter.up(surfaceHeight));
        return surfaceBlock.getFluidState().isEmpty(); //Disable spawning on water
    }

    public class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
            super(structureFeature, i, j, blockBox, k, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig config) {
            int x = (chunkX << 4) + 7;
            int y = 0;
            int z = (chunkZ << 4) + 7;

            BlockPos.Mutable blockPos = new BlockPos.Mutable(x, y, z);

            boolean nether = biome.getCategory() == Biome.Category.NETHER;
            if (nether) {
                blockPos = getGround(chunkGenerator, x, z);
            }

            StructurePoolBasedGenerator.method_30419(
                    registryManager,
                    new StructurePoolFeatureConfig(() -> registryManager.get(Registry.TEMPLATE_POOL_WORLDGEN)
                            .get(Util.id(structureName + "/start_pool")), 1),
                    PoolStructurePiece::new,
                    chunkGenerator,
                    manager,
                    blockPos,
                    this.children,
                    this.random,
                    false,
                    !nether
            );

            this.children.forEach(piece -> piece.translate(0, 2, 0)); //Raise structures by 1 block

            this.setBoundingBoxFromChildren();
        }
    }

    protected static BlockPos.Mutable getGround(ChunkGenerator chunkGenerator, int x, int z) {
        BlockView column = chunkGenerator.getColumnSample(x, z);
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, 124, z);
        BlockState blockState;
        while (mutable.getY() > chunkGenerator.getSeaLevel()) {
            blockState = column.getBlockState(mutable);

            if (!blockState.isOpaque()) {
                mutable.move(Direction.DOWN);
                continue;
            } else if (column.getBlockState(mutable.add(0, 3, 0)).getMaterial() == Material.AIR) {
                break;
            }
            mutable.move(Direction.DOWN);
        }
        return mutable;
    }
}
