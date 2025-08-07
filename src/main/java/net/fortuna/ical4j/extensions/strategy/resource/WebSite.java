package net.fortuna.ical4j.extensions.strategy.resource;

import net.fortuna.ical4j.extensions.model.concept.ResourceType;
import net.fortuna.ical4j.extensions.model.link.Bookmark;
import net.fortuna.ical4j.extensions.model.link.Related;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.ChangeManagementPropertyModifiers;
import net.fortuna.ical4j.model.RelationshipPropertyModifiers;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.util.RandomUidGenerator;

import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a website in a calendar context.
 * This class extends the AbstractStrategy to create a VJournal component
 * with the ResourceType set to WEB_SITE.
 */
public class WebSite extends AbstractStrategy<VJournal> {

    private URI bookmark;

    private List<URI> related = new ArrayList<>();

    @Override
    public VJournal get() {
        VJournal website = newInstance(VJournal::new).replace(ResourceType.WEB_SITE);
        website.with(ChangeManagementPropertyModifiers.DTSTAMP, Instant.now());
        website.with(RelationshipPropertyModifiers.UID, new RandomUidGenerator().generateUid());
        if (bookmark != null) {
            website.add(new Bookmark(bookmark));
        }
        related.forEach(uri -> website.add(new Related(uri)));
        return website;
    }
}
