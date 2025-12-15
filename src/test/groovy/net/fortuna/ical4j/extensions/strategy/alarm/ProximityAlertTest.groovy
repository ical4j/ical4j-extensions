package net.fortuna.ical4j.extensions.strategy.alarm


import net.fortuna.ical4j.extensions.strategy.location.Office
import net.fortuna.ical4j.model.property.Proximity
import net.fortuna.ical4j.model.property.immutable.ImmutableAction
import spock.lang.Specification

class ProximityAlertTest extends Specification {

    def 'test notification creation'() {
        expect: 'alarm string matches expected'
        new ProximityAlert().proximity(new Proximity('ARRIVE'))
                .location(new Office().name('ACME Headquarters').get())
                .description('Proceed to the 5th floor')
                .action(ImmutableAction.DISPLAY).get() as String == '''BEGIN:VALARM\r
PROXIMITY:ARRIVE\r
ACTION:DISPLAY\r
DESCRIPTION:Proceed to the 5th floor\r
BEGIN:VLOCATION\r
LOCATION-TYPE:office\r
NAME:ACME Headquarters\r
END:VLOCATION\r
END:VALARM\r
'''
    }
}
