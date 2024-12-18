package net.fortuna.ical4j.extensions.strategy.request;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

/**
 * Captures an approval step as part of a workflow.
 */
public class Approval extends AbstractStrategy<VToDo> {

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
        return vToDo;
    }
}
