package net.fortuna.ical4j.extensions.strategy.note

import net.fortuna.ical4j.model.component.VJournal
import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class NoteTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def note = new Note().withPrototype((VJournal) prototype).get()
        // added UID, DTSTAMP..
        note.propertyList <=> prototype.propertyList != 0

        and: 'output is valid'
        !note.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/note').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
