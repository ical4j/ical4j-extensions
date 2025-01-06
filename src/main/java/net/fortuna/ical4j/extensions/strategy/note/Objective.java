package net.fortuna.ical4j.extensions.strategy.note;

import net.fortuna.ical4j.extensions.model.concept.NoteType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;

public class Objective extends AbstractStrategy<VJournal> {

    @Override
    public VJournal get() {
        VJournal objective = newInstance(VJournal::new).replace(NoteType.OBJECTIVE);
        return objective;
    }
}
