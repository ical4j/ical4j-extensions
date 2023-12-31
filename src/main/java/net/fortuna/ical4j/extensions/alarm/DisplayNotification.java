package net.fortuna.ical4j.extensions.alarm;

import net.fortuna.ical4j.extensions.property.Notify;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.immutable.ImmutableAction;

public class DisplayNotification extends VAlarm {

    public DisplayNotification(Notify notify, String description) {
        add(notify);
        add(ImmutableAction.DISPLAY);
        add(new Description(description));
    }
}
