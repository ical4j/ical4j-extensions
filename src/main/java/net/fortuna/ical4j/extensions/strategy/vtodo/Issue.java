package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.model.concept.IssueType;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.RelatedTo;

/**
 * A workflow component representing a problem ticket requiring resolution. This may be used to
 * track incidents, change requests, impediments, etc.
 */
public class Issue {

    private IssueType issueType;

//    private IssueStatus status;

    private RelatedTo parent;

    public Issue issueType(IssueType issueType) {
        this.issueType = issueType;
        return this;
    }

//    public Issue status(IssueStatus status) {
//        this.status = status;
//        return this;
//    }

    public Issue parent(RelatedTo parent) {
        this.parent = parent;
        return this;
    }

    public VToDo apply(VToDo vToDo) {
        vToDo.replace(issueType);
//        vToDo.replace(status);
        vToDo.replace(parent);
        return vToDo;
    }
}
