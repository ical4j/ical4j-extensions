package net.fortuna.ical4j.extensions.strategy.action;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

/**
 * Represents a task, which is a single unit of work that can be assigned, tracked, and completed.
 * Tasks can be part of larger projects or standalone items.
 */
public class Task extends AbstractStrategy<VToDo, Task> {

    @Override
    public VToDo get() {
        VToDo vToDo = newInstance(VToDo::new);
        return vToDo;
    }
}
