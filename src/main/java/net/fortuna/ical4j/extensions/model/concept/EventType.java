package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * Concrete types for event-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VEvent} components to group and/or filter similar event types.
 */
public class EventType extends ImmutableConcept {

    public static final EventType EVENT = new EventType(Id.Event);

    public static final EventType MEETING = new EventType(Id.Meeting);

    public static final EventType APPOINTMENT = new EventType(Id.Appointment);

    public static final EventType SEMINAR = new EventType(Id.Seminar);

    public static final EventType CONFERENCE = new EventType(Id.Conference);

    public static final EventType PERFORMANCE = new EventType(Id.Performance);

    public enum Id {
        Appointment("semcal:concept:event:appointment"),
        Conference("semcal:concept:event:conference"),
        Event("semcal:concept:event"),
        Fixture("semcal:concept:event:fixture"),
        Meeting("semcal:concept:event:meeting"),
        Performance("semcal:concept:event:performance"),
        Seminar("semcal:concept:event:seminar");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public EventType(Id id) {
        super(id.getUri());
    }
}
