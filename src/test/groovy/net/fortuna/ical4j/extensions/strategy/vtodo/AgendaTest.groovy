package net.fortuna.ical4j.extensions.strategy.vtodo

import net.fortuna.ical4j.model.ComponentList
import net.fortuna.ical4j.model.property.Uid
import spock.lang.Specification

class AgendaTest extends Specification {

    def 'create a new agenda'() {
        when: 'an agenda is created from the default template'
        def agenda = new Agenda().get()

        then: 'the result matches expected'
        agenda as String ==~ /BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:action:agenda\r
END:VTODO\r\n/

        when: 'the agenda is updated'
        def results = new Agenda().summary('Financial results').uid(new Uid('4'))
                .get()
        def review = new Agenda().summary('The year in review').uid(new Uid('3'))
                .nextItem(results).get()
        def welcome = new Agenda().summary('Welcome and introductions').uid(new Uid('2'))
                .nextItem(review).get()
        agenda = new Agenda().summary('Annual General Meeting (AGM)').uid(new Uid('1'))
                .nextItem(welcome).withPrototype(agenda).get()

        def components = new ComponentList([agenda, welcome, review, results])

        then: 'the result matches expected'
        components as String ==~ /BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:action:agenda\r
SUMMARY:Annual General Meeting \(AGM\)\r
UID:1\r
LINK;VALUE=UID;LINKREL=next:2\r
END:VTODO\r
BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:action:agenda\r
SUMMARY:Welcome and introductions\r
UID:2\r
LINK;VALUE=UID;LINKREL=next:3\r
END:VTODO\r
BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:action:agenda\r
SUMMARY:The year in review\r
UID:3\r
LINK;VALUE=UID;LINKREL=next:4\r
END:VTODO\r
BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:semcal:concept:action:agenda\r
SUMMARY:Financial results\r
UID:4\r
END:VTODO\r\n/
    }
}
