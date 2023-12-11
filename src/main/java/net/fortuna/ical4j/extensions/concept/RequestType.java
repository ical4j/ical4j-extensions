package net.fortuna.ical4j.extensions.concept;

import java.net.URI;


/**
 * Concrete types for request-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * a request.
 */
public class RequestType extends AbstractType {

    public static final RequestType PROVISION = new RequestType("https://ical4j.org/request-types/PROVISION");

    public static final RequestType DECOMMISSION = new RequestType("https://ical4j.org/request-types/DECOMMISSION");

    public static final RequestType FAULT = new RequestType("https://ical4j.org/request-types/FAULT");

    public RequestType(String uri) {
        super(URI.create(uri));
    }
}
