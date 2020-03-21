package net.fortuna.ical4j.extensions.caldav.property


import net.fortuna.ical4j.extensions.AbstractExtensionSpec
import net.fortuna.ical4j.model.Calendar

/**
 * Created by fortuna on 12/09/15.
 */
class AcknowledgedTest extends AbstractExtensionSpec {

    def 'assert property creation'() {
        given: 'a string value'
        String value = '20150910T120000Z'

        when: 'a property is constructed'
        Acknowledged property = [value]

        then: 'the property value matches the original value'
        property.value == value
    }

    def 'assert factory is located correctly'() {
        given: 'a sample calendar input'
        String calendarString = '''
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//ABC Corporation//NONSGML My Product//EN
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

        when: 'the input is parsed'
        Calendar calendar = builder.build(new StringReader(calendarString))

        then: 'a valid calendar is realised'
        calendar?.components[0].alarms[0].getProperty('ACKNOWLEDGED').value == '20090604T084500Z'
    }
}
