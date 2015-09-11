package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Description extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "DESCRIPTION";

    private String value;

    public Description() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Description(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<Description> {
        public Factory() {
            super(PROPERTY_NAME);
        }

        public Description createProperty() {
            return new Description();
        }

        public Description createProperty(ParameterList parameters, String value) {
            Description property = new Description(parameters, value);
            return property;
        }
    }
}
