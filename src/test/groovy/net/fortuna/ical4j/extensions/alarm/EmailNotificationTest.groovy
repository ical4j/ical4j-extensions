package net.fortuna.ical4j.extensions.alarm

import net.fortuna.ical4j.extensions.property.Notify
import spock.lang.Specification

import java.time.Duration

import static net.fortuna.ical4j.extensions.property.Notify.Relative.BeforeStart

class EmailNotificationTest extends Specification {

    def 'test notification creation'() {
        expect: 'alarm string matches expected'
        new EmailNotification(
                new Notify(Duration.ofMinutes(5), BeforeStart),
                'Reminder') as String == '''BEGIN:VALARM\r
TRIGGER;RELATED=START;VALUE=DURATION:-PT5M\r
ACTION:EMAIL\r
DESCRIPTION:Reminder\r
END:VALARM\r
'''
    }
}
