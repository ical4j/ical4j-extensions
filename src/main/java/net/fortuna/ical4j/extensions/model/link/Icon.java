package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Refers to an icon representing the link's context.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Icon extends Link {

    public Icon(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.icon));
    }
}
