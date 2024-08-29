package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Indicates that the link's context is a part of a series, and that the next in the series is the link target.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Next extends Link {

    public Next(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.next));
    }

    public Next(Component component) {
        super(component);
        add(new LinkRel(LinkRelationType.next));
    }
}
