package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * A concept typically applied to PARTICIPANT objects when embedded metadata for contributors is required.
 */
public class ParticipantType extends ImmutableConcept {

    public enum Id {
        Reporter("semcal:concept:contributor:reporter"),

        Assignee("semcal:concept:contributor:assignee");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ParticipantType REPORTER = new ParticipantType(Id.Reporter);

    public static final ParticipantType ASSIGNEE = new ParticipantType(Id.Assignee);

    public ParticipantType(Id id) {
        super(id.getUri());
    }
}
