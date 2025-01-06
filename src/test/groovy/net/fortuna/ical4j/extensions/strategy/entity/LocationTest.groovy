package net.fortuna.ical4j.extensions.strategy.entity


import net.fortuna.ical4j.vcard.VCardBuilder
import spock.lang.Specification

class LocationTest extends Specification {

    def 'test landmark creation'() {
        given: 'a landmark'
        def bigben = new Location().name('Big Ben')
                .latitude(51.5007292).longitude(-0.1272003)
                .locality('London').postalCode('SW1A 0AA')
                .country('United Kingdom').get()

        expect: 'string matches expected'
        bigben as String == '''BEGIN:VCARD\r
KIND:location\r
FN:Big Ben\r
GEO:51.5007292,-0.1272003\r
ADR:;;;London;;SW1A 0AA;United Kingdom;\r
END:VCARD\r\n'''
    }

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def location = new Location().withPrototype(prototype).get()
        location.propertyList <=> prototype.propertyList == 0

        and: 'output is valid'
        !location.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/location').listFiles().collect {
            return new VCardBuilder(new FileInputStream(it)).build().entities
        }.flatten()
    }
}
