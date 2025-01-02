package net.fortuna.ical4j.extensions.strategy.event;

import net.fortuna.ical4j.extensions.model.concept.EventType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VEvent;

public class Event extends AbstractStrategy<VEvent> {

    @Override
    public VEvent get() {
        return newInstance(VEvent::new).replace(EventType.EVENT);
    }
}
