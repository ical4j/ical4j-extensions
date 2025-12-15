package net.fortuna.ical4j.extensions.strategy.location


import spock.lang.Specification

class PublicPlaceTest extends Specification {

    def 'test public place creation'() {
        expect: 'string value matches expected'
        new PublicPlace().name('Federation Square') as String == '''BEGIN:VLOCATION\r
LOCATION-TYPE:public\r
NAME:Federation Square\r
END:VLOCATION\r
'''
    }
}
