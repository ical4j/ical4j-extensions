package net.fortuna.ical4j.extensions.strategy.report

import net.fortuna.ical4j.model.component.VJournal
import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class TimesheetTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def timesheet = new Timesheet().withPrototype((VJournal) prototype).get()
        // added UID, DTSTAMP..
        timesheet.propertyList <=> prototype.propertyList != 0

        and: 'output is valid'
        !timesheet.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/timesheet').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
