package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of work items, typically associated with a Sprint or higher level objective.
 */
public class Backlog {

    private List<VToDo> stories = new ArrayList<>();

    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
