package net.fortuna.ical4j.extensions.strategy.vjournal;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.Status;
import net.fortuna.ical4j.model.property.StyledDescription;

/**
 * Used to capture a significant decision relating to a project. In the software architecture domain this
 * is known as an Architecture Decision Record (ADR), or in project management a Key Decision Document (KDD),
 * but ultimately the goal is the same: to capture a decision along with reasons and status
 * (i.e. proposed, accepted, superseded).
 */
public class Decision {

    private String title;

    private StyledDescription context;

    private StyledDescription decision;

    private StyledDescription consequences;

    private Decision supersedes;

    private Status status;

    public VJournal apply(VJournal vJournal) {
        vJournal.replace(status);
        return vJournal;
    }
}
