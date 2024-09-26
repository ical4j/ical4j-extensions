package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.model.concept.ActionType;
import net.fortuna.ical4j.extensions.model.link.Next;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.Uid;

import java.net.URI;
import java.time.temporal.Temporal;

import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.DESCRIPTION;
import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.SUMMARY;
import static net.fortuna.ical4j.model.RelationshipPropertyModifiers.*;

/**
 * One or more objectives, typically linked to a Meeting to guide outcomes.
 */
public class Agenda extends AbstractStrategy<VToDo> {

    private Temporal start;

    private Temporal due;

    private URI organizer;

    private Uid uid;

    private String summary;

    private String description;

    private Next nextItem;

    public Agenda uid(Uid uid) {
        this.uid = uid;
        return this;
    }

    public Agenda summary(String summary) {
        this.summary = summary;
        return this;
    }

    public Agenda nextItem(VToDo item) {
        this.nextItem = new Next(item);
        return this;
    }

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
        vToDo.replace(ActionType.AGENDA);
        vToDo.with(SUMMARY, summary);
        vToDo.with(DESCRIPTION, description);
        vToDo.with(ORGANIZER_URI, organizer);
        vToDo.with(UID, uid);
        vToDo.with(LINK, nextItem);

        return vToDo;
    }
}
