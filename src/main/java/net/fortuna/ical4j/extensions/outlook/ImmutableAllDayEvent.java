package net.fortuna.ical4j.extensions.outlook;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.ImmutableProperty;

/**
 * Immutable version of the AllDayEvent property.
 * This class represents an all-day event in a calendar system and is immutable.
 * It provides a predefined constant for an all-day event with a value of "FALSE".
 *
 * @see <a href="https://learn.microsoft.com/en-us/openspecs/office_standards/ms-oxocals/3f0b8c1e-2d5c-4b6f-9d7e-8f0a1b2c3d4e">MS-OXOCALS - AllDayEvent Property</a>
 */
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
