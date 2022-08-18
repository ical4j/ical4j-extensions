package net.fortuna.ical4j.extensions.data;

import net.fortuna.ical4j.data.DefaultPropertyFactorySupplier;
import net.fortuna.ical4j.extensions.property.*;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ExtendedPropertyFactorySupplier implements Supplier<List<PropertyFactory<?>>> {

    @Override
    public List<PropertyFactory<? extends Property>> get() {
        List<PropertyFactory<? extends Property>> factories = new ArrayList<>(new DefaultPropertyFactorySupplier().get());

        final List<PropertyFactory<? extends Property>> extended =
                Arrays.asList(
                        new CalStart.Factory(),
                        new LicLocation.Factory(),
                        new WrAlarmId.Factory(),
                        new WrCalDesc.Factory(),
                        new WrCalName.Factory(),
                        new WrRelCalId.Factory(),
                        new WrTimezone.Factory());

        factories.addAll(extended);
        return factories;
    }
}
