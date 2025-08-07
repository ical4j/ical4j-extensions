package net.fortuna.ical4j.extensions.strategy.availability;

import net.fortuna.ical4j.extensions.model.concept.AvailabilityType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VAvailability;

/**
 * Represents a roster, which is a collection of availability information for one or more individuals.
 * Rosters can be used to manage and track the availability of team members or resources.
 */
public class Roster extends AbstractStrategy<VAvailability> {

    @Override
    public VAvailability get() {
        return newInstance(VAvailability::new).replace(AvailabilityType.ROSTER);
    }
}
