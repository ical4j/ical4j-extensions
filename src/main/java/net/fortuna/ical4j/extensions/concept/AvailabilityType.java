package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

public class AvailabilityType extends ImmutableConcept {

    public enum Id {
        Availability("semcal:concept:availability"),

        Roster("semcal:concept:availability:roster"),

        Reservable("semcal:concept:availability:reservable"),

        Invitation("semcal:concept:availability:invitation"),

        Offer("semcal:concept:availability:offer");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final AvailabilityType AVAILABILITY = new AvailabilityType(Id.Availability);

    /**
     * A Roster is used to schedule availability for individuals.
     */
    public static final AvailabilityType ROSTER = new AvailabilityType(Id.Roster);

    /**
     * A Reservable provides availability for a finite resource such as physical assets.
     */
    public static final AvailabilityType RESERVABLE = new AvailabilityType(Id.Reservable);

    /**
     * Defines availability period to subscribe to
     * a linked entity or resource. The definition of subscribe, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final AvailabilityType INVITATION = new AvailabilityType(Id.Invitation);

    /**
     * See: <a href="https://schema.org/Offer">schema.org: Offer</a>
     */
    public static final AvailabilityType OFFER = new AvailabilityType(Id.Offer);

    public AvailabilityType(Id id) {
        super(id.getUri());
    }
}
