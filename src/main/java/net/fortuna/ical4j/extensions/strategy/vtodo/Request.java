package net.fortuna.ical4j.extensions.strategy.vtodo;

import net.fortuna.ical4j.extensions.model.concept.RequestType;
import net.fortuna.ical4j.model.component.VToDo;

public class Request {

    private RequestType requestType;

    public Request type(String summary, RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    public VToDo apply(VToDo vToDo) {
        vToDo.replace(requestType);
        return vToDo;
    }
}
