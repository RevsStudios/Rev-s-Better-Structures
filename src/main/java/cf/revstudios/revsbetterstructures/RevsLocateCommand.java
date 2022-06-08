package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.mixin.LocateCommandInvoker;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class RevsLocateCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("revslocate").requires(player -> player.hasPermissionLevel(2))
                .then(argument("structure", new RevsRegistryPredicate())
                        .executes(RevsLocateCommand::execute)));
    }

    private static int execute(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        RegistryPredicateArgumentType.RegistryPredicate<ConfiguredStructureFeature<?, ?>> structureFeature = RevsRegistryPredicate.getConfiguredStructureFeaturePredicate(context, "structure");
        return LocateCommandInvoker.invokeExecute(context.getSource(), structureFeature);
    }
}
