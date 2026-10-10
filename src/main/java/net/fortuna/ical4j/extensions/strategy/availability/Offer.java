package net.fortuna.ical4j.extensions.strategy.availability;

import net.fortuna.ical4j.extensions.model.concept.AvailabilityType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.Available;
import net.fortuna.ical4j.model.component.VAvailability;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;

import java.time.temporal.Temporal;

/**
 * Represents an offer of availability, published for a fixed period during which others may book time.
 */
public class Offer extends AbstractStrategy<VAvailability, Offer> {

    private Temporal offerStart;

    private Temporal offerEnd;

    public Offer offerStart(Temporal offerStart) {
        this.offerStart = offerStart;
        return this;
    }
    public Offer offerEnd(Temporal offerEnd) {
        this.offerEnd = offerEnd;
        return this;
    }

    @Override
    public VAvailability get() {
        VAvailability offer = newInstance(VAvailability::new).replace(AvailabilityType.OFFER);
        offer.add((Available) new Available().add(new DtStart<>(offerStart)).add(new DtEnd<>(offerEnd)));
        return offer;
    }
}
