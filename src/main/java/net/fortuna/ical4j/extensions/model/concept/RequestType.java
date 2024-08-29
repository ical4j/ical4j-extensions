package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;


/**
 * Concrete types for request-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * a request.
 */
public class RequestType extends ImmutableConcept {

    public enum Id {
        Request("semcal:concept:request"),

        Order("semcal:concept:request:order"),

        Provision("semcal:concept:request:provision"),

        Decommission("semcal:concept:request:decommission"),

        Fault("semcal:concept:request:fault");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final RequestType REQUEST = new RequestType(Id.Request);

    /**
     * See: <a href="https://schema.org/Order">Order</a>
     */
    public static final RequestType ORDER = new RequestType(Id.Order);

    public static final RequestType PROVISION = new RequestType(Id.Provision);

    public static final RequestType DECOMMISSION = new RequestType(Id.Decommission);

    public static final RequestType FAULT = new RequestType(Id.Fault);

    public RequestType(Id id) {
        super(id.getUri());
    }
}
