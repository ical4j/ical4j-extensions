package net.fortuna.ical4j.extensions.strategy.availability;

import net.fortuna.ical4j.extensions.model.concept.AvailabilityType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VAvailability;

public class Roster extends AbstractStrategy<VAvailability> {

    @Override
    public VAvailability get() {
        return newInstance(VAvailability::new).replace(AvailabilityType.ROSTER);
    }
}
