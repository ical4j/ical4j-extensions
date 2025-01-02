package net.fortuna.ical4j.extensions.strategy.event


import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class EventTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        new Event().withPrototype(prototype).get().propertyList == prototype.propertyList

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/event').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
