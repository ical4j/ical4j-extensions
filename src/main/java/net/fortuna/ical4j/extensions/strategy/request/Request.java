package net.fortuna.ical4j.extensions.strategy.request;

import net.fortuna.ical4j.extensions.model.concept.RequestType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VToDo;

/**
 * Represents a request in a calendar context.
 * This class extends the AbstractStrategy to create a VToDo component
 * with the RequestType set to REQUEST.
 */
public class Request extends AbstractStrategy<VToDo> {

    private RequestType requestType;

    public Request type(String summary, RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    @Override
    public VToDo get() {
        VToDo vToDo = newInstance(VToDo::new).replace(RequestType.REQUEST);
        vToDo.replace(requestType);
        return vToDo;
    }
}
