package net.fortuna.ical4j.extensions.lotus;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.ImmutableProperty;

/**
 * Immutable version of the Charset property.
 * This class represents a character set in a calendar system and is immutable.
 * It provides a predefined constant for UTF-8 character set.
 *
 * @see <a href="https://www.ietf.org/rfc/rfc2045.txt">RFC 2045 - Multipurpose Internet Mail Extensions (MIME) Part One: Format of Internet Message Bodies</a>
 */
public class ImmutableCharset extends Charset implements ImmutableProperty {

    public static final Charset UTF8 = new ImmutableCharset(new ParameterList(), "UTF-8");

    public ImmutableCharset() {
    }

    public ImmutableCharset(ParameterList aList, String value) {
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
