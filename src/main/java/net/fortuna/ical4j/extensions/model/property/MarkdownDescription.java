package net.fortuna.ical4j.extensions.model.property;

import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.StyledDescription;

/**
 * Represents a description in Markdown format.
 * <p>
 * This class extends {@link StyledDescription} to provide a description
 * that is specifically formatted as Markdown.
 * </p>
 *
 * @see StyledDescription
 */
public class MarkdownDescription extends StyledDescription {

    public MarkdownDescription(String value) {
        super(value);
        add(Value.TEXT);
        add(new FmtType("text/markdown"));
    }
}
