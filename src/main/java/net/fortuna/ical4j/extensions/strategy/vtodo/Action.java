package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VToDo;

import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.function.BiFunction;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.COMPLETED;
import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DUE;
import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.SUMMARY;

/**
 * This represents an action undertaken by an actor in response to a related component.
 * Actions may be chained together to form a workflow.
 * <p>
 * See: <a href="https://schema.org/Action">Action</a>
 */
public class Action extends AbstractStrategy<VToDo> {

    private Participant participant;

    private String summary;

    private Temporal due;

    private Instant completed;

    public Action participant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public Action summary(String summary) {
        this.summary = summary;
        return this;
    }

    public Action due(Temporal due) {
        this.due = due;
        return this;
    }

    @Override
    public VToDo get() {
        VToDo vToDo = getPrototype().isPresent() ? getPrototype().get().copy() : new VToDo();
//        vToDo.with(CONCEPT, ImmutableConcept.ACTION);
        vToDo.with(SUMMARY, summary);
        vToDo.with(DUE, due);
        vToDo.with(COMPLETED, completed);
        vToDo.with((BiFunction<VToDo, Participant, VToDo>) (c, p) -> {
                    if (p != null) c.add(p);
                    return c;
                },
                participant);
        return vToDo;
    }
}
