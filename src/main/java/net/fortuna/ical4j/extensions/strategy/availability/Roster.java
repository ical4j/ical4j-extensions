package net.fortuna.ical4j.extensions.strategy.availability;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VAvailability;

public class Roster extends AbstractStrategy<VAvailability> {

    @Override
    public VAvailability get() {
        return new VAvailability();
    }
}
