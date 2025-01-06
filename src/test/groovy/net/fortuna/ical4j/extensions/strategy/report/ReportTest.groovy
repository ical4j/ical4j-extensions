package net.fortuna.ical4j.extensions.strategy.report


import net.fortuna.ical4j.model.component.VJournal
import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class ReportTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def report = new Report().withPrototype((VJournal) prototype).get()
        // added UID, DTSTAMP..
        report.propertyList <=> prototype.propertyList != 0

        and: 'output is valid'
        !report.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/report').listFiles().collect {
            return Calendars.load(it.absolutePath).components.subList(0, 1)
        }.flatten()
    }
}
