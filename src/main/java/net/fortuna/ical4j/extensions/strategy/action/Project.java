package net.fortuna.ical4j.extensions.strategy.action;

import net.fortuna.ical4j.extensions.model.concept.ActionType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a project, which may include objectives, milestones, tasks, risks, and issues.
 * Projects can be used to manage complex workflows and track progress across multiple components.
 */
public class Project extends AbstractStrategy<VToDo, Project> {

    private final List<VJournal> objectives = new ArrayList<>();

    private final List<VToDo> milestones = new ArrayList<>();

    private final List<VToDo> tasks = new ArrayList<>();

    private final List<VJournal> risks = new ArrayList<>();

    private final List<VToDo> issues = new ArrayList<>();

    @Override
    public VToDo get() {
        VToDo project = newInstance(VToDo::new).replace(ActionType.PROJECT);
        return project;
    }
}
