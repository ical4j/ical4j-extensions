package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * Represents different types of observance concepts in the iCalendar extension model.
 * This class defines various observance types such as Anniversary, Observance, Reservation, and Subscription.
 * Each type is represented by a unique URI.
 *
 * @see <a href="https://semcal.org">Semantic Calendar</a>
 */
public class ObservanceType extends ImmutableConcept {

    public enum Id {

        Anniversary("semcal:concept:observance:anniversary"),
        Observance("semcal:concept:observance"),
        Reservation("semcal:concept:observance:reservation"),
        Subscription("semcal:concept:observance:subscription");


        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ObservanceType ANNIVERSARY = new ObservanceType(Id.Anniversary);

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
