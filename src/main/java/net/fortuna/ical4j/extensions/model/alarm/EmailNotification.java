package net.fortuna.ical4j.extensions.model.alarm;

import net.fortuna.ical4j.extensions.model.property.Notify;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.immutable.ImmutableAction;

public class EmailNotification extends VAlarm {

    public EmailNotification(Notify notify, String description) {
        add(notify);
        add(ImmutableAction.EMAIL);
        add(new Description(description));
    }
}
