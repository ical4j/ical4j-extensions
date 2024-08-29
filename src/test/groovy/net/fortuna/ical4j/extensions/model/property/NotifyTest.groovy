package net.fortuna.ical4j.extensions.model.property


import org.threeten.extra.Minutes
import spock.lang.Specification

import static net.fortuna.ical4j.extensions.model.property.Notify.Relative.BeforeStart

class NotifyTest extends Specification {

    def 'test notify creation'() {
        expect: 'trigger matched expected value'
        trigger as String == expectedValue

        where:
        trigger                                              | expectedValue
        new Notify(Minutes.of(10).toDuration(), BeforeStart) | 'TRIGGER;RELATED=START;VALUE=DURATION:-PT10M\r\n'
    }
}
