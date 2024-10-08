package net.fortuna.ical4j.extensions.model.property;

import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.StyledDescription;

public class HtmlDescription extends StyledDescription {

    public HtmlDescription(String value) {
        super(value);
        add(Value.TEXT);
        add(new FmtType("text/html"));
    }
}
