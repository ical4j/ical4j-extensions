package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;


/**
 * Concrete types for request-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * a request.
 */
public class RequestType extends ImmutableConcept {

    public static final RequestType APPROVAL = new RequestType(Id.Approval);

    public static final RequestType REQUEST = new RequestType(Id.Request);

    /**
     * See: <a href="https://schema.org/Order">Order</a>
     */
    public static final RequestType ORDER = new RequestType(Id.Order);

    public static final RequestType PROVISION = new RequestType(Id.Provision);

    public static final RequestType DECOMMISSION = new RequestType(Id.Decommission);

    public static final RequestType FAULT = new RequestType(Id.Fault);

    public enum Id {
        Approval("semcal:concept:request:approval"),
        Decommission("semcal:concept:request:decommission"),
        Fault("semcal:concept:request:fault"),
        Order("semcal:concept:request:order"),
        Provision("semcal:concept:request:provision"),
        Request("semcal:concept:request");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public RequestType(Id id) {
        super(id.getUri());
    }
}
