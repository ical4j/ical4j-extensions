package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.model.component.VToDo;

/**
 * Captures an approval step as part of a workflow.
 */
public class Approval {

    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
