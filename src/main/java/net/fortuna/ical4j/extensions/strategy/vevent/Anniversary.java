package net.fortuna.ical4j.extensions.strategy.vevent;

import net.fortuna.ical4j.extensions.model.property.Repeats;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.LocalDate;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.RecurrencePropertyModifiers.RRULE;

/**
 * Creates a recurring {@link VEvent} representing a birthday/anniversary, etc.
 */
public class Anniversary extends AbstractStrategy<VEvent> {

    private Repeats<?> schedule;

    private LocalDate date;

    public Anniversary withRepeats(Repeats<?> schedule) {
        this.schedule = schedule;
        return this;
    }

    public Anniversary withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public VEvent get() {
        VEvent anniversary = getPrototype().isPresent() ? getPrototype().get().copy() : new VEvent();
        anniversary.with(DTSTART, date);
        anniversary.with(RRULE, schedule);
        return anniversary;
    }
}
