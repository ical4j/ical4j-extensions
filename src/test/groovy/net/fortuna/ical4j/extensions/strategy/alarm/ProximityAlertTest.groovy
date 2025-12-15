package net.fortuna.ical4j.extensions.strategy.alarm


import net.fortuna.ical4j.extensions.strategy.location.Office
import net.fortuna.ical4j.model.property.Proximity
import spock.lang.Specification

class ProximityAlertTest extends Specification {

    def 'test notification creation'() {
        expect: 'alarm string matches expected'
        new ProximityAlert().proximity(new Proximity('ARRIVE'))
                .location(new Office('ACME Headquarters'))
                .description('Proceed to the 5th floor').get() as String == '''BEGIN:VALARM\r
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
