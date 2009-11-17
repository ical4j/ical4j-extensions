package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactory;
import net.fortuna.ical4j.model.ValidationException;

/**
 * @author fortuna
 *
 */
public class LotusCharset extends Property {

    private static final long serialVersionUID = -3514682572599864426L;

    private static final String NAME = "X-LOTUS-CHARSET";
    
    public static final PropertyFactory FACTORY = new Factory();
    
    public static final LotusCharset UTF8 = new LotusCharset(new ParameterList(true), FACTORY, "UTF-8");
    
    private String value;
    
    /**
     * @param factory
     */
    public LotusCharset(PropertyFactory factory) {
        super(NAME, factory);
    }

    /**
     * @param aList
     * @param factory
     */
    public LotusCharset(ParameterList aList, PropertyFactory factory, String value) {
        super(NAME, aList, factory);
        setValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(String aValue) {
        this.value = aValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() throws ValidationException {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return value;
    }

    private static class Factory implements PropertyFactory {
        
        private static final long serialVersionUID = 596282786680252116L;

        public Property createProperty(String name) {
            return new LotusCharset(this);
        }
        
        public Property createProperty(String name, ParameterList parameters, String value) {
            LotusCharset property = null;
            if (UTF8.getValue().equals(value)) {
                property = UTF8;
            }
            else {
                property = new LotusCharset(parameters, this, value);
            }
            return property;
        }
    }
}
