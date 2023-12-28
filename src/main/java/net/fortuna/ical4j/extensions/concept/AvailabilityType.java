package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

public class AvailabilityType extends ImmutableConcept {

    public static final AvailabilityType AVAILABILITY = new AvailabilityType("https://ical4j.org/extensions/concept/availability/AVAILABILITY");

    /**
     * A Roster is used to schedule availability for individuals.
     */
    public static final AvailabilityType ROSTER = new AvailabilityType("https://ical4j.org/extensions/concept/availability/ROSTER");

    /**
     * A Reservable provides availability for a finite resource such as physical assets.
     */
    public static final AvailabilityType RESERVABLE = new AvailabilityType("https://ical4j.org/extensions/concept/availability/RESERVABLE");

    public AvailabilityType(String type) {
        super(URI.create(type));
    }
}
