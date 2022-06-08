package cf.revstudios.revsbetterstructures.mixin;

import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.server.command.LocateCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LocateCommand.class)
public interface LocateCommandInvoker {
    @Invoker
    static int invokeExecuteLocateStructure(ServerCommandSource source, RegistryPredicateArgumentType.RegistryPredicate<Structure> structureFeature) {
        throw  new AssertionError();
    }
}
