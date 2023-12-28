package net.fortuna.ical4j.extensions.concept;

import java.net.URI;


/**
 * Concrete types for request-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * a request.
 */
public class RequestType extends ImmutableConcept {

    public static final RequestType REQUEST = new RequestType("https://ical4j.org/extensions/concept/request/REQUEST");

    /**
     * See: <a href="https://schema.org/Order">Order</a>
     */
    public static final RequestType ORDER = new RequestType("https://ical4j.org/extensions/concept/request/ORDER");

    public static final RequestType PROVISION = new RequestType("https://ical4j.org/extensions/concept/request/PROVISION");

    public static final RequestType DECOMMISSION = new RequestType("https://ical4j.org/extensions/concept/request/DECOMMISSION");

    public static final RequestType FAULT = new RequestType("https://ical4j.org/extensions/concept/request/FAULT");

    public RequestType(String uri) {
        super(URI.create(uri));
    }
}
