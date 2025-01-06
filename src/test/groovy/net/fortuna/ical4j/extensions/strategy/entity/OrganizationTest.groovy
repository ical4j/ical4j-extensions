package net.fortuna.ical4j.extensions.strategy.entity

import net.fortuna.ical4j.vcard.VCardBuilder
import spock.lang.Specification

class OrganizationTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def org = new Organization().withPrototype(prototype).get()
        org.propertyList <=> prototype.propertyList == 0

        and: 'output is valid'
        !org.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/organization').listFiles().collect {
            return new VCardBuilder(new FileInputStream(it)).build().entities
        }.flatten()
    }
}
