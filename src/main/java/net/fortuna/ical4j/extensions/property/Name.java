package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Name extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "NAME";

    private String value;

    public Name() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Name(ParameterList params, String value) {
        super(PROPERTY_NAME, params, PropertyFactoryImpl.getInstance());
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

        public Name createProperty() {
            return new Name();
        }

        public Name createProperty(ParameterList parameters, String value) {
            Name property = new Name(parameters, value);
            return property;
        }
    }
}
