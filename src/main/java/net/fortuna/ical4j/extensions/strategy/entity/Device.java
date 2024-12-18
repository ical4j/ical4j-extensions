package net.fortuna.ical4j.extensions.strategy.entity;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.GeneralPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A device represents a network-enabled hardware device.
 */
public class Device extends AbstractStrategy<Entity> {

    private final List<String> names = new ArrayList<>();

    public Device name(String... name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    @Override
    public Entity get() {
        Entity entity = getPrototype().isPresent() ? getPrototype().get().copy() : new Entity();
        entity.with(GeneralPropertyModifiers.KIND, ImmutableKind.DEVICE);
        names.forEach(name -> entity.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        return entity;
    }
}
