/**
 * Copyright (c) 2012, Ben Fortuna
 * All rights reserved.
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * <p>
 * o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * <p>
 * o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * <p>
 * o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 * <p>
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
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactory;
import net.fortuna.ical4j.validate.ValidationException;
import net.fortuna.ical4j.validate.ValidationResult;

/**
 * New property as defined in a RFC draft
 *
 * @see <a href="http://tools.ietf.org/html/draft-daboo-valarm-extensions-04">draft-daboo-valarm-extensions-04</a>
 *
 * @author probert
 *
 */
public class Proximity extends Property {

    private static final long serialVersionUID = 2182103734645261668L;

    public static final String PROPERTY_NAME = "PROXIMITY";

    private String value;

    public static final Proximity ARRIVE = new ImmutableProximity("ARRIVE");

    public static final Proximity DEPART = new ImmutableProximity("DEPART");

    public Proximity() {
        super(PROPERTY_NAME, new Factory());
    }

    public Proximity(ParameterList aList, String value) {
        super(PROPERTY_NAME, aList, new Factory());
        setValue(value);
    }

    @Override
    public void setValue(String aValue) {
        this.value = aValue;
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        return ValidationResult.EMPTY;
    }

    @Override
    public String getValue() {
        return value;
    }

    private static final class ImmutableProximity extends Proximity {
        private static final long serialVersionUID = -2054338254L;

        private ImmutableProximity(String value) {
            super(new ParameterList(true), value);
        }

        public void setValue(String aValue) {
            throw new UnsupportedOperationException("Cannot modify constant instances");
        }
    }

    public static class Factory extends Content.Factory implements PropertyFactory<Proximity> {

        private static final long serialVersionUID = 2099427445505899578L;

        public Factory() {
            super(PROPERTY_NAME);
        }

        public Proximity createProperty() {
            return new Proximity();
        }

        public Proximity createProperty(ParameterList parameters, String value) {
            Proximity property = null;
            if (DEPART.getValue().equals(value)) {
                property = DEPART;
            } else {
                property = new Proximity(parameters, value);
            }
            return property;
        }
    }

}
