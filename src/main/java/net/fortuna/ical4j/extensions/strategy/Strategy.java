package net.fortuna.ical4j.extensions.strategy;

import net.fortuna.ical4j.model.Prototype;

import java.util.function.Supplier;

/**
 * A strategy is an opinionated approach to creating iCalendar and vCard objects.
 * <p>
 * Strategy implementation MUST provide a new object instance for every call to
 * the {@link Supplier#get()} method.
 * <p>
 * Some strategy implementations may optionally support prototype instances that
 * are used as the baseline object for supplied instances.
 *
 * @param <T> the applicable object type
 */
public interface Strategy<T> extends Supplier<T> {

    default Strategy<T> withPrototype(Prototype<T> prototype) {
        throw new UnsupportedOperationException("Prototypes not supported for this strategy");
    }
}
