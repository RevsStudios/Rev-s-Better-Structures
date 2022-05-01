package cf.revstudios.revsbetterstructures.structure;

import cf.revstudios.revsbetterstructures.Util;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.structure.*;
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
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Optional;

public class GenericStructure extends StructureFeature<StructurePoolFeatureConfig> {
    public GenericStructure(String structureName) {
        super(StructurePoolFeatureConfig.CODEC, (context) -> GenericStructure.createPiecesGenerator(context, structureName), PostPlacementProcessor.EMPTY);
    }

    private static boolean isFeatureChunk(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        BlockPos chunkCenter = context.chunkPos().getCenterAtY(0);
        int surface = context.chunkGenerator().getHeightInGround(chunkCenter.getX(), chunkCenter.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());
        VerticalBlockSample column = context.chunkGenerator().getColumnSample(chunkCenter.getX(), chunkCenter.getZ(), context.world());
        BlockState surfaceBlock = column.getState(surface);
        return surfaceBlock.getFluidState().isEmpty(); //Check for water
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context, String structureName) {
        if (!GenericStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        StructurePoolFeatureConfig config = new StructurePoolFeatureConfig(
                () -> context.registryManager().get(Registry.STRUCTURE_POOL_KEY).get(Util.id(structureName)),
                1
        );

        StructureGeneratorFactory.Context<StructurePoolFeatureConfig> newContext = new StructureGeneratorFactory.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                config,
                context.world(),
                context.validBiome(),
                context.structureManager(),
                context.registryManager()
        );


        BlockPos blockPos = context.chunkPos().getCenterAtY(0);
        boolean nether = context.chunkGenerator().getBiomeForNoiseGen(blockPos.getX(), blockPos.getY(), blockPos.getZ()).getCategory().equals(Biome.Category.NETHER);
        if (nether) {
            blockPos = getGround(context.chunkGenerator(), blockPos.getX(), blockPos.getZ(), context.world());
        }

        return StructurePoolBasedGenerator.generate(
                newContext, // Used for StructurePoolBasedGenerator to get all the proper behaviors done.
                PoolStructurePiece::new, // Needed in order to create a list of jigsaw pieces when making the structure's layout.
                blockPos, // Position of the structure. Y value is ignored if last parameter is set to true.
                false,  // Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                // Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                !nether // Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.
        );
    }

    private static BlockPos.Mutable getGround(ChunkGenerator chunkGenerator, int x, int z, HeightLimitView heightLimitView) {
        VerticalBlockSample column = chunkGenerator.getColumnSample(x, z, heightLimitView);
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, 124, z);
        BlockState blockState;
        while (mutable.getY() > chunkGenerator.getSeaLevel()) {
            blockState = column.getState(mutable.getY());

            if (!blockState.isOpaque()) {
                mutable.move(Direction.DOWN);
                continue;
            } else if (column.getState(mutable.getY() + 3).getMaterial() == Material.AIR) {
                break;
            }
            mutable.move(Direction.DOWN);
        }
        return mutable;
    }
}
