package net.fortuna.ical4j.extensions.model.participant;

import net.fortuna.ical4j.model.property.immutable.ImmutableParticipantType;
import net.fortuna.ical4j.vcard.VCard;

public class Contact extends AbstractRole {

    public Contact() {
        super(ImmutableParticipantType.CONTACT);
    }

    public Contact(VCard card) {
        super(card, ImmutableParticipantType.CONTACT);
    }
}
