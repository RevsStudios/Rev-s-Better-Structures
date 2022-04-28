package cf.revstudios.revsbetterstructures.structure.pieces;

import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import cf.revstudios.revsbetterstructures.structure.BasicStructurePiece;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.StructureManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class BarnStructurePiece extends BasicStructurePiece {
    public BarnStructurePiece(StructureManager structureManager, NbtCompound nbtCompound) {
        super(structureManager, nbtCompound);
        RevsBetterStructures.LOGGER.info("BarnStructurePiece Created");
    }

    public BarnStructurePiece(StructureManager manager, BlockPos pos, Identifier template, BlockRotation rotation) {
        super(manager, pos, template, rotation);
        RevsBetterStructures.LOGGER.info("BarnStructurePiece Created");
    }
}
