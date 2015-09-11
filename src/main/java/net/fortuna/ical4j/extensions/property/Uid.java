package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Uid extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "UID";

    private String value;

    public Uid() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Uid(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<Uid> {
        public Factory() {
            super(PROPERTY_NAME);
        }

        public Uid createProperty() {
            return new Uid();
        }

        public Uid createProperty(ParameterList parameters, String value) {
            Uid property = new Uid(parameters, value);
            return property;
        }
    }
}
