package cf.revstudios.revsbetterstructures;

import com.google.common.collect.Lists;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class RevsRegistryPredicate extends RegistryPredicateArgumentType<ConfiguredStructureFeature<?, ?>> {
    public RevsRegistryPredicate() {
        super(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        Object var4 = context.getSource();
        if (var4 instanceof CommandSource commandSource) {
            CompletableFuture<Suggestions> futureSuggestions = commandSource.listIdSuggestions(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, CommandSource.SuggestedIdType.ALL, builder, context);
            try {
                Suggestions suggestions = futureSuggestions.get();
                return CompletableFuture.supplyAsync(() -> {
                    Collection<Suggestion> toSend = Lists.newArrayList();
                    for (var suggestion : suggestions.getList()) {
                        if (suggestion.getText().contains("revsbetterstructures:")) {
                            String newText = suggestion.getText();
                            //newText = newText.replace("revsbetterstructures:", "")
                            toSend.add(new Suggestion(suggestion.getRange(), newText, suggestion.getTooltip()));
                        }
                    }
                    return Suggestions.create("revslocate", toSend);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.listSuggestions(context, builder);
    }
}