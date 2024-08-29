package net.fortuna.ical4j.extensions.strategy.vjournal;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.Status;
import net.fortuna.ical4j.model.property.StyledDescription;
import net.fortuna.ical4j.vcard.VCard;

/**
 * Used to identify potential issues relating to a project.
 */
public class Risk {

    private String title;

    private StyledDescription description;

    private StyledDescription impact;

    private StyledDescription mitigation;

    private VCard owner;

    private Status status;

    public VJournal apply(VJournal vJournal) {
        vJournal.replace(status);
        return vJournal;
    }
}
