package net.fortuna.ical4j.extensions.strategy.alarm;

import net.fortuna.ical4j.extensions.model.property.Notify;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.Description;

/**
 *
 * Represents a display notification alarm in an iCalendar component.
 * This class extends VAlarm to create an alarm that displays a notification
 * with a specified description.
 * @see <a href="https://tools.ietf.org/html/rfc5545#section-3.6.6">RFC 5545 - VAlarm Component</a>
 *
 */
public class Notification extends AbstractStrategy<VAlarm, Notification> {

    private Notify notify;

    private Action action;

    private String description;

    public Notification notify(Notify notify) {
        this.notify = notify;
        return this;
    }

    public Notification description(String description) {
        this.description = description;
        return this;
    }

    public Notification action(Action action) {
        this.action = action;
        return this;
    }

    @Override
    public VAlarm get() {
        VAlarm alarm = newInstance(VAlarm::new);
        alarm.add(notify);
        alarm.add(action);
        alarm.add(new Description(description));
        return alarm;
    }
}
