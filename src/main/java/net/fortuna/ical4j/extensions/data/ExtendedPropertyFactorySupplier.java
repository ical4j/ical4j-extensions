package net.fortuna.ical4j.extensions.data;

import net.fortuna.ical4j.data.DefaultPropertyFactorySupplier;
import net.fortuna.ical4j.extensions.model.property.*;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * A supplier for extended property factories that includes additional properties such as CalStart, LicLocation,
 * WrAlarmId, WrCalDesc, WrCalName, WrRelCalId, and WrTimezone.
 * This class extends the default property factory supplier to provide a complete list of property factories.
 */
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
