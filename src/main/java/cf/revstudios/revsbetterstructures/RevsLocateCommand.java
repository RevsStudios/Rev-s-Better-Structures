package cf.revstudios.revsbetterstructures;

import cf.revstudios.revsbetterstructures.mixin.LocateCommandInvoker;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.Structure;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class RevsLocateCommand {
    private static final DynamicCommandExceptionType INVALID_STRUCTURE = new DynamicCommandExceptionType(expected -> new LiteralMessage("Invalid structure identifier " + expected));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("revslocate").requires(player -> player.hasPermissionLevel(2))
                .then(argument("structure", new RevsRegistryPredicate())
                        .executes(RevsLocateCommand::execute)));
    }

    private static int execute(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();
        RegistryPredicateArgumentType.RegistryPredicate<Structure> structure = RegistryPredicateArgumentType.getPredicate(context, "structure", Registry.STRUCTURE_KEY, INVALID_STRUCTURE);
        return LocateCommandInvoker.invokeExecuteLocateStructure(source, structure); //¯\_(ツ)_/¯
    }
}
