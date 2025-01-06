package net.fortuna.ical4j.extensions.strategy.resource


import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

class WebSiteTest extends Specification {

    def 'test parsing equivalence'() {
        expect: 'parsed model matches strategy'
        def website = new WebSite().withPrototype(prototype).get()
        // added UID, DTSTAMP..
        website.propertyList <=> prototype.propertyList != 0

        and: 'output is valid'
        !website.validate().hasErrors()

        where: 'prototype loaded from samples'
        prototype << new File('src/test/resources/strategy/website').listFiles().collect {
            return Calendars.load(it.absolutePath).components
        }.flatten()
    }
}
