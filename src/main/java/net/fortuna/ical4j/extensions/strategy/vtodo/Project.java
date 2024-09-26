package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractStrategy<VToDo> {

    private final List<VJournal> objectives = new ArrayList<>();

    private final List<VToDo> milestones = new ArrayList<>();

    private final List<VToDo> tasks = new ArrayList<>();

    private final List<VJournal> risks = new ArrayList<>();

    private final List<VToDo> issues = new ArrayList<>();

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
        return vToDo;
    }
}
