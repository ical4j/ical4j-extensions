package net.fortuna.ical4j.extensions.strategy.entity;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An application represents a running software process or system.
 */
public class Application extends AbstractStrategy<Entity> {

    private final List<String> names = new ArrayList<>();

    public Application name(String... name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    @Override
    public Entity get() {
        Entity entity = newInstance(Entity::new).replace(ImmutableKind.APPLICATION);
        names.forEach(name -> entity.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        return entity;
    }
}
