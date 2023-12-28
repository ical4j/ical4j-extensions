package net.fortuna.ical4j.extensions.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Indicates that the link's context is a part of a series, and that the previous in the series is the link target.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Prev extends Link {

    public Prev(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.prev));
    }
}
