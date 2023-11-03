package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.parameter.Related;
import net.fortuna.ical4j.model.property.ImmutableProperty;
import net.fortuna.ical4j.model.property.Trigger;
import org.threeten.extra.Hours;
import org.threeten.extra.Minutes;

import java.time.Duration;

import static net.fortuna.ical4j.extensions.property.Notify.Relative.*;

/**
 * Notify is an immutable subclass of {@link Trigger} used to define alarm notification times.
 */
public class Notify extends Trigger implements ImmutableProperty {

    public static final Notify ON_START = new Notify(Duration.ZERO, AfterStart);

    public static final Notify ON_END = new Notify(Duration.ZERO, AfterEnd);

    public static final Notify ONE_HOUR_BEFORE_START = new Notify(Hours.of(1).toDuration(), BeforeStart);

    public static final Notify FIVE_MINUTES_BEFORE_END = new Notify(Minutes.of(5).toDuration(), BeforeEnd);

    public enum Relative {BeforeStart, AfterStart, BeforeEnd, AfterEnd}

    public Notify(Duration duration, Relative relative) {
        switch (relative) {
            case BeforeStart:
                add(Related.START);
                setDuration(duration.negated());
                break;
            case AfterStart:
                add(Related.START);
                setDuration(duration);
                break;
            case BeforeEnd:
                add(Related.END);
                setDuration(duration.negated());
                break;
            case AfterEnd:
                add(Related.END);
                setDuration(duration);
        }
    }

    @Override
    public <T extends Property> T add(Parameter parameter) {
        return ImmutableProperty.super.add(parameter);
    }

    @Override
    public <T extends Property> T remove(Parameter parameter) {
        return ImmutableProperty.super.remove(parameter);
    }

    @Override
    public <T extends Property> T removeAll(String... parameterName) {
        return ImmutableProperty.super.removeAll(parameterName);
    }

    @Override
    public <T extends Property> T replace(Parameter parameter) {
        return ImmutableProperty.super.replace(parameter);
    }
}
