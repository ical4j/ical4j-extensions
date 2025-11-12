package net.fortuna.ical4j.extensions.strategy.event;

import net.fortuna.ical4j.extensions.model.concept.EventType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.ZonedDateTime;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;

/**
 * An appointment is a scheduled event that typically involves a specific time and place.
 * It can be used to represent meetings, consultations, or other time-bound engagements.
 */
public class Appointment extends AbstractStrategy<VEvent, Appointment> {

    private ZonedDateTime start;

    public Appointment start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    @Override
    public VEvent get() {
        VEvent vEvent = newInstance(VEvent::new).replace(EventType.APPOINTMENT);
        vEvent.with(DTSTART, start);
        return vEvent;
    }
}
