package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for event-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VEvent} components to group and/or filter similar event types.
 */
public class EventType extends ImmutableConcept {

    public static final EventType EVENT = new EventType("https://ical4j.org/extensions/concept/event/EVENT");

    public static final EventType MEETING = new EventType("https://ical4j.org/extensions/concept/event/MEETING");

    public static final EventType APPOINTMENT = new EventType("https://ical4j.org/extensions/concept/event/APPOINTMENT");

    public static final EventType SEMINAR = new EventType("https://ical4j.org/extensions/concept/event/SEMINAR");

    public static final EventType CONFERENCE = new EventType("https://ical4j.org/extensions/concept/event/CONFERENCE");

    public static final EventType PERFORMANCE = new EventType("https://ical4j.org/extensions/concept/event/PERFORMANCE");

    /**
     * Defines a transparent event used to describe a period of time that one or more subscribers are "interested"
     * in a linked entity or resource. The definition of interested, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final EventType SUBSCRIPTION = new EventType("https://ical4j.org/extensions/concept/event/SUBSCRIPTION");

    /**
     * Defines a transparent event used to describe temporary permission to subscribe to
     * a linked entity or resource. The definition of subscribe, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final EventType INVITATION = new EventType("https://ical4j.org/extensions/concept/event/INVITATION");

    /**
     * See: <a href="https://schema.org/Offer">schema.org: Offer</a>
     */
    public static final EventType OFFER = new EventType("https://ical4j.org/extensions/concept/event/OFFER");

    public EventType(String type) {
        super(URI.create(type));
    }
}
