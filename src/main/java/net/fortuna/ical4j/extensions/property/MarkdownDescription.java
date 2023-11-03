package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.StyledDescription;

public class MarkdownDescription extends StyledDescription {

    public MarkdownDescription(String value) {
        super(value);
        add(Value.TEXT);
        add(new FmtType("text/markdown"));
    }
}
