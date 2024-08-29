package net.fortuna.ical4j.extensions.model.location


import spock.lang.Specification

class OfficeTest extends Specification {

    def 'test office creation'() {
        expect: 'string value matches expected'
        new Office('ACME Headquarters') as String == '''BEGIN:VLOCATION\r
LOCATION-TYPE:office\r
NAME:ACME Headquarters\r
END:VLOCATION\r
'''
    }
}
