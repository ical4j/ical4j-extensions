package net.fortuna.ical4j.extensions.model.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Identifies a target URI that supports the Webmention protocol. This allows clients that mention a resource in some
 * form of publishing process to contact that endpoint and inform it that this resource has been mentioned.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Webmention extends Link {

    public Webmention(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.webmention));
    }
}
