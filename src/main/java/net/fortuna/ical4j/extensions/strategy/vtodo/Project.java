package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private final List<VJournal> objectives = new ArrayList<>();

    private final List<VToDo> milestones = new ArrayList<>();

    private final List<VToDo> tasks = new ArrayList<>();

    private final List<VJournal> risks = new ArrayList<>();

    private final List<VToDo> issues = new ArrayList<>();

    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
