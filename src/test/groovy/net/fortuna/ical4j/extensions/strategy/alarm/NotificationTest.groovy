package net.fortuna.ical4j.extensions.strategy.alarm

import net.fortuna.ical4j.extensions.model.property.Notify
import net.fortuna.ical4j.model.property.immutable.ImmutableAction
import spock.lang.Specification

import java.time.Duration

import static net.fortuna.ical4j.extensions.model.property.Notify.Relative.BeforeStart

class NotificationTest extends Specification {

    def 'test display notification creation'() {
        expect: 'alarm string matches expected'
        new Notification().notify(new Notify(Duration.ofMinutes(5), BeforeStart))
            .description('Reminder')
            .action(ImmutableAction.DISPLAY)
            .get() as String == '''BEGIN:VALARM\r
TRIGGER;RELATED=START;VALUE=DURATION:-PT5M\r
ACTION:DISPLAY\r
DESCRIPTION:Reminder\r
END:VALARM\r
'''
    }

    def 'test email notification creation'() {
        expect: 'alarm string matches expected'
        new Notification().notify(new Notify(Duration.ofMinutes(5), BeforeStart))
            .description('Reminder')
            .action(ImmutableAction.EMAIL)
            .get() as String == '''BEGIN:VALARM\r
TRIGGER;RELATED=START;VALUE=DURATION:-PT5M\r
ACTION:EMAIL\r
DESCRIPTION:Reminder\r
END:VALARM\r
'''
    }
}
