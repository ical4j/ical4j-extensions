package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for action-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * an action.
 */
public class ActionType extends ImmutableConcept {

    public enum Urn {
        Action("urn:ical4j:concept:action"),

        Agenda("urn:ical4j:concept:action:agenda"),

        Approval("urn:ical4j:concept:action:approval"),

        ServiceQualification("urn:ical4j:concept:action:service_qualification"),

        Payment("urn:ical4j:concept:action:payment"),

        Fulfilment("urn:ical4j:concept:action:fulfilment"),

        Clarification("urn:ical4j:concept:action:clarification"),

        Review("urn:ical4j:concept:action:review"),

        LinkRegistration("urn:ical4j:concept:action:link_registration");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }
    /**
     * General action type.
     */
    public static final ActionType ACTION = new ActionType(Urn.Action);

    /**
     * A proposed agenda for events such as meetings, etc.
     */
    public static final ActionType AGENDA = new ActionType(Urn.Agenda);

    /**
     * Approval action, typically used in a workflow involving orders and service requests.
     */
    public static final ActionType APPROVAL = new ActionType(Urn.Approval);

    /**
     * Qualification action, used to review a service request to ensure requester qualifies for service.
     */
    public static final ActionType SERVICE_QUALIFICATION = new ActionType(Urn.ServiceQualification);

    public static final ActionType PAYMENT = new ActionType(Urn.Payment);

    /**
     * Fulfilment action, typically used to resolve orders and service requests.
     */
    public static final ActionType FULFILMENT = new ActionType(Urn.Fulfilment);

    /**
     * Clarification action, typically use to request further information to resolve orders and service requests.
     */
    public static final ActionType CLARIFICATION = new ActionType(Urn.Clarification);

    public static final ActionType REVIEW = new ActionType(Urn.Review);

    public static final ActionType LINK_REGISTRATION = new ActionType(Urn.LinkRegistration);

    public ActionType(Urn urn) {
        super(urn.getUri());
    }
}
