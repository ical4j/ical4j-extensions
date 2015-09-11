package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class LastModified extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "LAST-MODIFIED";

    private String value;

    public LastModified() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public LastModified(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<LastModified> {

        public LastModified createProperty() {
            return new LastModified();
        }

        public LastModified createProperty(ParameterList parameters, String value) {
            LastModified property = new LastModified(parameters, value);
            return property;
        }
    }
}
