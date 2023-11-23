package net.fortuna.ical4j.extensions.parameter;

import net.fortuna.ical4j.model.Content;
import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterFactory;

/**
 * <pre>
 * Parameter Name:  FILENAME
 *
 *  Purpose:  Provide filename for attachments specified with {@link net.fortuna.ical4j.model.property.Attach}.
 *
 *  Format Definition:  This property parameter is defined by the
 *  following notation:
 *
 *  infoparam = "FILENAME" "=" param-value
 *
 *  Description:  This property parameter MAY be specified on the
 *  "ATTACH" property.
 *  </pre>
 */
public class Filename extends Parameter {

    private static final long serialVersionUID = 1L;

    private static final String PARAMETER_NAME = "FILENAME";

    private final String value;

    public Filename(String value) {
        super(PARAMETER_NAME);
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static class Factory extends Content.Factory implements ParameterFactory<Filename> {
        private static final long serialVersionUID = 1L;

        public Factory() {
            super(PARAMETER_NAME);
        }

        public Filename createParameter(final String value) {
            return new Filename(value);
        }
    }
}
