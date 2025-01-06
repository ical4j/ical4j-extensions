package net.fortuna.ical4j.extensions.strategy.entity

import net.fortuna.ical4j.vcard.VCardBuilder
import spock.lang.Specification

class GroupTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def group = new Group().withPrototype(prototype).get()
        group.propertyList <=> prototype.propertyList == 0

        and: 'output is valid'
        !group.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/group').listFiles().collect {
            return new VCardBuilder(new FileInputStream(it)).build().entities.subList(0, 1)
        }.flatten()
    }
}
