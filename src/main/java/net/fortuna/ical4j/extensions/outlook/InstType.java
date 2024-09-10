/**
 * Copyright (c) 2012, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
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
package net.fortuna.ical4j.extensions.outlook;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.validate.ParameterValidator;
import net.fortuna.ical4j.validate.ValidationException;
import net.fortuna.ical4j.validate.ValidationResult;

/**
 * @author fortuna
 *
 */
public class InstType extends Property {

    private static final long serialVersionUID = -3495027929173808410L;

    public static final String PROPERTY_NAME = "X-MICROSOFT-CDO-INSTTYPE";

    private String value;
    
    /**
     */
    public InstType() {
        super(PROPERTY_NAME);
    }

    /**
     * @param aList
     */
    public InstType(ParameterList aList, String value) {
        super(PROPERTY_NAME, aList);
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
    public ValidationResult validate() throws ValidationException {
        ParameterValidator.assertOneOrLess(Parameter.VALUE,
                getParameters());
        return ValidationResult.EMPTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return value;
    }

    @Override
    protected PropertyFactory<?> newFactory() {
        return new Factory();
    }

    public static class Factory extends Content.Factory implements PropertyFactory<InstType> {

        private static final long serialVersionUID = 1L;

        public Factory() {
            super(PROPERTY_NAME);
        }

        public InstType createProperty() {
            return new InstType();
        }

        public InstType createProperty(ParameterList parameters, String value) {
            return new InstType(parameters, value);
        }
    }
}
