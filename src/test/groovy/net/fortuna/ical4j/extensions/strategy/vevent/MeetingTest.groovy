package net.fortuna.ical4j.extensions.strategy.vevent

import net.fortuna.ical4j.extensions.model.participant.Contact
import net.fortuna.ical4j.model.component.VEvent
import net.fortuna.ical4j.vcard.ContentBuilder
import spock.lang.Shared
import spock.lang.Specification

import java.time.Duration
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime

class MeetingTest extends Specification {

    @Shared
    net.fortuna.ical4j.model.ContentBuilder builder = []

    @Shared
    ContentBuilder vcardBuilder = []

    def 'create a new meeting'() {
        when: 'a new meeting is created from a template'
        def meeting = new Meeting().apply(new VEvent())

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:event:meeting\r
END:VEVENT\r\n/

        when: 'the meeting is updated with more details'
        def organizer = vcardBuilder.vcard {
            fn('Big Boss')
            caladruri('mailto:boss@example.com')
        }
        meeting = new Meeting()
                .organizer(organizer)
                .start(LocalDate.of(2023, 11, 13)
                        .atStartOfDay().atZone(ZoneId.of('America/New_York')))
                .duration(Duration.ofMinutes(30))
                .apply(meeting)

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:event:meeting\r
DTSTART;TZID=America\/New_York:20231113T000000\r
DURATION:PT30M\r
ORGANIZER;CN=Big Boss:mailto:boss@example.com\r
END:VEVENT\r\n/

        when: 'the meeting is updated with more details'
        def chair = vcardBuilder.vcard {
            uid '1234'
            fn 'Team Lead'
            caladruri 'mailto:lead-by@example.com'
        }
        meeting = new Meeting().chair(new Contact(chair)).apply(meeting)

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTART;TZID=America\/New_York:20231113T000000\r
DURATION:PT30M\r
ORGANIZER;CN=Big Boss:mailto:boss@example.com\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:event:meeting\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=CHAIR:mailto:lead-by@example.com\r
BEGIN:PARTICIPANT\r
PARTICIPANT-TYPE:CONTACT\r
UID:1234\r
CALENDAR-ADDRESS:mailto:lead-by@example.com\r
STRUCTURED-DATA;VALUE=BINARY;ENCODING=BASE64;FMTTYPE=text\/vcard:QkVHSU46VkNBUkQNClVJRDoxMjM0DQpGTjpUZWFtIExlYWQNCkNBTEFEUlVSSTptYWlsdG86bGVhZC1ieUBleGFtcGxlLmNvbQ0KRU5EOlZDQVJEDQo=\r
END:PARTICIPANT\r
END:VEVENT\r\n/
    }

    def 'test meeting creation'() {
        when: 'a new meeting is created'
        def required = builder.participant {
            uid '123'
            calendaraddress 'mailto:joe@example.com'
        }
        def optional = builder.participant {
            uid '124'
            calendaraddress 'mailto:sally@example.com'
            participanttype 'inactive'
        }
        def chair = builder.participant {
            uid '125'
            calendaraddress 'mailto:vanessa@example.com'
        }
        def meeting = new Meeting().start(ZonedDateTime.parse('2023-11-11T11:00:00Z'))
                .required(required).optional(optional).chair(chair).apply(new VEvent())

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:event:meeting\r
DTSTART;TZID=Z:20231111T110000Z\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=CHAIR:mailto:vanessa@example.com\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:mailto:joe@example.com\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=OPT-PARTICIPANT;PARTSTAT=NEEDS-ACTION:mailto:sally@example.com\r
BEGIN:PARTICIPANT\r
UID:125\r
CALENDAR-ADDRESS:mailto:vanessa@example.com\r
END:PARTICIPANT\r
BEGIN:PARTICIPANT\r
UID:123\r
CALENDAR-ADDRESS:mailto:joe@example.com\r
END:PARTICIPANT\r
BEGIN:PARTICIPANT\r
UID:124\r
CALENDAR-ADDRESS:mailto:sally@example.com\r
PARTICIPANT-TYPE:inactive\r
END:PARTICIPANT\r
END:VEVENT\r\n/
    }

    def 'test create meeting from prototype'() {
        given: 'a meeting prototype'
        def meeting0930am = new net.fortuna.ical4j.model.ContentBuilder().vevent {
            dtstart '20231104T093000'
        }

        when: 'a template uses the prototype to create a meeting'
        def required = builder.participant {
            uid '123'
            calendaraddress 'mailto:joe@example.com'
        }
        def optional = builder.participant {
            uid '124'
            calendaraddress 'mailto:sally@example.com'
            participanttype 'inactive'
        }
        def chair = builder.participant {
            uid '125'
            calendaraddress 'mailto:vanessa@example.com'
        }
        def meeting = new Meeting()
                .required(required).optional(optional).chair(chair).apply(meeting0930am)

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTART:20231104T093000\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:event:meeting\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=CHAIR:mailto:vanessa@example.com\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:mailto:joe@example.com\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=OPT-PARTICIPANT;PARTSTAT=NEEDS-ACTION:mailto:sally@example.com\r
BEGIN:PARTICIPANT\r
UID:125\r
CALENDAR-ADDRESS:mailto:vanessa@example.com\r
END:PARTICIPANT\r
BEGIN:PARTICIPANT\r
UID:123\r
CALENDAR-ADDRESS:mailto:joe@example.com\r
END:PARTICIPANT\r
BEGIN:PARTICIPANT\r
UID:124\r
CALENDAR-ADDRESS:mailto:sally@example.com\r
PARTICIPANT-TYPE:inactive\r
END:PARTICIPANT\r
END:VEVENT\r\n/
    }
}
