package net.fortuna.ical4j.extensions.model.concept

import net.fortuna.ical4j.extensions.ContentBuilder
import net.fortuna.ical4j.model.component.VToDo
import spock.lang.Specification

class ActionTypeTest extends Specification {

    def 'test action type usage'() {
        given: 'a vtodo with action type'
        VToDo toDo = new ContentBuilder().vtodo {
            summary 'My new agenda'
            concept ActionType.AGENDA
        }

        expect: 'string matches expected value'
        toDo as String ==~ /BEGIN:VTODO\r
SUMMARY:My new agenda\r
CONCEPT:semcal:concept:action:agenda\r
END:VTODO\r\n/
    }
}
