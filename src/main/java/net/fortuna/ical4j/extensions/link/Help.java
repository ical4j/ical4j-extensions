package net.fortuna.ical4j.extensions.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Refers to context-sensitive help.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Help extends Link {

    public Help(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.help));
    }
}
