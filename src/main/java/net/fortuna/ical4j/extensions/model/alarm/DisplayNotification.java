package net.fortuna.ical4j.extensions.model.alarm;

import net.fortuna.ical4j.extensions.model.property.Notify;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.immutable.ImmutableAction;

/**
 *
 * Represents a display notification alarm in an iCalendar component.
 * This class extends VAlarm to create an alarm that displays a notification
 * with a specified description.
 * @see <a href="https://tools.ietf.org/html/rfc5545#section-3.6.6">RFC 5545 - VAlarm Component</a>
 *
 */
public class DisplayNotification extends VAlarm {

    public DisplayNotification(Notify notify, String description) {
        add(notify);
        add(ImmutableAction.DISPLAY);
        add(new Description(description));
    }
}
