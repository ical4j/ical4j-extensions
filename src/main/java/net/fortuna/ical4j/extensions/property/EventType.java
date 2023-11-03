package net.fortuna.ical4j.extensions.property;

import java.net.URI;

/**
 * Concrete types for event-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VEvent} components to group and/or filter similar event types.
 */
public class EventType extends AbstractType {

    public static final EventType MEETING = new EventType("https://ical4j.org/event-types/MEETING");

    public static final EventType APPOINTMENT = new EventType("https://ical4j.org/event-types/APPOINTMENT");

    public static final EventType REMINDER = new EventType("https://ical4j.org/event-types/REMINDER");
    public static final EventType PERFORMANCE = new EventType("https://ical4j.org/event-types/PERFORMANCE");

    /**
     * Defines a transparent event used to describe a period of time that one or more subscribers are "interested"
     * in a linked entity or resource. The definition of interested, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final EventType SUBSCRIPTION = new EventType("https://ical4j.org/event-types/SUBSCRIPTION");

    /**
     * Defines a transparent event used to describe temporary permission to subscribe to
     * a linked entity or resource. The definition of subscribe, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final EventType INVITATION = new EventType("https://ical4j.org/event-types/INVITATION");

    public EventType(String type) {
        super(URI.create(type));
    }
}
