package net.fortuna.ical4j.extensions.strategy.event;

import net.fortuna.ical4j.extensions.model.concept.EventType;
import net.fortuna.ical4j.extensions.model.property.Repeats;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.*;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.vcard.Entity;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

import static net.fortuna.ical4j.extensions.strategy.event.VEventPropertyModifiers.*;
import static net.fortuna.ical4j.model.ChangeManagementPropertyModifiers.DTSTAMP;
import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DURATION;
import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.SUMMARY;
import static net.fortuna.ical4j.model.RecurrencePropertyModifiers.RRULE;
import static net.fortuna.ical4j.model.RelationshipPropertyModifiers.UID;

/**
 * Creates a {@link VEvent} representing a meeting of one or more attendees.
 */
public class Meeting extends AbstractStrategy<VEvent> {

    private ZonedDateTime start;

    private TemporalAmount duration;

    private Entity organizer;

    private Uid uid;

    private String summary;

    private String description;

    private Participant chair;

    private final List<Participant> required = new ArrayList<>();

    private final List<Participant> optional = new ArrayList<>();

    private Repeats<ZonedDateTime> repeats;

    private VLocation location;

    private final List<VAlarm> notifications = new ArrayList<>();

    private VToDo agenda;

    private VResource conference;

    private VResource recording;

    private VResource transcript;

    public Meeting organizer(Entity entity) {
        this.organizer = entity;
        return this;
    }

    public Meeting start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public Meeting duration(TemporalAmount duration) {
        this.duration = duration;
        return this;
    }

    public Meeting required(Participant participant) {
        required.add(participant);
        return this;
    }

    public Meeting optional(Participant participant) {
        optional.add(participant);
        return this;
    }

    public Meeting chair(Participant participant) {
        this.chair = participant;
        return this;
    }

    public Meeting repeats(Repeats<ZonedDateTime> repeats) {
        this.repeats = repeats;
        return this;
    }

    public Meeting location(VLocation location) {
        this.location = location;
        return this;
    }

    public Meeting notification(VAlarm notification) {
        this.notifications.add(notification);
        return this;
    }

    public Meeting agenda(VToDo agenda) {
        this.agenda = agenda;
        return this;
    }

    @Override
    public VEvent get() {
        VEvent vEvent = getPrototype().isPresent() ? getPrototype().get().copy() : new VEvent();
        vEvent.with(DTSTAMP, Instant.now());
        // apply mandatory properties..
        vEvent.replace(EventType.MEETING);

        vEvent.with(UID, uid);
        vEvent.with(RRULE, repeats);
        vEvent.with(SUMMARY, summary);
        vEvent.with(DTSTART, start);
        vEvent.with(DURATION, duration);
        vEvent.with(ORGANIZER, organizer);
        vEvent.with(CHAIR, chair);
        required.forEach(p -> vEvent.with(REQUIRED_ATTENDEE, p));
        optional.forEach(p -> vEvent.with(OPTIONAL_ATTENDEE, p));

//        if (location != null) {
//            vEvent.add(location);
//        }
//        resources.forEach(vEvent::add);
//        if (agenda != null) {
//            vEvent.add(new Link(agenda));
//        }
        notifications.forEach(vEvent::add);
        //todo: for each existing attendee add corresponding participant component..
        return vEvent;
    }
}
