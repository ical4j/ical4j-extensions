package net.fortuna.ical4j.extensions.model.concept;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.Concept;
import net.fortuna.ical4j.model.property.ImmutableProperty;

import java.net.URI;

/**
 * Base class for immutable definition of calendar component types.
 */
public class ImmutableConcept extends Concept implements ImmutableProperty {

    public ImmutableConcept(URI uri) {
        super(uri);
    }

    @Override
    public void setValue(String aValue) {
        ImmutableProperty.super.setValue(aValue);
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
