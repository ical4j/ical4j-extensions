package net.fortuna.ical4j.extensions.strategy.note

import net.fortuna.ical4j.model.component.VJournal
import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class WebSiteTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        new WebSite().withPrototype((VJournal) prototype).get().propertyList <=> prototype.propertyList == 0

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/website').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
