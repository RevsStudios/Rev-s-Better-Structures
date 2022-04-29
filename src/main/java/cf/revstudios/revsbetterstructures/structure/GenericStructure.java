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
    public GenericStructure() {
        super(StructurePoolFeatureConfig.CODEC, GenericStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
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
}
