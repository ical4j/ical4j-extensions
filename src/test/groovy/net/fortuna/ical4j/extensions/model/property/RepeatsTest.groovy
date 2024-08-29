package net.fortuna.ical4j.extensions.model.property


import org.threeten.extra.Months
import org.threeten.extra.Weeks
import spock.lang.Specification

import java.time.LocalDate

import static java.time.DayOfWeek.MONDAY
import static java.time.DayOfWeek.WEDNESDAY
import static java.time.Month.APRIL
import static java.time.Month.MAY

class RepeatsTest extends Specification {

    def 'test recurrence creation'() {
        expect: 'recurrence matched expected value'
        recurrence as String == expectedValue

        where:
        recurrence                                 | expectedValue
        Repeats.DAILY | 'RRULE:FREQ=DAILY;INTERVAL=1\r\n'
        new Repeats(Weeks.of(3))                   | 'RRULE:FREQ=WEEKLY;INTERVAL=3\r\n'
        new Repeats(Weeks.of(2))
                .until(LocalDate.of(2022, 12, 23))
                .on(MONDAY, WEDNESDAY)             | 'RRULE:FREQ=WEEKLY;UNTIL=20221223;INTERVAL=2;BYDAY=MO,WE\r\n'
        new Repeats(Months.of(3)).on(1, 15)        | 'RRULE:FREQ=MONTHLY;INTERVAL=3;BYMONTHDAY=1,15\r\n'
        Repeats.YEARLY.on(APRIL, MAY).times(3)     | 'RRULE:FREQ=YEARLY;COUNT=3;INTERVAL=1;BYMONTH=4,5\r\n'
    }
}
