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
 * Represents an office location in a calendar context.
 * <p>
 * This class extends {@link VLocation} and includes properties specific to office locations.
 * It can be constructed with a name or from a vCard entity.
 * </p>
 * <p>
 * See also <a href="https://www.iana.org/assignments/location-types/location-types.xhtml#office">Location Types</a>
 * </p>
 */
public class Office extends AbstractStrategy<VLocation, Office> {

    private String name;

    private Entity entity;

    public Office name(String name) {
        this.name = name;
        return this;
    }

    public Office entity(Entity entity) {
        this.entity = entity;
        return this;
    }

    @Override
    public VLocation get() {
        VLocation office = newInstance(VLocation::new);
        office.add(new LocationType(net.fortuna.ical4j.model.LocationType.office));
        if (entity != null) {
            Fn fn = entity.getRequiredProperty(PropertyName.FN.toString());
            office.add(new Name(fn.getValue()));

            Geo geo = entity.getRequiredProperty(PropertyName.GEO.toString());
            office.add(new net.fortuna.ical4j.model.property.Geo(geo.getLatitude(), geo.getLongitude()));
        }
        if (name != null) {
            office.replace(new Name(name));
        }
        return office;
    }
}
