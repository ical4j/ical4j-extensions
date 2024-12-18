package net.fortuna.ical4j.extensions.strategy.observance

import net.fortuna.ical4j.extensions.model.property.Repeats
import spock.lang.Specification

import java.time.LocalDate

class AnniversaryTest extends Specification {

    def 'test anniversary creation'() {
        expect: 'result matches expected'
        new Anniversary().withRepeats(Repeats.YEARLY).withDate(date).get() as String ==~ expectedValue

        where:
        date                    | expectedValue
        LocalDate.of(0, 12, 25) | /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
DTSTART;VALUE=DATE:00011225\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
TRANSP:TRANSPARENT\r
END:VEVENT\r\n/
    }

    def 'test anniversary revision creation'() {
        given: 'an anniversary instance with one revision'
        def anniversary = new Anniversary().withRepeats(Repeats.YEARLY)
                .withDate(LocalDate.of(0, 12, 25))

        expect: 'result matches expected'
        anniversary.get() as String ==~ expectedValue

        where:
        date                    | expectedValue
        LocalDate.of(0, 12, 25) | /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
DTSTART;VALUE=DATE:00011225\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
TRANSP:TRANSPARENT\r
END:VEVENT\r\n/
    }
}
