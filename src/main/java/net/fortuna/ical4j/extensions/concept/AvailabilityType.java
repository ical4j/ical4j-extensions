package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

public class AvailabilityType extends ImmutableConcept {

    public enum Urn {
        Availability("urn:ical4j:concept:availability"),

        Roster("urn:ical4j:concept:availability:roster"),

        Reservable("urn:ical4j:concept:availability:reservable"),

        Invitation("urn:ical4j:concept:availability:invitation"),

        Offer("urn:ical4j:concept:availability:offer");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final AvailabilityType AVAILABILITY = new AvailabilityType(Urn.Availability);

    /**
     * A Roster is used to schedule availability for individuals.
     */
    public static final AvailabilityType ROSTER = new AvailabilityType(Urn.Roster);

    /**
     * A Reservable provides availability for a finite resource such as physical assets.
     */
    public static final AvailabilityType RESERVABLE = new AvailabilityType(Urn.Reservable);

    /**
     * Defines availability period to subscribe to
     * a linked entity or resource. The definition of subscribe, and resulting actions are implementation-
     * specific and not defined here.
     */
    public static final AvailabilityType INVITATION = new AvailabilityType(Urn.Invitation);

    /**
     * See: <a href="https://schema.org/Offer">schema.org: Offer</a>
     */
    public static final AvailabilityType OFFER = new AvailabilityType(Urn.Offer);

    public AvailabilityType(Urn urn) {
        super(urn.getUri());
    }
}
