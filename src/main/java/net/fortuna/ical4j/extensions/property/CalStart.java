package net.fortuna.ical4j.extensions.property;

import java.text.ParseException;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.property.UtcProperty;

/**
 * @author fortuna
 *
 */
public class CalStart extends UtcProperty {

    private static final String NAME = "X-CALSTART";
    
    public static final PropertyFactory FACTORY = new Factory();
    
    /**
     * @param factory
     */
    public CalStart(PropertyFactory factory) {
        super(NAME, factory);
    }

    /**
     * @param aList
     * @param factory
     * @throws ParseException 
     */
    public CalStart(ParameterList aList, PropertyFactory factory, String value) throws ParseException {
        super(NAME, aList, factory);
        setValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() throws ValidationException {
        // TODO Auto-generated method stub

    }

    private static class Factory implements PropertyFactory {
        
        private static final long serialVersionUID = 596282786680252116L;

        public Property createProperty(String name) {
            return new CalStart(this);
        }
        
        public Property createProperty(String name, ParameterList parameters, String value) throws ParseException {
            CalStart property = new CalStart(parameters, this, value);
            return property;
        }
    }
}
