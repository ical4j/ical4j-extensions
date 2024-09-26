package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of work items, typically associated with a Sprint or higher level objective.
 */
public class Backlog extends AbstractStrategy<VToDo> {

    private final List<VToDo> stories = new ArrayList<>();

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
        return vToDo;
    }
}
