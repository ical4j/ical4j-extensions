package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for issue-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VToDo} components in order to track progress and status of
 * an issue.
 */
public class IssueType extends AbstractType {

    public static final IssueType STORY = new IssueType("https://ical4j.org/issue-types/STORY");

    /**
     * A high-level feature or enhancement to a service or process. Typically, will consist of multiple
     * stories required to implement said feature.
     */
    public static final IssueType EPIC = new IssueType("https://ical4j.org/issue-types/EPIC");

    /**
     * A task to be performed, sometimes repeatedly, as part of BAU or other activities.
     */
    public static final IssueType TASK = new IssueType("https://ical4j.org/issue-types/TASK");

    /**
     * A child task that requires completion in order to complete the parent.
     */
    public static final IssueType SUBTASK = new IssueType("https://ical4j.org/issue-types/SUBTASK");

    /**
     * Generic issue type.
     */
    public static final IssueType ISSUE = new IssueType("https://ical4j.org/issue-types/ISSUE");

    /**
     * Identify a potential problem before it manifests.
     */
    public static final IssueType RISK = new IssueType("https://ical4j.org/issue-types/RISK");

    /**
     * Capture details of process improvements and feature roadmap. This can be used to track
     * demand from both internal and external sources.
     */
    public static final IssueType IMPROVEMENT = new IssueType("https://ical4j.org/issue-types/IMPROVEMENT");

    /**
     * Plan and track changes being made to critical environments and services.
     */
    public static final IssueType CHANGE = new IssueType("https://ical4j.org/issue-types/CHANGE");

    /**
     * Record incidents such as service degradation or other impacting events.
     */
    public static final IssueType INCIDENT = new IssueType("https://ical4j.org/issue-types/INCIDENT");

    /**
     * Identify and track problems that may not necessarily impact service offerings directly.
     */
    public static final IssueType PROBLEM = new IssueType("https://ical4j.org/issue-types/PROBLEM");

    public IssueType(String uri) {
        super(URI.create(uri));
    }
}
