package net.fortuna.ical4j.extensions.strategy.resource


import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class CollectionTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def collection = new Collection().withPrototype(prototype).get()
        // added UID, DTSTAMP..
        collection.propertyList <=> prototype.propertyList != 0

        and: 'output is valid'
        !collection.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/collection').listFiles().collect {
            return Calendars.load(it.absolutePath).components.subList(0, 1)
        }.flatten()
    }
}
