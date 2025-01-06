package net.fortuna.ical4j.extensions.strategy.event


import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class EventTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def event = new Event().withPrototype(prototype).get()
        event.propertyList <=> prototype.propertyList == 0

        and: 'output is valid'
        !event.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/event').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
