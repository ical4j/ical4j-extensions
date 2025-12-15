package net.fortuna.ical4j.extensions.strategy.location;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.LocationType;
import net.fortuna.ical4j.model.property.Name;
import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Geo;

/**
 * Represents a public place in a calendar context.
 * <p>
 * This class extends {@link VLocation} and includes properties specific to public places.
 * It can be constructed with a name or from a vCard entity.
 * </p>
 * <p>
 * See also <a href="https://www.iana.org/assignments/location-types/location-types.xhtml#public">Location Types</a>
 * </p>
 */
public class PublicPlace extends AbstractStrategy<VLocation, PublicPlace> {

    private String name;

    private Entity entity;

    public PublicPlace name(String name) {
        this.name = name;
        return this;
    }

    public PublicPlace entity(Entity entity) {
        this.entity = entity;
        return this;
    }

    @Override
    public VLocation get() {
        VLocation publicPlace = newInstance(VLocation::new);
        publicPlace.add(new LocationType(net.fortuna.ical4j.model.LocationType.public_));
        if (entity != null) {
            Fn fn = entity.getRequiredProperty(PropertyName.FN.toString());
            publicPlace.add(new Name(fn.getValue()));

            Geo geo = entity.getRequiredProperty(PropertyName.GEO.toString());
            publicPlace.add(new net.fortuna.ical4j.model.property.Geo(geo.getLatitude(), geo.getLongitude()));
        }
        if (name != null) {
            publicPlace.replace(new Name(name));
        }
        return publicPlace;
    }
}