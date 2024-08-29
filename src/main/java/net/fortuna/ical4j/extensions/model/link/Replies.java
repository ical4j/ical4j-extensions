package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Identifies a resource that is a reply to the context of the link.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Replies extends Link {

    public Replies(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.replies));
    }
}
