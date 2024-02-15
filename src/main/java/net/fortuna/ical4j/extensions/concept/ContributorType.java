package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * A concept typically applied to PARTICIPANT objects when embedded metadata for contributors is required.
 */
public class ContributorType extends ImmutableConcept {

    public enum Id {
        Reporter("ical4j:concept:contributor:reporter"),

        Assignee("ical4j:concept:contributor:assignee");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ContributorType REPORTER = new ContributorType(Id.Reporter);

    public static final ContributorType ASSIGNEE = new ContributorType(Id.Assignee);

    public ContributorType(Id id) {
        super(id.getUri());
    }
}
