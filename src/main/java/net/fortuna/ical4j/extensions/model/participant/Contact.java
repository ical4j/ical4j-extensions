package net.fortuna.ical4j.extensions.model.participant;

import net.fortuna.ical4j.model.property.immutable.ImmutableParticipantType;
import net.fortuna.ical4j.vcard.Entity;

/**
 * Represents a contact role in a calendar event.
 * This class extends the AbstractRole class and is used
 * to define a contact participant type.
 * <p>
 * See also <a href="https://www.iana.org/assignments/participant-types/participant-types.xhtml#contact">Participant Types</a>
 * </p>
 */
public class Contact extends AbstractRole {

    public Contact() {
        super(ImmutableParticipantType.CONTACT);
    }

    public Contact(Entity entity) {
        super(entity, ImmutableParticipantType.CONTACT);
    }
}
