package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.Content;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactory;
import net.fortuna.ical4j.validate.ValidationException;

/**
 * Created by fortuna on 11/09/15.
 */
public class Name extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "NAME";

    private String value;

    public Name() {
        super(PROPERTY_NAME, new Factory());
    }

    public Name(ParameterList params, String value) {
        super(PROPERTY_NAME, params, new Factory());
        setValue(value);
    }

    @Override
    public void setValue(String aValue) {
        this.value = aValue;
    }

    @Override
    public void validate() throws ValidationException {

    }

    @Override
    public String getValue() {
        return value;
    }

    public static class Factory extends Content.Factory implements PropertyFactory<Name> {
        public Factory() {
            super(PROPERTY_NAME);
        }

        public Name createProperty() {
            return new Name();
        }

        public Name createProperty(ParameterList parameters, String value) {
            Name property = new Name(parameters, value);
            return property;
        }
    }
}
