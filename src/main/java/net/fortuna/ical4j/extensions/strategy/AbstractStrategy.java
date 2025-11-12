package net.fortuna.ical4j.extensions.strategy;

import net.fortuna.ical4j.model.Prototype;

import java.util.function.Supplier;

public abstract class AbstractStrategy<T, E extends AbstractStrategy<T, E>> implements Strategy<T, E> {

    private Prototype<T> prototype;

    @Override
    public E withPrototype(Prototype<T> prototype) {
        this.prototype = prototype;
        return (E) this;
    }

    protected T newInstance(Supplier<T> defaultIns) {
        if (prototype != null) {
            return prototype.copy();
        } else {
            return defaultIns.get();
        }
    }
}
