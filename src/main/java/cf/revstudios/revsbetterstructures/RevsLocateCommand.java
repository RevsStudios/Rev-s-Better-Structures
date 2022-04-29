package cf.revstudios.revsbetterstructures;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import static net.minecraft.server.command.CommandManager.literal;

public class RevsLocateCommand {
    private static final SimpleCommandExceptionType ERROR_FAILED = new SimpleCommandExceptionType(new TranslatableText("commands.locate.failed"));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> literalArgumentBuilder = literal("revslocate").requires((player) -> player.hasPermissionLevel(2));
        for (ConfiguredStructureFeature<?, ?> feature : BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE) {
            Identifier id = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(feature);
            if (id.toString().contains("revsbetterstructures:")) {
                literalArgumentBuilder = literalArgumentBuilder.then(literal(id.getPath()).executes(ctx -> locate(ctx.getSource(), feature)));
            }
        }
        dispatcher.register(literalArgumentBuilder);
    }

    public static int showLocateResult(ServerCommandSource commandSource, String structureName, BlockPos sourcePos, BlockPos structurePos, String successText) {
        int distance = MathHelper.floor(dist(sourcePos.getX(), sourcePos.getZ(), structurePos.getX(), structurePos.getZ()));
        Text textComponent = Texts.bracketed(new TranslatableText("chat.coordinates", structurePos.getX(), "~", structurePos.getZ())).styled((style) -> style
                .withColor(Formatting.GREEN)
                .withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + structurePos.getX() + " ~ " + structurePos.getZ()))
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("chat.coordinates.tooltip"))));
        commandSource.sendFeedback(new TranslatableText(successText, structureName, textComponent, distance), false);
        return distance;
    }

    private static float dist(int x1, int y1, int x2, int y2) {
        int xDiff = x2 - x1;
        int yDiff = y2 - y1;
        return MathHelper.sqrt((float)(xDiff * xDiff + yDiff * yDiff));
    }

    private static int locate(ServerCommandSource commandSource, ConfiguredStructureFeature<?, ?> structure) throws CommandSyntaxException {
        BlockPos blockpos = new BlockPos(commandSource.getPosition());
        BlockPos blockpos1 = commandSource.getWorld().locateStructure(structure.feature, blockpos, 100, false);
        if (blockpos1 == null) {
            throw ERROR_FAILED.create();
        } else {
            return showLocateResult(commandSource, structure.feature.getName(), blockpos, blockpos1, "commands.locate.success");
        }
    }
}
