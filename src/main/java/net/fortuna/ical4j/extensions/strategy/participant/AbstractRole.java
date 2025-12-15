package net.fortuna.ical4j.extensions.strategy.participant;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
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
public abstract class AbstractRole<T extends AbstractStrategy<Participant, T>> extends AbstractStrategy<Participant, T> {

    private final ParticipantType participantType;

    private Entity entity;

    public AbstractRole(ParticipantType participantType) {
        this.participantType = participantType;
    }

    public T entity(Entity entity) {
        this.entity = entity;
        //noinspection unchecked
        return (T) this;
    }

    @Override
    public Participant get() {
        Participant role = newInstance(Participant::new);
        role.add(participantType);
        if (entity != null) {
            //XXX: if card is group (i.e. has members) add all members instead..
            Uid uid = entity.getRequiredProperty(PropertyName.UID);
            role.add(new net.fortuna.ical4j.model.property.Uid(uid.getValue()));

            CalAdrUri calAdrUri = entity.getRequiredProperty(PropertyName.CALADRURI.toString());
            role.add(new CalendarAddress(calAdrUri.getUri()));

            role.add(new StructuredData(entity.toString().getBytes())
                    .withParameter(new FmtType("text/vcard")).getFluentTarget());

        }
        return role;
    }
}
