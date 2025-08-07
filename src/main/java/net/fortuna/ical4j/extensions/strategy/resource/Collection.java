package net.fortuna.ical4j.extensions.strategy.resource;

import net.fortuna.ical4j.extensions.model.concept.ResourceType;
import net.fortuna.ical4j.extensions.model.link.Bookmark;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.ChangeManagementPropertyModifiers;
import net.fortuna.ical4j.model.RelationshipPropertyModifiers;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.parameter.RelType;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.util.RandomUidGenerator;

import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of resources in a calendar context.
 * This class extends the AbstractStrategy to create a VJournal component
 * with the ResourceType set to COLLECTION.
 */
public class Collection extends AbstractStrategy<VJournal> {

    private URI bookmark;

    private List<URI> parts = new ArrayList<>();

    @Override
    public VJournal get() {
        VJournal collection = newInstance(VJournal::new).replace(ResourceType.COLLECTION);
        collection.with(ChangeManagementPropertyModifiers.DTSTAMP, Instant.now());
        collection.with(RelationshipPropertyModifiers.UID, new RandomUidGenerator().generateUid());
        if (bookmark != null) {
            collection.add(new Bookmark(bookmark));
        }
        parts.forEach(uri -> collection.add(new RelatedTo(uri).add(RelType.CHILD)));
        return collection;
    }
}
