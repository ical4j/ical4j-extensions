package net.fortuna.ical4j.extensions.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;

import java.net.URI;

/**
 * Identifies a resource that represents the context's status.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Status extends ImmutableLink {

    public Status ACTIVE = new Status("https://ical4j.org/extensions/link/status/ACTIVE");

    public Status COMPLETED = new Status("https://ical4j.org/extensions/link/status/COMPLETED");

    public Status FAILED = new Status("https://ical4j.org/extensions/link/status/FAILED");

    public Status POTENTIAL = new Status("https://ical4j.org/extensions/link/status/POTENTIAL");


    public Status CANCELLED = new Status("https://ical4j.org/extensions/link/status/CANCELLED");
    public Status MOVED_ONLINE = new Status("https://ical4j.org/extensions/link/status/MOVED_ONLINE");
    public Status POSTPONED = new Status("https://ical4j.org/extensions/link/status/POSTPONED");
    public Status RESCHEDULED = new Status("https://ical4j.org/extensions/status/RESCHEDULED");
    public Status SCHEDULED = new Status("https://ical4j.org/extensions/link/status/SCHEDULED");

    public Status ACKNOWLEDGED = new Status("https://ical4j.org/extensions/link/status/ACKNOWLEDGED");
    public Status REJECTED = new Status("https://ical4j.org/extensions/link/status/REJECTED");
    public Status IN_PROGRESS = new Status("https://ical4j.org/extensions/link/status/IN_PROGRESS");
    public Status BLOCKED = new Status("https://ical4j.org/extensions/link/status/BLOCKED");
    public Status PENDING = new Status("https://ical4j.org/extensions/link/status/PENDING");
    public Status RESOLVED = new Status("https://ical4j.org/extensions/link/status/RESOLVED");
    public Status CLOSED = new Status("https://ical4j.org/extensions/link/status/CLOSED");

    public Status(String status) {
        super(URI.create(status));
        add(new LinkRel(LinkRelationType.status));
    }
}
