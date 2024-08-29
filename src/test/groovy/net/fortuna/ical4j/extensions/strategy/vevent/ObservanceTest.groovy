package net.fortuna.ical4j.extensions.strategy.vevent

import net.fortuna.ical4j.extensions.model.property.Repeats
import net.fortuna.ical4j.model.component.VEvent
import org.threeten.extra.Years
import spock.lang.Specification

import java.time.LocalDate

import static java.time.Month.DECEMBER
import static net.fortuna.ical4j.model.Property.SUMMARY

class ObservanceTest extends Specification {

    def 'test creation of public holiday'() {
        given: 'a new template'
        def template = new Observance().title('Christmas Day')

        when: 'initialised'
        VEvent event = template.date(LocalDate.of(2019, DECEMBER, 25))
                .repeats(Repeats.YEARLY).apply(new VEvent())

        then: 'the event represents a public holiday'
        event.getRequiredProperty(SUMMARY).value == 'Christmas Day'
    }

    def 'test creation of recurring week observance'() {
        when: 'a new observance is created'
        VEvent iwsp = new Observance().title("International Week of Science and Peace")
                .start(LocalDate.of(1988, 11, 6))
                .end(LocalDate.of(1988, 11, 12))
//                .url(URI.create("https://www.un.org/en/observances/world-science-day/week"))
                .repeats(new Repeats(Years.ONE)).apply(new VEvent())

        then: 'result matches expected'
        iwsp as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
TRANSP:TRANSPARENT\r
SUMMARY:International Week of Science and Peace\r
DTSTART;VALUE=DATE:19881106\r
DTEND;VALUE=DATE:19881112\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
END:VEVENT\r\n/
    }
}
