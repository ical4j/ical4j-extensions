package net.fortuna.ical4j.extensions.data;

import net.fortuna.ical4j.data.ContentHandlerContext;
import net.fortuna.ical4j.data.DefaultContentHandler;
import net.fortuna.ical4j.extensions.model.property.WrTimezone;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.TimeZoneRegistry;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * An extended content handler that supports additional properties and parameters.
 * This handler is used to parse iCalendar data with custom extensions.
 * It handles the VTIMEZONE component specially to avoid applying the default timezone
 * to calendar properties outside of a VTIMEZONE context.
 */
public class ExtendedContentHandler extends DefaultContentHandler {

    private boolean inTimezone;

    public ExtendedContentHandler(Consumer<Calendar> consumer, TimeZoneRegistry tzRegistry) {
        super(consumer, tzRegistry, new ContentHandlerContext()
                .withPropertyFactorySupplier(new ExtendedPropertyFactorySupplier())
                .withParameterFactorySupplier(new ExtendedParameterFactorySupplier()));
    }

    public ExtendedContentHandler(Consumer<Calendar> consumer, TimeZoneRegistry tzRegistry, ContentHandlerContext context) {
        super(consumer, tzRegistry, context);
    }

    @Override
    public void startComponent(String name) {
        super.startComponent(name);
        if ("VTIMEZONE".equalsIgnoreCase(name)) {
            inTimezone = true;
        }
    }

    @Override
    public void endComponent(String name) {
        super.endComponent(name);
        if ("VTIMEZONE".equalsIgnoreCase(name)) {
            inTimezone = false;
        }
    }

    @Override
    public void startProperty(String name) {
        super.startProperty(name);
        // don't apply default timezone to calendar properties..
        if (getComponentBuilder() != null && !inTimezone) {
            Optional<Property> defaultTimezone = calendarProperties.stream().filter(p -> p instanceof WrTimezone).findFirst();
            defaultTimezone.ifPresent(property -> propertyBuilder.defaultTimeZone(((WrTimezone) property).toZoneId()));
        }
    }
}
