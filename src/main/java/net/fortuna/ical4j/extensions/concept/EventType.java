package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for event-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VEvent} components to group and/or filter similar event types.
 */
public class EventType extends ImmutableConcept {

    public enum Id {
        Event("semcal:concept:event"),

        Meeting("semcal:concept:event:meeting"),

        Appointment("semcal:concept:event:appointment"),

        Seminar("semcal:concept:event:seminar"),

        Conference("semcal:concept:event:conference"),

        Performance("semcal:concept:event:performance");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final EventType EVENT = new EventType(Id.Event);

    public static final EventType MEETING = new EventType(Id.Meeting);

    public static final EventType APPOINTMENT = new EventType(Id.Appointment);

    public static final EventType SEMINAR = new EventType(Id.Seminar);

    public static final EventType CONFERENCE = new EventType(Id.Conference);

    public static final EventType PERFORMANCE = new EventType(Id.Performance);

    public EventType(Id id) {
        super(id.getUri());
    }
}
