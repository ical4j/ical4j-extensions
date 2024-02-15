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

    public Status(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.status));
    }
}
