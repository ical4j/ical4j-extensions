package net.fortuna.ical4j.extensions.model.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.ImmutableProperty;
import net.fortuna.ical4j.model.property.PercentComplete;

/**
 * An immutable subclass of {@link PercentComplete} that defines common property values.
 */
public class CompletionStatus extends PercentComplete implements ImmutableProperty {

    public static final CompletionStatus NOT_STARTED = new CompletionStatus(0);

    public static final CompletionStatus COMPLETED = new CompletionStatus(100);

    public CompletionStatus(int aPercentage) {
        super(aPercentage);
    }

    @Override
    public <T extends Property> T add(Parameter parameter) {
        return ImmutableProperty.super.add(parameter);
    }

    @Override
    public <T extends Property> T remove(Parameter parameter) {
        return ImmutableProperty.super.remove(parameter);
    }

    @Override
    public <T extends Property> T removeAll(String... parameterName) {
        return ImmutableProperty.super.removeAll(parameterName);
    }

    @Override
    public <T extends Property> T replace(Parameter parameter) {
        return ImmutableProperty.super.replace(parameter);
    }
}
