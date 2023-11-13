package net.fortuna.ical4j.extensions.participant;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.property.CalendarAddress;
import net.fortuna.ical4j.model.property.ParticipantType;
import net.fortuna.ical4j.model.property.StructuredData;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.CalAdrUri;
import net.fortuna.ical4j.vcard.property.Uid;

public abstract class AbstractRole extends Participant {

    public AbstractRole(ParticipantType participantType) {
        add(participantType);
    }

    public AbstractRole(VCard card, ParticipantType participantType) {
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
