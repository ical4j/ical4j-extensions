package net.fortuna.ical4j.extensions.alarm;

import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Proximity;

public class ProximityNotification extends VAlarm {

    public ProximityNotification(Proximity proximity, VLocation location, String description) {
        add(proximity);
        add(location);
        add(new Description(description));
    }
}
