package net.fortuna.ical4j.extensions.strategy.entity

import net.fortuna.ical4j.vcard.VCardBuilder
import spock.lang.Specification

class ApplicationTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def application = new Application().withPrototype(prototype).get()
        application.propertyList <=> prototype.propertyList == 0

        and: 'output is valid'
        !application.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/application').listFiles().collect {
            return new VCardBuilder(new FileInputStream(it)).build().entities
        }.flatten()
    }
}
