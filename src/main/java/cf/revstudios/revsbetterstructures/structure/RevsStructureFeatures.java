package cf.revstudios.revsbetterstructures.structure;


import cf.revstudios.revsbetterstructures.RevsBetterStructures;
import cf.revstudios.revsbetterstructures.Util;
import cf.revstudios.revsbetterstructures.structure.BasicStructurePiece;
import cf.revstudios.revsbetterstructures.structure.features.*;
import cf.revstudios.revsbetterstructures.structure.pieces.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class RevsStructureFeatures {
    public static void register() {
        registerStructure("barn", new BarnStructureFeature(DefaultFeatureConfig.CODEC), BarnStructurePiece::new);
        //registerStructure("blueteepee", new BlueTeepeeStructureFeature(DefaultFeatureConfig.CODEC), BlueTeepeeStructurePiece::new);
        //registerStructure("brownteepee", new BrownTeepeeStructureFeature(DefaultFeatureConfig.CODEC), BrownTeepeeStructurePiece::new);
        //registerStructure("castle", new CastleStructureFeature(DefaultFeatureConfig.CODEC), CastleStructurePiece::new);
        //registerStructure("cottage", new CottageStructureFeature(DefaultFeatureConfig.CODEC), CottageStructurePiece::new);
        //registerStructure("dioritechamp", new DioriteChampStructureFeature(DefaultFeatureConfig.CODEC), DioriteChampStructurePiece::new);
        //registerStructure("fallentree1", new FallenTree1StructureFeature(DefaultFeatureConfig.CODEC), FallenTree1StructurePiece::new);
        //registerStructure("fallentree2", new FallenTree2StructureFeature(DefaultFeatureConfig.CODEC), FallenTree2StructurePiece::new);
        //registerStructure("gigacactus", new GigaCactusStructureFeature(DefaultFeatureConfig.CODEC), GigaCactusStructurePiece::new);
        //registerStructure("gigatree", new GigaTreeStructureFeature(DefaultFeatureConfig.CODEC), GigaTreeStructurePiece::new);
        //registerStructure("nethertower", new NetherTowerStructureFeature(DefaultFeatureConfig.CODEC), NetherTowerStructurePiece::new);
        //registerStructure("rockchamp", new RockChampStructureFeature(DefaultFeatureConfig.CODEC), RockChampStructurePiece::new);
        //registerStructure("rockchamp2", new RockChamp2StructureFeature(DefaultFeatureConfig.CODEC), RockChamp2StructurePiece::new);
        //registerStructure("roundedhouse", new RoundedHouseStructureFeature(DefaultFeatureConfig.CODEC), RoundedHouseStructurePiece::new);
        //registerStructure("ruinedhouse", new RuinedHouseStructureFeature(DefaultFeatureConfig.CODEC), RuinedHouseStructurePiece::new);
        //registerStructure("ruinedhouse2", new RuinedHouse2StructureFeature(DefaultFeatureConfig.CODEC), RuinedHouse2StructurePiece::new);
        //registerStructure("smallhouse", new SmallHouseStructureFeature(DefaultFeatureConfig.CODEC), SmallHouseStructurePiece::new);
        //registerStructure("sprucetower", new SpruceTowerStructureFeature(DefaultFeatureConfig.CODEC), SpruceTowerStructurePiece::new);
        //registerStructure("tentgreen", new TentGreenStructureFeature(DefaultFeatureConfig.CODEC), TentGreenStructurePiece::new);
        //registerStructure("tentred", new TentRedStructureFeature(DefaultFeatureConfig.CODEC), TentRedStructurePiece::new);
        //registerStructure("wandercamp", new WanderCampStructureFeature(DefaultFeatureConfig.CODEC), WanderCampStructurePiece::new);
        //registerStructure("windmill", new WindMillStructureFeature(DefaultFeatureConfig.CODEC), WindMillStructurePiece::new);
        //registerStructure("yellowteepee", new YellowTeepeeStructureFeature(DefaultFeatureConfig.CODEC), YellowTeepeeStructurePiece::new);
    }

    public static void registerStructure(String structureName, StructureFeature<DefaultFeatureConfig> structureFeature, StructurePieceType piece) {
        final ConfiguredStructureFeature<?, ?> configuredStructureFeature = structureFeature.configure(DefaultFeatureConfig.DEFAULT);

        Registry.register(Registry.STRUCTURE_PIECE, Util.id(structureName + "_piece"), piece);

        FabricStructureBuilder.create(Util.id(structureName + "_structure"), structureFeature)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                Util.id(structureName + "_structure"));

        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), configuredStructureFeature);

        BiomeModifications.addStructure(BiomeSelectors.all(), myConfigured);
    }
}
