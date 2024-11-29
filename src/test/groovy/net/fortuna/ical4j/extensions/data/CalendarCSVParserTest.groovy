package net.fortuna.ical4j.extensions.data

import net.fortuna.ical4j.data.DefaultContentHandler
import net.fortuna.ical4j.model.TimeZoneRegistryFactory
import spock.lang.Specification

class CalendarCSVParserTest extends Specification {

    def 'test parsing csv'() {
        given: 'a csv string'
        def csv = '''summary,dtstart
summary 1,20030808
summary 2,20030809
summary 3,20030810
'''
        when: 'string is parsed'
        def calendar = null
        def contentHandler = new DefaultContentHandler((it) -> calendar = it,
                TimeZoneRegistryFactory.instance.createRegistry())
        new CalendarCSVParser('vevent').parse(new StringReader(csv), contentHandler)

        then: 'result matched expected'
        calendar as String == '''BEGIN:VCALENDAR\r
BEGIN:VEVENT\r
SUMMARY:summary 1\r
DTSTART:20030808\r
END:VEVENT\r
BEGIN:VEVENT\r
SUMMARY:summary 2\r
DTSTART:20030809\r
END:VEVENT\r
BEGIN:VEVENT\r
SUMMARY:summary 3\r
DTSTART:20030810\r
END:VEVENT\r
END:VCALENDAR\r\n'''
    }
}
