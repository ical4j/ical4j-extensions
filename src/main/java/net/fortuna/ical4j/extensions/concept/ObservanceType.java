package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

public class ObservanceType extends ImmutableConcept {

    public enum Id {
        Observance("ical4j:concept:observance"),

        Subscription("ical4j:concept:observance:subscription"),

        Reservation("ical4j:concept:observance:reservation");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ObservanceType OBSERVANCE = new ObservanceType(Id.Observance);

    /**
     * Used to describe a period of time that one or more subscribers are "interested"
     * in a linked entity or resource. The definition of interested, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final ObservanceType SUBSCRIPTION = new ObservanceType(Id.Subscription);

    /**
     * Exclusive reservation of a resource or entity.
     */
    public static final ObservanceType RESERVATION = new ObservanceType(Id.Reservation);

    public ObservanceType(Id id) {
        super(id.getUri());
    }
}
