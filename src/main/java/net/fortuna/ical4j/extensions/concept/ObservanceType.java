package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

public class ObservanceType extends ImmutableConcept {

    public enum Urn {
        Observance("urn:ical4j:concept:observance"),

        Subscription("urn:ical4j:concept:observance:subscription"),

        Reservation("urn:ical4j:concept:observance:reservation");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ObservanceType OBSERVANCE = new ObservanceType(Urn.Observance);

    /**
     * Used to describe a period of time that one or more subscribers are "interested"
     * in a linked entity or resource. The definition of interested, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final ObservanceType SUBSCRIPTION = new ObservanceType(Urn.Subscription);

    /**
     * Exclusive reservation of a resource or entity.
     */
    public static final ObservanceType RESERVATION = new ObservanceType(Urn.Reservation);

    public ObservanceType(Urn urn) {
        super(urn.getUri());
    }
}
