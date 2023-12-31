package net.fortuna.ical4j.extensions.alarm

import net.fortuna.ical4j.extensions.location.Office
import net.fortuna.ical4j.model.property.Proximity
import spock.lang.Specification

class ProximityNotificationTest extends Specification {

    def 'test notification creation'() {
        expect: 'alarm string matches expected'
        new ProximityNotification(new Proximity('ARRIVE'), new Office('ACME Headquarters'),
                'Proceed to the 5th floor') as String == '''BEGIN:VALARM\r
PROXIMITY:ARRIVE\r
DESCRIPTION:Proceed to the 5th floor\r
BEGIN:VLOCATION\r
LOCATION-TYPE:office\r
NAME:ACME Headquarters\r
END:VLOCATION\r
END:VALARM\r
'''
    }
}
