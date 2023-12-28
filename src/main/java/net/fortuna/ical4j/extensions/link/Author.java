package net.fortuna.ical4j.extensions.link;

import net.fortuna.ical4j.model.LinkRelationType;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.Link;

import java.net.URI;

/**
 * Refers to the context's author.
 * <p>
 * See also <a href="https://www.iana.org/assignments/link-relations/link-relations.xhtml">Link Relations</a>
 */
public class Author extends Link {

    public Author(URI uri) {
        super(uri);
        add(new LinkRel(LinkRelationType.author));
    }
}
