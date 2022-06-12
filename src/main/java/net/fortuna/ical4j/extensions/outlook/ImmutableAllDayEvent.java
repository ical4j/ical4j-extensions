package net.fortuna.ical4j.extensions.outlook;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.immutable.ImmutableProperty;

public class ImmutableAllDayEvent extends AllDayEvent implements ImmutableProperty {

    public static final AllDayEvent FALSE = new AllDayEvent(new ParameterList(), "FALSE");

    public ImmutableAllDayEvent() {
    }

    public ImmutableAllDayEvent(ParameterList aList, String value) {
        super(aList, value);
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
