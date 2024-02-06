package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for event-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VEvent} components to group and/or filter similar event types.
 */
public class EventType extends ImmutableConcept {

    public enum Urn {
        Event("urn:ical4j:concept:event"),

        Meeting("urn:ical4j:concept:event:meeting"),

        Appointment("urn:ical4j:concept:event:appointment"),

        Seminar("urn:ical4j:concept:event:seminar"),

        Conference("urn:ical4j:concept:event:conference"),

        Performance("urn:ical4j:concept:event:performance");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final EventType EVENT = new EventType(Urn.Event);

    public static final EventType MEETING = new EventType(Urn.Meeting);

    public static final EventType APPOINTMENT = new EventType(Urn.Appointment);

    public static final EventType SEMINAR = new EventType(Urn.Seminar);

    public static final EventType CONFERENCE = new EventType(Urn.Conference);

    public static final EventType PERFORMANCE = new EventType(Urn.Performance);

    public EventType(Urn urn) {
        super(urn.getUri());
    }
}
