package net.fortuna.ical4j.extensions.strategy.vjournal;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;

public class Timesheet extends AbstractStrategy<VJournal> {

    @Override
    public VJournal get() {
        VJournal vJournal = getPrototype().isPresent() ? getPrototype().get().copy() : new VJournal();
        return vJournal;
    }
}
