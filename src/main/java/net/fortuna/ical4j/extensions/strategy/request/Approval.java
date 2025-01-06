package net.fortuna.ical4j.extensions.strategy.request;

import net.fortuna.ical4j.extensions.model.concept.RequestType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

/**
 * Captures an approval step as part of a workflow.
 */
public class Approval extends AbstractStrategy<VToDo> {

    @Override
    public VToDo get() {
        VToDo approval = newInstance(VToDo::new).replace(RequestType.APPROVAL);
        return approval;
    }
}
