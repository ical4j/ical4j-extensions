package net.fortuna.ical4j.extensions.strategy.vevent;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.ZonedDateTime;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;

public class Appointment extends AbstractStrategy<VEvent> {

    private ZonedDateTime start;

    public Appointment start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    @Override
    public VEvent get() {
        VEvent vEvent = getPrototype().isPresent() ? getPrototype().get().copy() : new VEvent();
        vEvent.with(DTSTART, start);
        return vEvent;
    }
}
