package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.parameter.Related;
import net.fortuna.ical4j.model.property.Trigger;

import java.time.Duration;

/**
 * Notify is an immutable subclass of {@link Trigger} used to define alarm notification times.
 */
public class Notify extends Trigger {

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
}
