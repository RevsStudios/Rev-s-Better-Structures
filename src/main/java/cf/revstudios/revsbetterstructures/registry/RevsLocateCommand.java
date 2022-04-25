package cf.revstudios.revsbetterstructures.registry;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.gen.feature.structure.Structure;

public class RevsLocateCommand {
	private static final SimpleCommandExceptionType ERROR_FAILED = new SimpleCommandExceptionType(new TranslationTextComponent("commands.locate.failed"));

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		LiteralArgumentBuilder<CommandSource> literalargumentbuilder = Commands.literal("revslocate").requires((p_198533_0_) -> p_198533_0_.hasPermission(2));
		for (Structure<?> structureFeature : net.minecraftforge.registries.ForgeRegistries.STRUCTURE_FEATURES) {
			if (structureFeature.getRegistryName().toString().contains("revsbetterstructures:")) {
				String name = structureFeature.getRegistryName().toString().replace("revsbetterstructures:", "");
				literalargumentbuilder = literalargumentbuilder.then(Commands.literal(name).executes(ctx -> locate(ctx.getSource(), structureFeature)));
			}
		}
		dispatcher.register(literalargumentbuilder);
	}

	private static int locate(CommandSource commandSource, Structure<?> structure) throws CommandSyntaxException {
		BlockPos blockpos = new BlockPos(commandSource.getPosition());
		BlockPos blockpos1 = commandSource.getLevel().findNearestMapFeature(structure, blockpos, 100, false);
		if (blockpos1 == null) {
			throw ERROR_FAILED.create();
		} else {
			return showLocateResult(commandSource, structure.getFeatureName(), blockpos, blockpos1, "commands.locate.success");
		}
	}

	public static int showLocateResult(CommandSource commandSource, String p_241054_1_, BlockPos pos1, BlockPos pos2, String p_241054_4_) {
		int i = MathHelper.floor(dist(pos1.getX(), pos1.getZ(), pos2.getX(), pos2.getZ()));
		ITextComponent itextcomponent = TextComponentUtils.wrapInSquareBrackets(new TranslationTextComponent("chat.coordinates", pos2.getX(), "~", pos2.getZ())).withStyle((style) -> style
				.withColor(TextFormatting.GREEN)
				.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + pos2.getX() + " ~ " + pos2.getZ()))
				.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.coordinates.tooltip"))));
		commandSource.sendSuccess(new TranslationTextComponent(p_241054_4_, p_241054_1_, itextcomponent, i), false);
		return i;
	}

	private static float dist(int p_211907_0_, int p_211907_1_, int p_211907_2_, int p_211907_3_) {
		int i = p_211907_2_ - p_211907_0_;
		int j = p_211907_3_ - p_211907_1_;
		return MathHelper.sqrt((float)(i * i + j * j));
	}
}
