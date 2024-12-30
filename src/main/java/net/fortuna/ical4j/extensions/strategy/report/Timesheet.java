package net.fortuna.ical4j.extensions.strategy.report;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;

public class Timesheet extends AbstractStrategy<VJournal> {

    @Override
    public VJournal get() {
        VJournal vJournal = newInstance(VJournal::new);
        return vJournal;
    }
}
