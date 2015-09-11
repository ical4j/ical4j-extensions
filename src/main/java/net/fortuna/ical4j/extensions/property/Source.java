package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.*;

/**
 * Created by fortuna on 11/09/15.
 */
public class Source extends Property {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "SOURCE";

    private String value;

    public Source() {
        super(PROPERTY_NAME, PropertyFactoryImpl.getInstance());
    }

    public Source(ParameterList params, String value) {
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

    public static class Factory extends Content.Factory implements PropertyFactory<Source> {

        public Source createProperty() {
            return new Source();
        }

        public Source createProperty(ParameterList parameters, String value) {
            Source property = new Source(parameters, value);
            return property;
        }
    }
}
