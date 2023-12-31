package net.fortuna.ical4j.extensions.alarm

import net.fortuna.ical4j.model.component.VLocation
import net.fortuna.ical4j.model.property.Proximity
import spock.lang.Specification

class ProximityNotificationTest extends Specification {

    def 'test notification creation'() {
        expect: 'alarm string matches expected'
        new ProximityNotification(new Proximity('ARRIVE'), new VLocation(),
                'Proceed to the 5th floor') as String == '''BEGIN:VALARM\r
PROXIMITY:ARRIVE\r
DESCRIPTION:Proceed to the 5th floor\r
BEGIN:VLOCATION\r
END:VLOCATION\r
END:VALARM\r
'''
    }
}
