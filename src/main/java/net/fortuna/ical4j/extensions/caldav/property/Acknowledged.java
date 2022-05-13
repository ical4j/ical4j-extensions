/**
 * Copyright (c) 2012, Ben Fortuna
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * <p/>
 * o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * <p/>
 * o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * <p/>
 * o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 * <p/>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.extensions.caldav.property;

import net.fortuna.ical4j.model.Content;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.PropertyFactory;
import net.fortuna.ical4j.model.property.UtcProperty;

import java.text.ParseException;

/**
 * This class supports the new ACKNOWLEDGED property, as defined in draft-daboo-valarm-extensions
 *
 * @author probert
 * @see <a href="http://tools.ietf.org/html/draft-daboo-valarm-extensions-04">draft-daboo-valarm-extensions-04</a>
 * @deprecated Use {@link net.fortuna.ical4j.model.property.Acknowledged} instead.
 */
@Deprecated
public class Acknowledged extends UtcProperty {

    private static final long serialVersionUID = 2182103734645261668L;

    public static final String PROPERTY_NAME = "ACKNOWLEDGED";

    /**
     * Default constructor. Initialises the dateTime value to the time of instantiation.
     */
    public Acknowledged() {
        super(PROPERTY_NAME, new Factory());
    }

    /**
     * @param aValue a string representation of a DTSTAMP value
     * @throws ParseException if the specified value is not a valid representation
     */
    public Acknowledged(final String aValue) throws ParseException {
        this(new ParameterList(), aValue);
    }

    /**
     * @param aList  a list of parameters for this component
     * @param aValue a value string for this component
     * @throws ParseException where the specified value string is not a valid date-time/date representation
     */
    public Acknowledged(final ParameterList aList, final String aValue)
            throws ParseException {
        super(PROPERTY_NAME, aList, new Factory());
        setValue(aValue);
    }

    /**
     * @param aDate a date representing a date-time
     */
    public Acknowledged(final DateTime aDate) {
        super(PROPERTY_NAME, new Factory());
        // time must be in UTC..
        aDate.setUtc(true);
        setDate(aDate);
    }

    /**
     * @param aList a list of parameters for this component
     * @param aDate a date representing a date-time
     */
    public Acknowledged(final ParameterList aList, final DateTime aDate) {
        super(PROPERTY_NAME, aList, new Factory());
        // time must be in UTC..
        aDate.setUtc(true);
        setDate(aDate);
    }

    public static class Factory extends Content.Factory implements PropertyFactory<Acknowledged> {
        public Factory() {
            super(PROPERTY_NAME);
        }

        public Acknowledged createProperty() {
            return new Acknowledged();
        }

        public Acknowledged createProperty(ParameterList parameters, String value) throws ParseException {
            return new Acknowledged(parameters, value);
        }
    }
}
