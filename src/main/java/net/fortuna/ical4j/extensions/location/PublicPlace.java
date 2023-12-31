package net.fortuna.ical4j.extensions.location;

import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.LocationType;
import net.fortuna.ical4j.model.property.Name;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Geo;

public class PublicPlace extends VLocation {

    public PublicPlace(String name) {
        add(new LocationType(net.fortuna.ical4j.model.LocationType.public_));
        add(new Name(name));
    }

    public PublicPlace(VCard card) {
        add(new LocationType(net.fortuna.ical4j.model.LocationType.public_));
        Fn fn = card.getRequiredProperty(PropertyName.FN.toString());
        add(new Name(fn.getValue()));

        Geo geo = card.getRequiredProperty(PropertyName.GEO.toString());
        add(new net.fortuna.ical4j.model.property.Geo(geo.getLatitude(), geo.getLongitude()));
    }
}
