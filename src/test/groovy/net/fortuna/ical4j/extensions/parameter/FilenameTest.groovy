package net.fortuna.ical4j.extensions.parameter

import net.fortuna.ical4j.data.*
import net.fortuna.ical4j.extensions.AbstractExtensionSpec
import net.fortuna.ical4j.model.Calendar
import net.fortuna.ical4j.model.TimeZoneRegistryFactory

/**
 * Created by fortuna on 6/09/15.
 */
class FilenameTest extends AbstractExtensionSpec {

    def setup() {
        builder = new CalendarBuilder(CalendarParserFactory.getInstance().get(),
                new ServiceLoaderParameterFactorySupplier(), new ServiceLoaderPropertyFactorySupplier(),
                new ServiceLoaderComponentFactorySupplier(), TimeZoneRegistryFactory.getInstance().createRegistry());
    }

    def 'assert value stored correctly'() {
        given: 'a filename value'
        String value = 'example-file.doc'

        when: 'a filename object is constructed'
        Filename filename = [value]

        then: 'the object value matches the original value'
        filename.value == value
    }

    def 'assert factory is located correctly'() {
        given: 'a sample calendar input'
        String calendarString = '''
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//ABC Corporation//NONSGML My Product//EN
BEGIN:VEVENT
DTSTART;VALUE=DATE:20170601
DTEND;VALUE=DATE:20170602
RRULE:FREQ=MONTHLY;INTERVAL=3;BYMONTHDAY=1
DTSTAMP:20180215T170241Z
ORGANIZER;CN=CIM Calendar:mailto:XXX.com_75hd9cj5qnmm2il33hsu7cpps8@grou
 p.calendar.google.com
UID:XXXXg@google.com
CREATED:20170512T173944Z
DESCRIPTION:-::::::::::::::::::::::::::::::::
 :::::::::::::-\\nPlease do not edit this section of the descriptio
 n.\\n\\n-:::::::::::::::::::::::::::::::
 ::::::::::::::-
LAST-MODIFIED:20180201T155251Z
LOCATION:
SEQUENCE:0
STATUS:CONFIRMED
SUMMARY:Do work
TRANSP:TRANSPARENT
ATTACH;FILENAME=Do work xx-xx-xx.docx:https://drive.google
 .com/a/xxx.com/file/d/0B6gb-XZ9hQAXSW5/
 view?usp=drive_web
BEGIN:VALARM
ACTION:DISPLAY
DESCRIPTION:This is an event reminder
TRIGGER:-P0DT0H10M0S
END:VALARM
END:VEVENT
END:VCALENDAR
'''

        when: 'the input is parsed'
        Calendar calendar = builder.build(new StringReader(calendarString))

        then: 'a valid calendar is realised'
        calendar?.components[0].getProperty('ATTACH').getParameter('FILENAME').value == 'Do work xx-xx-xx.docx'
    }
}
