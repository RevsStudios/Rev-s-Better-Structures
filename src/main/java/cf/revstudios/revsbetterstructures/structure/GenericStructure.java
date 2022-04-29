package cf.revstudios.revsbetterstructures.structure;

import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Optional;

public class GenericStructure extends StructureFeature<StructurePoolFeatureConfig> {
    private final String structureName;

    public GenericStructure(String structureName) {
        super(StructurePoolFeatureConfig.CODEC, GenericStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
        this.structureName = structureName;
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        BlockPos blockPos = context.chunkPos().getCenterAtY(0);

        int surfaceHeight = context.chunkGenerator().getHeightInGround(blockPos.getX(), blockPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());
        blockPos = blockPos.up(surfaceHeight + 60);

        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context,
                        PoolStructurePiece::new,
                        blockPos,
                        false,
                        false
                );

        return structurePiecesGenerator;
    }


    /*
    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {

    }
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
     */
}
