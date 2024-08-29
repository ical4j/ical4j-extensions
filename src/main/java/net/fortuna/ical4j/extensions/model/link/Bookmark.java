package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Gives a permanent link to use for bookmarking purposes.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Bookmark extends Link {

    public Bookmark(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.bookmark));
    }
}
