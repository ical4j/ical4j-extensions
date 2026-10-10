package net.fortuna.ical4j.extensions.strategy.event;

import net.fortuna.ical4j.extensions.model.concept.EventType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VEvent;

/**
 * An event represents a significant occurrence or happening, such as a conference, concert, or festival.
 * It can be used to represent any scheduled or unscheduled event that is of interest to attendees.
 */
public class Performance extends AbstractStrategy<VEvent, Performance> {

    @Override
    public VEvent get() {
        return newInstance(VEvent::new).replace(EventType.EVENT);
    }
}
