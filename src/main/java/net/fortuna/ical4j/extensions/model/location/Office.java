package net.fortuna.ical4j.extensions.model.location;

import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.LocationType;
import net.fortuna.ical4j.model.property.Name;
import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Geo;

public class Office extends VLocation {

    public Office(String name) {
        add(new LocationType(net.fortuna.ical4j.model.LocationType.office));
        add(new Name(name));
    }

    public Office(Entity entity) {
        add(new LocationType(net.fortuna.ical4j.model.LocationType.office));
        Fn fn = entity.getRequiredProperty(PropertyName.FN.toString());
        add(new Name(fn.getValue()));

        Geo geo = entity.getRequiredProperty(PropertyName.GEO.toString());
        add(new net.fortuna.ical4j.model.property.Geo(geo.getLatitude(), geo.getLongitude()));
    }
}
