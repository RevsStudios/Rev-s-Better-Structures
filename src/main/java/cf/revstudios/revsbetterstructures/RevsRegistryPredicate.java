package cf.revstudios.revsbetterstructures;

import com.google.common.collect.Lists;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.datafixers.util.Either;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.structure.Structure;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class RevsRegistryPredicate extends RegistryPredicateArgumentType<Structure> {
    public RevsRegistryPredicate() {
        super(Registry.STRUCTURE_KEY);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        S var4 = context.getSource();
        if (var4 instanceof CommandSource commandSource) {
            CompletableFuture<Suggestions> futureSuggestions = commandSource.listIdSuggestions(Registry.STRUCTURE_KEY, CommandSource.SuggestedIdType.ALL, builder, context);
            Collection<Suggestion> toSend = Lists.newArrayList();
            futureSuggestions.thenRun(() -> {
                for (var suggestion : futureSuggestions.join().getList()) {
                    if (suggestion.getText().contains("revsbetterstructures:")) {
                        String newText = suggestion.getText();
                        newText = newText.replace("revsbetterstructures:", "");
                        toSend.add(new Suggestion(suggestion.getRange(), newText, suggestion.getTooltip()));
                    }
                }
            });
            return CompletableFuture.supplyAsync(() -> Suggestions.create("revslocate", toSend));
        }
        return super.listSuggestions(context, builder);
    }

    @Override
    public RegistryPredicate<Structure> parse(StringReader stringReader) throws CommandSyntaxException {
        Identifier identifier = Identifier.fromCommandInput(stringReader);
        identifier = new Identifier(RevsBetterStructures.MODID, identifier.getPath());
        return new RegistryKeyBased<>(RegistryKey.of(Registry.STRUCTURE_KEY, identifier));
    }

    record RegistryKeyBased<T>(RegistryKey<T> key) implements RegistryPredicate<T> {
        @Override
        public Either<RegistryKey<T>, TagKey<T>> getKey() {
            return Either.left(this.key);
        }

        @Override
        public <E> Optional<RegistryPredicate<E>> tryCast(RegistryKey<? extends Registry<E>> registryRef) {
            return this.key.tryCast(registryRef).map(RevsRegistryPredicate.RegistryKeyBased::new);
        }

        @Override
        public boolean test(RegistryEntry<T> registryEntry) {
            return registryEntry.matchesKey(this.key);
        }

        @Override
        public String asString() {
            return this.key.getValue().toString();
        }
    }
}