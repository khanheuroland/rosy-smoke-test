package rosy.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import rosy.actions.SelectFilterSources;
import rosy.actions.SelectFilterTypes;
import rosy.ui.VaultScreen;

import java.util.function.BiFunction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterVault implements Task {
    String types;
    String sources;
    public FilterVault(String types, String sources)
    {
        this.types = types;
        this.sources = sources;
    }

    public static FilterVaultBuilder withTypes(String types)
    {
        return new FilterVaultBuilder(types);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VaultScreen.FILTER_BUTTON),
                Check.whether(!this.types.isEmpty()).andIfSo(
                        SelectFilterTypes.with(this.types)
                ),
                Check.whether(!this.sources.isEmpty()).andIfSo(
                        SelectFilterSources.with(this.sources)
                ),
                Click.on(VaultScreen.APPLY_FILTER_BUTTON)
        );
    }

    public static class FilterVaultBuilder
    {
        private String types;
        private String sources;

        public FilterVaultBuilder(String types)
        {
            this.types = types;
        }

        public FilterVaultBuilder andSources(String sources) {
            this.sources = sources;
            return this;
        }

        public FilterVault apply()
        {
            return instrumented(FilterVault.class, this.types, this.sources);
        }
    }

}
