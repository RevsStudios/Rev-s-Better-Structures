package cf.revstudios.revsbetterstructures.structure.features;

import cf.revstudios.revsbetterstructures.structure.BasicStructureStart;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockBox;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.List;

public class FallenTree2StructureFeature extends StructureFeature<DefaultFeatureConfig> {
    public FallenTree2StructureFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    public static class Start extends BasicStructureStart {
        public Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public String getStructure() {
            return "fallentree2";
        }

        @Override
        public List<String> getBiomeBlacklist() {
            return Lists.newArrayList("");
        }
    }
}
