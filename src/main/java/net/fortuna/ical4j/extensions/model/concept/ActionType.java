package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * Concrete types for action-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * an action.
 */
public class ActionType extends ImmutableConcept {

    /**
     * General action type.
     */
    public static final ActionType ACTION = new ActionType(Id.Action);

    /**
     * A proposed agenda for events such as meetings, etc.
     */
    public static final ActionType AGENDA = new ActionType(Id.Agenda);

    /**
     * Approval action, typically used in a workflow involving orders and service requests.
     */
    public static final ActionType APPROVAL = new ActionType(Id.Approval);

    /**
     * Qualification action, used to review a service request to ensure requester qualifies for service.
     */
    public static final ActionType SERVICE_QUALIFICATION = new ActionType(Id.ServiceQualification);

    public static final ActionType PAYMENT = new ActionType(Id.Payment);

    public static final ActionType PROJECT = new ActionType(Id.Project);

    /**
     * Fulfilment action, typically used to resolve orders and service requests.
     */
    public static final ActionType FULFILMENT = new ActionType(Id.Fulfilment);

    /**
     * Clarification action, typically use to request further information to resolve orders and service requests.
     */
    public static final ActionType CLARIFICATION = new ActionType(Id.Clarification);

    public static final ActionType REVIEW = new ActionType(Id.Review);

    public static final ActionType LINK_REGISTRATION = new ActionType(Id.LinkRegistration);

    public enum Id {
        Action("semcal:concept:action"),
        Agenda("semcal:concept:action:agenda"),
        Approval("semcal:concept:action:approval"),
        Clarification("semcal:concept:action:clarification"),
        Fulfilment("semcal:concept:action:fulfilment"),
        LinkRegistration("semcal:concept:action:link_registration"),
        Payment("semcal:concept:action:payment"),
        Project("semcal:concept:action:project"),
        Review("semcal:concept:action:review"),
        ServiceQualification("semcal:concept:action:service_qualification");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public ActionType(Id id) {
        super(id.getUri());
    }
}
