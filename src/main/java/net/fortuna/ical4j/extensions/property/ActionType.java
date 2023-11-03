package net.fortuna.ical4j.extensions.property;

import java.net.URI;

/**
 * Concrete types for action-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * an action.
 */
public class ActionType extends AbstractType {

    /**
     * General action type.
     */
    public static final ActionType ACTION = new ActionType("https://ical4j.org/action-types/ACTION");

    /**
     * Approval action, typically used in a workflow involving orders and service requests.
     */
    public static final ActionType APPROVAL = new ActionType("https://ical4j.org/action-types/APPROVAL");

    /**
     * Qualification action, used to review a service request to ensure requestor qualifies for service.
     */
    public static final ActionType SERVICE_QUALIFICATION = new ActionType("https://ical4j.org/action-types/SERVICE_QUALIFICATION");

    public static final ActionType PAYMENT = new ActionType("https://ical4j.org/action-types/PAYMENT");

    /**
     * Fulfilment action, typically used to resolve orders and service requests.
     */
    public static final ActionType FULFILMENT = new ActionType("https://ical4j.org/action-types/FULFILMENT");

    /**
     * Clarification action, typically use to request further information to resolve orders and service requests.
     */
    public static final ActionType CLARIFICATION = new ActionType("https://ical4j.org/action-types/CLARIFICATION");

    public static final ActionType REVIEW = new ActionType("https://schema.org/Review");

    public ActionType(String uri) {
        super(URI.create(uri));
    }
}
