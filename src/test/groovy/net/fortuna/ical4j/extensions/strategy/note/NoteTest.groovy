package net.fortuna.ical4j.extensions.strategy.note


import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class NoteTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        new Note().withPrototype(prototype).get().propertyList == prototype.propertyList

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/note').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
