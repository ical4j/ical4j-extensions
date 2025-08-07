package net.fortuna.ical4j.extensions.model.alarm;

import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Proximity;

/**
 * Represents a proximity notification alarm in an iCalendar component.
 * This class extends VAlarm to create an alarm that triggers based on proximity
 * to a specified location, with a description of the notification.
 *
 * @see <a href="https://tools.ietf.org/html/rfc5545#section-3.6.6">RFC 5545 - VAlarm Component</a>
 */
public class ProximityNotification extends VAlarm {

    public ProximityNotification(Proximity proximity, VLocation location, String description) {
        add(proximity);
        add(location);
        add(new Description(description));
    }
}
