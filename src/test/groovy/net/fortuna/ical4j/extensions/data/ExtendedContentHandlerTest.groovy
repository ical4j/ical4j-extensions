package net.fortuna.ical4j.extensions.data


import net.fortuna.ical4j.data.CalendarParserFactory
import net.fortuna.ical4j.model.Calendar
import net.fortuna.ical4j.model.TimeZoneRegistryFactory
import net.fortuna.ical4j.util.CompatibilityHints
import spock.lang.Specification

class ExtendedContentHandlerTest extends Specification {

    def setup() {
        CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_RELAXED_PARSING, true)
    }

    def cleanup() {
        CompatibilityHints.clearHintEnabled(CompatibilityHints.KEY_RELAXED_PARSING)
    }

    def 'test loading calendar with X-WR-TIMEZONE property'() {
        given: 'an extended content handler'
        Calendar cal
        ExtendedContentHandler contentHandler = [
                { cal = it },
                TimeZoneRegistryFactory.getInstance().createRegistry()
        ]

        when: 'a calendar is parser'
        CalendarParserFactory.instance.get().parse(ExtendedContentHandlerTest.getResourceAsStream('/samples/Australian32Holidays.ics'),
                contentHandler)

        then: 'resulting calendar has a default timezone applied'
        //...
        cal != null
    }
}
