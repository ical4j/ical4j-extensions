package net.fortuna.ical4j.extensions.validate

import net.fortuna.ical4j.data.CalendarBuilder
import net.fortuna.ical4j.model.Calendar
import net.fortuna.ical4j.validate.ValidationException
import spock.lang.Specification

class ExtensionsCalendarValidatorTest extends Specification {

    def 'verify extensions validators loaded correctly'() {
        given: 'a calendar with an extension property'
        String calendarString = '''
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//ABC Corporation//NONSGML My Product//EN
X-WR-TIMEZONE:/Australia/Melbourne
BEGIN:VTODO
BEGIN:VALARM
ACKNOWLEDGED:20090604T084500Z
TRIGGER;VALUE=DATE-TIME:19970317T133000Z
REPEAT:4
DURATION:PT15M
ACTION:AUDIO
ATTACH;FMTTYPE=audio/basic:ftp://example.com/pub/
 sounds/bell-01.aud
END:VALARM
END:VTODO
END:VCALENDAR
'''

        when: 'the calendar is validated'
        Calendar calendar = new CalendarBuilder().build(new StringReader(calendarString))
        calendar.validate()

        then: 'the extension property is correctly verified'
        notThrown(ValidationException)
    }
}
