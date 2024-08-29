package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Refers to a resource that is not part of the same site as the current context.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class External extends Link {

    public External(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.external));
    }
}
