package net.fortuna.ical4j.extensions.strategy.vjournal;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.Status;
import net.fortuna.ical4j.model.property.StyledDescription;
import net.fortuna.ical4j.vcard.Entity;

/**
 * Used to identify potential issues relating to a project.
 */
public class Risk extends AbstractStrategy<VJournal> {

    private String title;

    private StyledDescription description;

    private StyledDescription impact;

    private StyledDescription mitigation;

    private Entity owner;

    private Status status;

    @Override
    public VJournal get() {
        VJournal vJournal = getPrototype().isPresent() ? getPrototype().get().copy() : new VJournal();
        vJournal.replace(status);
        return vJournal;
    }
}
