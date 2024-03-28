package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for issue-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * an issue.
 */
public class IssueType extends ImmutableConcept {

    public enum Id {
        Issue("semcal:concept:issue"),

        Story("semcal:concept:issue:story"),

        Epic("semcal:concept:issue:epic"),

        Task("semcal:concept:issue:task"),

        Subtask("semcal:concept:issue:subtask"),

        Risk("semcal:concept:issue:risk"),

        Improvement("semcal:concept:issue:improvement"),

        Change("semcal:concept:issue:change"),

        Incident("semcal:concept:issue:incident"),


        Problem("semcal:concept:issue:problem");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    /**
     * Generic issue type.
     */
    public static final IssueType ISSUE = new IssueType(Id.Issue);

    public static final IssueType STORY = new IssueType(Id.Story);

    /**
     * A high-level feature or enhancement to a service or process. Typically, will consist of multiple
     * stories required to implement said feature.
     */
    public static final IssueType EPIC = new IssueType(Id.Epic);

    /**
     * A task to be performed, sometimes repeatedly, as part of BAU or other activities.
     */
    public static final IssueType TASK = new IssueType(Id.Task);

    /**
     * A child task that requires completion in order to complete the parent.
     */
    public static final IssueType SUBTASK = new IssueType(Id.Subtask);

    /**
     * Identify a potential problem before it manifests.
     */
    public static final IssueType RISK = new IssueType(Id.Risk);

    /**
     * Capture details of process improvements and feature roadmap. This can be used to track
     * demand from both internal and external sources.
     */
    public static final IssueType IMPROVEMENT = new IssueType(Id.Improvement);

    /**
     * Plan and track changes being made to critical environments and services.
     */
    public static final IssueType CHANGE = new IssueType(Id.Change);

    /**
     * Record incidents such as service degradation or other impacting events.
     */
    public static final IssueType INCIDENT = new IssueType(Id.Incident);

    /**
     * Identify and track problems that may not necessarily impact service offerings directly.
     */
    public static final IssueType PROBLEM = new IssueType(Id.Problem);

    public IssueType(Id id) {
        super(id.getUri());
    }
}
