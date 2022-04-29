package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.Util;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
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
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long worldSeed, ChunkRandom random, ChunkPos chunkPos, Biome biome, ChunkPos chunkPos2, DefaultFeatureConfig config, HeightLimitView heightLimitView) {
        BlockPos chunkCenter = new BlockPos(chunkPos.x * 16, 0, chunkPos.x * 16);
        int surfaceHeight = chunkGenerator.getHeightInGround(chunkCenter.getX(), chunkCenter.getZ(), Heightmap.Type.WORLD_SURFACE_WG, heightLimitView);
        VerticalBlockSample blockColumn = chunkGenerator.getColumnSample(chunkCenter.getX(), chunkCenter.getZ(), heightLimitView);
        BlockState surfaceBlock = blockColumn.getState(chunkCenter.up(surfaceHeight));
        return surfaceBlock.getFluidState().isEmpty(); //Disable spawning on water
    }

    public class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, ChunkPos chunkPos, int reference, long seed) {
            super(structureFeature, chunkPos, reference, seed);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos chunkPos, Biome biome, DefaultFeatureConfig config, HeightLimitView heightLimitView) {
            int x = chunkPos.x * 16;
            int y = 0;
            int z = chunkPos.z * 16;

            BlockPos.Mutable blockPos = new BlockPos.Mutable(x, y, z);

            boolean nether = biome.getCategory() == Biome.Category.NETHER;
            if (nether) {
                blockPos = getGround(chunkGenerator, x, z, heightLimitView);
            }

            StructurePoolBasedGenerator.generate(
                    registryManager,
                    new StructurePoolFeatureConfig(() -> registryManager.get(Registry.STRUCTURE_POOL_KEY)
                            .get(Util.id(structureName + "/start_pool")), 1),
                    PoolStructurePiece::new,
                    chunkGenerator,
                    manager,
                    blockPos,
                    this,
                    this.random,
                    false,
                    !nether,
                    heightLimitView
            );

            this.children.forEach(piece -> piece.translate(0, 2, 0)); //Raise structures by 1 block

            this.setBoundingBoxFromChildren();
        }
    }

    protected static BlockPos.Mutable getGround(ChunkGenerator chunkGenerator, int x, int z, HeightLimitView heightLimitView) {
        VerticalBlockSample column = chunkGenerator.getColumnSample(x, z, heightLimitView);
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, 124, z);
        BlockState blockState;
        while (mutable.getY() > chunkGenerator.getSeaLevel()) {
            blockState = column.getState(mutable);

            if (!blockState.isOpaque()) {
                mutable.move(Direction.DOWN);
                continue;
            } else if (column.getState(mutable.add(0, 3, 0)).getMaterial() == Material.AIR) {
                break;
            }
            mutable.move(Direction.DOWN);
        }
        return mutable;
    }
}
