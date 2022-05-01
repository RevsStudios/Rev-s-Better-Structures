package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.mixin.LocateCommandInvoker;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.datafixers.util.Either;
import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class RevsLocateCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("revslocate").requires(player -> player.hasPermissionLevel(2))
                .then(argument("structure", new RevsRegistryPredicate())
                        .executes(context -> {
                            return execute(context.getSource(), RevsRegistryPredicate.getConfiguredStructureFeaturePredicate(context, "structure"));
                        })));
    }

    private static int execute(ServerCommandSource source, RegistryPredicateArgumentType.RegistryPredicate<ConfiguredStructureFeature<?, ?>> structureFeature) {
        Registry<ConfiguredStructureFeature<?, ?>> registry = source.getWorld().getRegistryManager().get(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY);
        Either<RegistryKey<ConfiguredStructureFeature<?, ?>>, TagKey<ConfiguredStructureFeature<?, ?>>> var10000 = structureFeature.getKey();

        return LocateCommandInvoker.invokeExecute(source, structureFeature); //¯\_(ツ)_/¯
    }
}
