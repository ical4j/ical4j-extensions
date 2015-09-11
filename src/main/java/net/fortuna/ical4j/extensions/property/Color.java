package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Color extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "COLOR";

    private String value;

    public Color() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Color(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<Color> {
        public Factory() {
            super(PROPERTY_NAME);
        }

        public Color createProperty() {
            return new Color();
        }

        public Color createProperty(ParameterList parameters, String value) {
            Color property = new Color(parameters, value);
            return property;
        }
    }
}
