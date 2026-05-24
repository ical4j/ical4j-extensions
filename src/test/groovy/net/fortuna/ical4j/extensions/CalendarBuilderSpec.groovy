package net.fortuna.ical4j.extensions

import net.fortuna.ical4j.model.Calendar
import net.fortuna.ical4j.validate.ValidationException

class CalendarBuilderSpec extends AbstractExtensionSpec {

    def 'builds and validates calendar samples'() {
        given:
        Calendar calendar = builder.build(getClass().getResourceAsStream(filename))

        when:
        boolean actuallyValid = true
        try {
            calendar.validate()
        } catch (ValidationException ignored) {
            actuallyValid = false
        }

        then:
        actuallyValid == expectedValid

        where:
        filename                 | expectedValid
        '/samples/Bodypart2.ics' | true
    }
}
