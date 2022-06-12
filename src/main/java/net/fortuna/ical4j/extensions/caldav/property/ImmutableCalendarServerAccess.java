package net.fortuna.ical4j.extensions.caldav.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.immutable.ImmutableProperty;

final class ImmutableCalendarServerAccess extends CalendarServerAccess implements ImmutableProperty {
    public static final CalendarServerAccess PUBLIC = new ImmutableCalendarServerAccess("PUBLIC");
    public static final CalendarServerAccess PRIVATE = new ImmutableCalendarServerAccess("PRIVATE");
    public static final CalendarServerAccess CONFIDENTIAL = new ImmutableCalendarServerAccess("CONFIDENTIAL");
    public static final CalendarServerAccess RESTRICTED = new ImmutableCalendarServerAccess("RESTRICTED");
    private static final long serialVersionUID = -2054338254L;

    ImmutableCalendarServerAccess(String value) {
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
