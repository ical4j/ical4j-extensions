package net.fortuna.ical4j.extensions.parameter

import net.fortuna.ical4j.data.CalendarBuilder
import net.fortuna.ical4j.model.Calendar
import spock.lang.Specification

/**
 * Created by fortuna on 6/09/15.
 */
class LabelTest extends Specification {

    def 'assert value stored correctly'() {
        given: 'a label value'
        String labelValue = 'Chat room:xmpp:chat-123@conference.example.com'

        when: 'a label object is constructed'
        Label label = [labelValue]

        then: 'the object value matches the original address'
        label.value == labelValue
    }

    def 'assert factory is located correctly'() {
        given: 'a sample calendar input'
        String calendarString = '''
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//ABC Corporation//NONSGML My Product//EN
BEGIN:VTODO
CONFERENCE;VALUE=URI;FEATURE=VIDEO;
 LABEL="Web video chat, access code=76543";
 :http://video-chat.example.com/;group-id=1234
END:VTODO
END:VCALENDAR
'''

        when: 'the input is parsed'
        Calendar calendar = new CalendarBuilder().build(new StringReader(calendarString))

        then: 'a valid calendar is realised'
        calendar?.components[0].properties[0].getParameter('LABEL').value == 'Web video chat, access code=76543'
    }
}
