package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Refers to a copyright statement that applies to the link's context.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Copyright extends Link {

    public Copyright(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.copyright));
    }
}
