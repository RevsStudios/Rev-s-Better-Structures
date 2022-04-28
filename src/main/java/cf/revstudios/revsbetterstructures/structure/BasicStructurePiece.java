package cf.revstudios.revsbetterstructures.structure;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

public class BasicStructurePiece extends SimpleStructurePiece {
    private final BlockRotation rotation;
    private final Identifier template;

    public BasicStructurePiece(StructureManager structureManager, NbtCompound nbtCompound) {
        super(null, nbtCompound);
        this.template = new Identifier(nbtCompound.getString("Template"));
        this.rotation = BlockRotation.valueOf(nbtCompound.getString("Rot"));

        this.initializeStructureData(structureManager);
    }

    public BasicStructurePiece(StructureManager structureManager, BlockPos pos, Identifier template, BlockRotation rotation) {
        super(null, 0);
        this.pos = pos;
        this.rotation = rotation;
        this.template = template;

        this.initializeStructureData(structureManager);
    }

    private void initializeStructureData(StructureManager structureManager) {
        Structure structure = structureManager.getStructureOrBlank(this.template);
        StructurePlacementData placementData = (new StructurePlacementData())
                .setRotation(this.rotation)
                .setMirror(BlockMirror.NONE)
                .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        this.setStructureData(structure, this.pos, placementData);
    }

    protected void toNbt(NbtCompound nbtCompound) {
        super.toNbt(nbtCompound);
        nbtCompound.putString("Template", this.template.toString());
        nbtCompound.putString("Rot", this.rotation.name());
    }

    @Override
    protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {
    }
}
