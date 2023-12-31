package net.fortuna.ical4j.extensions.alarm

import net.fortuna.ical4j.extensions.property.Notify
import spock.lang.Specification

import java.time.Duration

import static net.fortuna.ical4j.extensions.property.Notify.Relative.BeforeStart

class DisplayNotificationTest extends Specification {

    def 'test notification creation'() {
        expect: 'alarm string matches expected'
        new DisplayNotification(
                new Notify(Duration.ofMinutes(5), BeforeStart),
                'Reminder') as String == '''BEGIN:VALARM\r
TRIGGER;RELATED=START;VALUE=DURATION:-PT5M\r
ACTION:DISPLAY\r
DESCRIPTION:Reminder\r
END:VALARM\r
'''
    }
}
