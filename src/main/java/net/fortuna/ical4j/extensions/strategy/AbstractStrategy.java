package net.fortuna.ical4j.extensions.strategy;

import net.fortuna.ical4j.model.Prototype;

import java.util.Optional;

public abstract class AbstractStrategy<T> implements Strategy<T> {

    private Prototype<? super T> prototype;

    @Override
    public Strategy<T> withPrototype(Prototype<? super T> prototype) {
        this.prototype = prototype;
        return this;
    }

    protected Optional<Prototype<? super T>> getPrototype() {
        return Optional.ofNullable(prototype);
    }
}
