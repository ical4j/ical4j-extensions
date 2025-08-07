package net.fortuna.ical4j.extensions.strategy.report;

import net.fortuna.ical4j.extensions.model.concept.ReportType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VJournal;

import java.time.temporal.Temporal;
import java.util.function.BiFunction;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTEND;
import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.RelationshipPropertyModifiers.RELATED_COMPONENT;

/**
 * Represents an attendance report in a calendar context.
 * This class extends the AbstractStrategy to create a VJournal component
 * with the ReportType set to ATTENDANCE.
 */
public class Attendance extends AbstractStrategy<VJournal> {

    private Participant participant;

    private VEvent context;

    private Temporal start;

    private Temporal end;

    public Attendance participant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public Attendance context(VEvent context) {
        this.context = context;
        return this;
    }

    public Attendance start(Temporal start) {
        this.start = start;
        return this;
    }

    public Attendance end(Temporal end) {
        this.end = end;
        return this;
    }

    @Override
    public VJournal get() {
        VJournal attendance = newInstance(VJournal::new).replace(ReportType.ATTENDANCE);
        attendance.with(DTSTART, start);
        attendance.with(DTEND, end);
        attendance.with(RELATED_COMPONENT, context);
        attendance.with((BiFunction<VJournal, Participant, VJournal>) (c, p) -> {
                    if (p != null) c.add(p);
                    return c;
                },
                participant);

        return attendance;
    }
}
