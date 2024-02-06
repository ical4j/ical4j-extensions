package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * A concept typically applied to PARTICIPANT objects when embedded metadata for contributors is required.
 */
public class ContributorType extends ImmutableConcept {

    public enum Urn {
        Reporter("urn:ical4j:concept:contributor:reporter"),

        Assignee("urn:ical4j:concept:contributor:assignee");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ContributorType REPORTER = new ContributorType(Urn.Reporter);

    public static final ContributorType ASSIGNEE = new ContributorType(Urn.Assignee);

    public ContributorType(Urn urn) {
        super(urn.getUri());
    }
}
