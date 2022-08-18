package net.fortuna.ical4j.extensions.caldav.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.ImmutableProperty;

final class ImmutableProximity extends Proximity implements ImmutableProperty {
    public static final Proximity ARRIVE = new ImmutableProximity("ARRIVE");
    public static final Proximity DEPART = new ImmutableProximity("DEPART");
    private static final long serialVersionUID = -2054338254L;

    ImmutableProximity(String value) {
        super(new ParameterList(), value);
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

    @Override
    public void setValue(final String aValue) {
        ImmutableProperty.super.setValue(aValue);
    }
}
