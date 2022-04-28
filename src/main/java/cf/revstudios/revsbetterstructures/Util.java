package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.structure.BasicStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Util {
    public static @NotNull Identifier id(String path) {
        return new Identifier(RevsBetterStructures.MODID, path);
    }

    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, String structure, List<StructurePiece> pieces) {
        pieces.add(new BasicStructurePiece(manager, pos, Util.id(structure), rotation));
    }
}
