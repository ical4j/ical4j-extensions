package net.fortuna.ical4j.extensions.strategy.vevent;

import net.fortuna.ical4j.model.component.VEvent;

import java.time.ZonedDateTime;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;

public class Appointment {

    private ZonedDateTime start;

    public Appointment start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public VEvent apply(VEvent vEvent) {
        vEvent.with(DTSTART, start);
        return vEvent;
    }
}
