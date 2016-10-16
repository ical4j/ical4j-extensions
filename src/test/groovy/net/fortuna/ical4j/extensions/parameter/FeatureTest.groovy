package net.fortuna.ical4j.extensions.parameter

import net.fortuna.ical4j.data.CalendarBuilder
import net.fortuna.ical4j.model.Calendar
import spock.lang.Specification

/**
 * Created by fortuna on 6/09/15.
 */
class FeatureTest extends Specification {

    def 'assert value stored correctly'() {
        given: 'a feature value'
        String featureValue = 'AUDIO,CHAT,FEED'

        when: 'a feature object is constructed'
        Feature feature = [featureValue]

        then: 'the object value matches the original value'
        feature.value == featureValue
    }

    def 'assert factory is located correctly'() {
        given: 'a sample calendar input'
        String calendarString = '''
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//ABC Corporation//NONSGML My Product//EN
BEGIN:VTODO
CONFERENCE;VALUE=URI;FEATURE=AUDIO:rtsp://audio.example.com/
 event
END:VTODO
END:VCALENDAR
'''

        when: 'the input is parsed'
        Calendar calendar = new CalendarBuilder().build(new StringReader(calendarString))

        then: 'a valid calendar is realised'
        calendar?.components[0].properties[0].getParameter('FEATURE').value == 'AUDIO'
    }
}
