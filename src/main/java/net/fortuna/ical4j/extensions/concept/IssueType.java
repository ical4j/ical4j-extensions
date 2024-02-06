package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for issue-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * an issue.
 */
public class IssueType extends ImmutableConcept {

    public enum Urn {
        Issue("urn:ical4j:concept:issue"),

        Story("urn:ical4j:concept:issue:story"),

        Epic("urn:ical4j:concept:issue:epic"),

        Task("urn:ical4j:concept:issue:task"),

        Subtask("urn:ical4j:concept:issue:subtask"),

        Risk("urn:ical4j:concept:issue:risk"),

        Improvement("urn:ical4j:concept:issue:improvement"),

        Change("urn:ical4j:concept:issue:change"),

        Incident("urn:ical4j:concept:issue:incident"),


        Problem("urn:ical4j:concept:issue:problem");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    /**
     * Generic issue type.
     */
    public static final IssueType ISSUE = new IssueType(Urn.Issue);

    public static final IssueType STORY = new IssueType(Urn.Story);

    /**
     * A high-level feature or enhancement to a service or process. Typically, will consist of multiple
     * stories required to implement said feature.
     */
    public static final IssueType EPIC = new IssueType(Urn.Epic);

    /**
     * A task to be performed, sometimes repeatedly, as part of BAU or other activities.
     */
    public static final IssueType TASK = new IssueType(Urn.Task);

    /**
     * A child task that requires completion in order to complete the parent.
     */
    public static final IssueType SUBTASK = new IssueType(Urn.Subtask);

    /**
     * Identify a potential problem before it manifests.
     */
    public static final IssueType RISK = new IssueType(Urn.Risk);

    /**
     * Capture details of process improvements and feature roadmap. This can be used to track
     * demand from both internal and external sources.
     */
    public static final IssueType IMPROVEMENT = new IssueType(Urn.Improvement);

    /**
     * Plan and track changes being made to critical environments and services.
     */
    public static final IssueType CHANGE = new IssueType(Urn.Change);

    /**
     * Record incidents such as service degradation or other impacting events.
     */
    public static final IssueType INCIDENT = new IssueType(Urn.Incident);

    /**
     * Identify and track problems that may not necessarily impact service offerings directly.
     */
    public static final IssueType PROBLEM = new IssueType(Urn.Problem);

    public IssueType(Urn urn) {
        super(urn.getUri());
    }
}
