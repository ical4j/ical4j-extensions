package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private List<VJournal> objectives = new ArrayList<>();

    private List<VToDo> milestones = new ArrayList<>();

    private List<VToDo> tasks = new ArrayList<>();

    private List<VJournal> risks = new ArrayList<>();

    private List<VToDo> issues = new ArrayList<>();

    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
