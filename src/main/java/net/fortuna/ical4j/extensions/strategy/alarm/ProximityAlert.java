package net.fortuna.ical4j.extensions.strategy.alarm;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Proximity;

/**
 * Represents a proximity notification alarm in an iCalendar component.
 * This class extends VAlarm to create an alarm that triggers based on proximity
 * to a specified location, with a description of the notification.
 *
 * @see <a href="https://tools.ietf.org/html/rfc5545#section-3.6.6">RFC 5545 - VAlarm Component</a>
 */
public class ProximityAlert extends AbstractStrategy<VAlarm, ProximityAlert> {

    private Proximity proximity;

    private VLocation location;

    private Action action;

    private String description;

    public ProximityAlert proximity(Proximity proximity) {
        this.proximity = proximity;
        return this;
    }

    public ProximityAlert location(VLocation location) {
        this.location = location;
        return this;
    }

    public ProximityAlert description(String description) {
        this.description = description;
        return this;
    }

    public ProximityAlert action(Action action) {
        this.action = action;
        return this;
    }

    @Override
    public VAlarm get() {
        VAlarm alarm = newInstance(VAlarm::new);
        alarm.add(proximity);
        alarm.add(location);
        alarm.add(action);
        alarm.add(new Description(description));
        return alarm;
    }
}