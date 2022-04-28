package cf.revstudios.revsbetterstructures.structure.features;

import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import cf.revstudios.revsbetterstructures.Util;
import cf.revstudios.revsbetterstructures.structure.BasicStructureStart;
import cf.revstudios.revsbetterstructures.structure.pieces.BarnStructurePiece;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.List;

public class BarnStructureFeature extends StructureFeature<DefaultFeatureConfig> {
    public BarnStructureFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
        RevsBetterStructures.LOGGER.info("BarnStructureFeature Created");
    }

    @Override
    public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    public static class Start extends BasicStructureStart {
        public Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
            RevsBetterStructures.LOGGER.info("Start Created");
        }

        @Override
        public StructurePiece getStructurePiece(StructureManager manager, BlockPos pos, BlockRotation rotation) {
            return new BarnStructurePiece(manager, pos, Util.id("barn"), rotation);
        }

        @Override
        public List<String> getBiomeBlacklist() {
            return Lists.newArrayList("");
        }
    }
}
