package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a project milestone, which may consist of one or more child tasks.
 */
public class Milestone extends AbstractStrategy<VToDo> {

    private final List<VToDo> tasks = new ArrayList<>();

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
        return vToDo;
    }
}
