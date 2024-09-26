package net.fortuna.ical4j.extensions.strategy.vjournal

import net.fortuna.ical4j.extensions.model.participant.Contact
import net.fortuna.ical4j.model.component.VEvent
import net.fortuna.ical4j.model.property.Summary
import net.fortuna.ical4j.model.property.Uid
import net.fortuna.ical4j.vcard.ContentBuilder
import spock.lang.Specification

import java.time.LocalDateTime

class AttendanceTest extends Specification {

    def 'create new attendance'() {
        when: 'an empty attendance is created'
        def attendance = new Attendance().get()

        then: 'result matches expected'
        attendance ==~ /BEGIN:VJOURNAL\r
DTSTAMP:\d{8}T\d{6}Z\r
END:VJOURNAL\r\n/

        when: 'attendance is updated'
        VEvent meeting = new VEvent().withProperty(new Summary('Meeting'))
                .withProperty(new Uid('9000')).fluentTarget
        def attendee = new ContentBuilder().entity {
            uid '1234'
            fn('Attendee')
            caladruri('mailto:attendee@example.com')
        }
        attendance = new Attendance().participant(new Contact(attendee))
                .start(LocalDateTime.of(2023, 11, 15, 9, 0))
                .end(LocalDateTime.of(2023, 11, 15, 9, 30))
                .context(meeting)
                .withPrototype(attendance).get()

        then: 'result matches expected'
        attendance ==~ /BEGIN:VJOURNAL\r
DTSTAMP:\d{8}T\d{6}Z\r
DTSTART:20231115T090000\r
DTEND:20231115T093000\r
RELATED-TO:9000\r
BEGIN:PARTICIPANT\r
PARTICIPANT-TYPE:CONTACT\r
UID:1234\r
CALENDAR-ADDRESS:mailto:attendee@example.com\r
STRUCTURED-DATA;VALUE=BINARY;ENCODING=BASE64;FMTTYPE=text\/vcard:QkVHSU46VkNBUkQNClVJRDoxMjM0DQpGTjpBdHRlbmRlZQ0KQ0FMQURSVVJJOm1haWx0bzphdHRlbmRlZUBleGFtcGxlLmNvbQ0KRU5EOlZDQVJEDQo=\r
END:PARTICIPANT\r
END:VJOURNAL\r\n/
    }
}
