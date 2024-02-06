package net.fortuna.ical4j.extensions.concept;

import java.net.URI;


/**
 * Concrete types for request-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * a request.
 */
public class RequestType extends ImmutableConcept {

    public enum Urn {
        Request("urn:ical4j:concept:request"),

        Order("urn:ical4j:concept:request:order"),

        Provision("urn:ical4j:concept:request:provision"),

        Decommission("urn:ical4j:concept:request:decommission"),

        Fault("urn:ical4j:concept:request:fault");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final RequestType REQUEST = new RequestType(Urn.Request);

    /**
     * See: <a href="https://schema.org/Order">Order</a>
     */
    public static final RequestType ORDER = new RequestType(Urn.Order);

    public static final RequestType PROVISION = new RequestType(Urn.Provision);

    public static final RequestType DECOMMISSION = new RequestType(Urn.Decommission);

    public static final RequestType FAULT = new RequestType(Urn.Fault);

    public RequestType(Urn urn) {
        super(urn.getUri());
    }
}
