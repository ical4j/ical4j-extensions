package net.fortuna.ical4j.extensions

import net.fortuna.ical4j.data.*
import net.fortuna.ical4j.model.TimeZoneRegistryFactory
import spock.lang.Specification

abstract class AbstractExtensionSpec extends Specification {

    CalendarBuilder builder

    def setup() {
        builder = new CalendarBuilder(CalendarParserFactory.getInstance().get(),
                new ServiceLoaderParameterFactorySupplier(), new ServiceLoaderPropertyFactorySupplier(),
                new ServiceLoaderComponentFactorySupplier(), TimeZoneRegistryFactory.getInstance().createRegistry());
    }

}
