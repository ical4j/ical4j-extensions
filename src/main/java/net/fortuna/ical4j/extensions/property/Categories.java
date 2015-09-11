package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Categories extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "CATEGORIES";

    private String value;

    public Categories() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Categories(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<Categories> {
        public Factory() {
            super(PROPERTY_NAME);
        }

        public Categories createProperty() {
            return new Categories();
        }

        public Categories createProperty(ParameterList parameters, String value) {
            Categories property = new Categories(parameters, value);
            return property;
        }
    }
}
