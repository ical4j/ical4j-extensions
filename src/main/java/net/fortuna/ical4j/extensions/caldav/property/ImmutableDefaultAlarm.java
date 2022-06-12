package net.fortuna.ical4j.extensions.caldav.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.immutable.ImmutableProperty;

final class ImmutableDefaultAlarm extends DefaultAlarm implements ImmutableProperty {
    public static final DefaultAlarm TRUE = new ImmutableDefaultAlarm("TRUE");
    public static final DefaultAlarm FALSE = new ImmutableDefaultAlarm("FALSE");
    private static final long serialVersionUID = -2054338254L;

    ImmutableDefaultAlarm(String value) {
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
