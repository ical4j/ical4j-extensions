package net.fortuna.ical4j.extensions.model.participant;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.property.CalendarAddress;
import net.fortuna.ical4j.model.property.ParticipantType;
import net.fortuna.ical4j.model.property.StructuredData;
import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.property.CalAdrUri;
import net.fortuna.ical4j.vcard.property.Uid;

/**
 * Abstract base class for roles in a calendar event.
 * This class extends the Participant class and provides constructors
 * to initialize a role with a participant type and optionally with
 * an entity representing a card.
 */
public abstract class AbstractRole extends Participant {

    public AbstractRole(ParticipantType participantType) {
        add(participantType);
    }

    public AbstractRole(Entity card, ParticipantType participantType) {
        add(participantType);

        //XXX: if card is group (i.e. has members) add all members instead..
        Uid uid = card.getRequiredProperty(PropertyName.UID);
        add(new net.fortuna.ical4j.model.property.Uid(uid.getValue()));

        CalAdrUri calAdrUri = card.getRequiredProperty(PropertyName.CALADRURI.toString());
        add(new CalendarAddress(calAdrUri.getUri()));

        add(new StructuredData(card.toString().getBytes())
                .withParameter(new FmtType("text/vcard")).getFluentTarget());
    }
}
