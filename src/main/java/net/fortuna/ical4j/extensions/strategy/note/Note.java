package net.fortuna.ical4j.extensions.strategy.note;

import net.fortuna.ical4j.extensions.model.concept.NoteType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.ChangeManagementPropertyModifiers;
import net.fortuna.ical4j.model.RelationshipPropertyModifiers;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.util.RandomUidGenerator;

import java.time.Instant;
import java.time.LocalDate;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.SUMMARY;

/**
 * A Note is an independent journal item that may or may not refer to one or more other
 * referencable items. A Note may be location-specific in addition to temporal.
 */
public class Note extends AbstractStrategy<VJournal, Note> {

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
        VJournal note = newInstance(VJournal::new).replace(NoteType.NOTE);
        note.with(ChangeManagementPropertyModifiers.DTSTAMP, Instant.now());
        note.with(RelationshipPropertyModifiers.UID, new RandomUidGenerator().generateUid());
        note.with(SUMMARY, title);
        note.with(DTSTART, date);
        if (location != null) {
            note.add(location);
        }
        return note;
    }
}
