package cf.revstudios.revsbetterstructures.mixin;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StructureFeature.class)
public interface StructureFeatureInvoker {
    @Invoker
    static <T extends  StructureFeature<?>> T invokeRegister(String identifier, T structureFeature, GenerationStep.Feature generationStep) {
        throw new AssertionError();
    }
}
