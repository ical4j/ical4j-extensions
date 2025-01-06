package net.fortuna.ical4j.extensions.strategy.entity;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.vcard.AddressPropertyModifiers;
import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.GeographicalPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.property.Address;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Geo;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * A location represents a physical place.
 */
public class Location extends AbstractStrategy<Entity> {

    private final List<String> names = new ArrayList<>();

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String locality;

    private String postalCode;

    private String country;

    public Location name(String... name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    public Location latitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location longitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    public Location locality(String locality) {
        this.locality = locality;
        return this;
    }

    public Location postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Location country(String country) {
        this.country = country;
        return this;
    }

    @Override
    public Entity get() {
        Entity entity = newInstance(Entity::new).replace(ImmutableKind.LOCATION);
        names.forEach(name -> entity.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        if (latitude != null && longitude != null) {
            entity.with(GeographicalPropertyModifiers.GEO, new Geo(latitude, longitude));
        }
        if (Stream.of(locality, postalCode, country).anyMatch(s -> !Objects.isNull(s) && !s.isBlank())) {
            entity.with(AddressPropertyModifiers.ADR, new Address("", "", "", locality,
                    "", postalCode, country));
        }
        return entity;
    }
}
