package net.fortuna.ical4j.extensions.strategy.action;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

public class Task extends AbstractStrategy<VToDo> {

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
        return vToDo;
    }
}
