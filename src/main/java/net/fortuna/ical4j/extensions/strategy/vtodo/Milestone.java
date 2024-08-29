package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a project milestone, which may consist of one or more child tasks.
 */
public class Milestone {

    private List<VToDo> tasks = new ArrayList<>();

    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
