package net.fortuna.ical4j.extensions.parameter

import net.fortuna.ical4j.data.CalendarBuilder
import net.fortuna.ical4j.model.Calendar
import spock.lang.Specification

/**
 * Created by fortuna on 6/09/15.
 */
class DisplayTest extends Specification {

    def 'assert value stored correctly'() {
        given: 'a display value'
        String displayValue = 'GRAPHIC,THUMBNAIL'

        when: 'a display object is constructed'
        Display display = [displayValue]

        then: 'the object value matches the original address'
        display.value == displayValue
    }

    def 'assert factory is located correctly'() {
        given: 'a sample calendar input'
        String calendarString = '''
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//ABC Corporation//NONSGML My Product//EN
BEGIN:VTODO
IMAGE;VALUE=URI;DISPLAY=BADGE,THUMBNAIL,;FMTTYPE=image/png:http://exa
 mple.com/images/weather-cloudy.png
END:VTODO
END:VCALENDAR
'''

        when: 'the input is parsed'
        Calendar calendar = new CalendarBuilder().build(new StringReader(calendarString))

        then: 'a valid calendar is realised'
        calendar?.components[0].properties[0].getParameter('DISPLAY').value == 'BADGE,THUMBNAIL'
    }
}
