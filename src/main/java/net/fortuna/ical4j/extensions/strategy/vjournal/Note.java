package net.fortuna.ical4j.extensions.strategy.vjournal;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VLocation;

import java.time.LocalDate;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.SUMMARY;

/**
 * A Note is an independent journal item that may or may not refer to one or more other
 * referencable items. A Note may be location-specific in addition to temporal.
 */
public class Note extends AbstractStrategy<VJournal> {

    private String title;

    private LocalDate date;

    private VLocation location;

    public Note title(String title) {
        this.title = title;
        return this;
    }

    public Note date(LocalDate date) {
        this.date = date;
        return this;
    }

    public Note location(VLocation location) {
        this.location = location;
        return this;
    }

    @Override
    public VJournal get() {
        VJournal vJournal = getPrototype().isPresent() ? getPrototype().get().copy() : new VJournal();
        vJournal.with(SUMMARY, title);
        vJournal.with(DTSTART, date);
        vJournal.add(location);
        return vJournal;
    }
}
