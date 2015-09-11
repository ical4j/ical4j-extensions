package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Url extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "URL";

    private String value;

    public Url() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Url(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<Url> {

        public Url createProperty() {
            return new Url();
        }

        public Url createProperty(ParameterList parameters, String value) {
            Url property = new Url(parameters, value);
            return property;
        }
    }
}
