package net.fortuna.ical4j.extensions.strategy.note;

import net.fortuna.ical4j.extensions.model.concept.NoteType;
import net.fortuna.ical4j.extensions.model.link.Bookmark;
import net.fortuna.ical4j.extensions.model.link.Related;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.component.VJournal;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class WebSite extends AbstractStrategy<VJournal> {

    private URI bookmark;

    private List<URI> related = new ArrayList<>();

    @Override
    public VJournal get() {
        VJournal website = newInstance(VJournal::new).replace(NoteType.WEB_SITE);
        if (bookmark != null) {
            website.add(new Bookmark(bookmark));
        }
        related.forEach(uri -> website.add(new Related(uri)));
        return website;
    }
}
