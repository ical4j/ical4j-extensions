package net.fortuna.ical4j.extensions.strategy.observance;

import net.fortuna.ical4j.extensions.model.property.Repeats;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.DateList;
import net.fortuna.ical4j.model.DateTimePropertyModifiers;
import net.fortuna.ical4j.model.DescriptivePropertyModifiers;
import net.fortuna.ical4j.model.RecurrencePropertyModifiers;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates an (optionally recurring) date-based {@link VEvent} representing a public holiday or
 * other observance.
 * <p>
 * Includes observances from <a href="https://www.un.org/en/observances/list-days-weeks"> UN International Days</a>.
 */
public class Observance extends AbstractStrategy<VEvent> {

    private String title;

    private Temporal start;

    private Temporal end;

    private final List<LocalDate> dates = new ArrayList<>();

    private Repeats<LocalDate> schedule;

    public Observance title(String title) {
        this.title = title;
        return this;
    }

    public Observance start(Temporal date) {
        this.start = date;
        return this;
    }

    public Observance end(Temporal date) {
        this.end = date;
        return this;
    }

    public Observance date(LocalDate date) {
        dates.add(date);
        return this;
    }

    public Observance repeats(Repeats<LocalDate> schedule) {
        this.schedule = schedule;
        return this;
    }

    @Override
    public VEvent get() {
        VEvent vEvent = getPrototype().isPresent() ? getPrototype().get().copy() : new VEvent();
        vEvent.replace(ImmutableTransp.TRANSPARENT);
        vEvent.with(DescriptivePropertyModifiers.SUMMARY, title);
        vEvent.with(DateTimePropertyModifiers.DTSTART, start);
        vEvent.with(DateTimePropertyModifiers.DTEND, end);
        vEvent.with(RecurrencePropertyModifiers.RRULE, schedule);
        vEvent.with(RecurrencePropertyModifiers.RDATE, new DateList<>(dates));
        return vEvent;
    }
}
