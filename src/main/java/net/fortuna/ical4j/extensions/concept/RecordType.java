package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for record-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * records.
 */
public class RecordType extends AbstractType {

    /**
     * @see <a href="https://schema.org/DefinedTerm">schema.org</a>
     */
    public static final RecordType DEFINED_TERM = new RecordType("https://schema.org/DefinedTerm");

    public static final RecordType OFFER = new RecordType("https://schema.org/Offer");

    public static final RecordType ORDER = new RecordType("https://schema.org/Order");

    public static final RecordType ARTICLE = new RecordType("https://ical4j.org/record-types/ARTICLE");

    /**
     * Capture release notes and changelog for published version.
     */
    public static final RecordType RELEASE = new RecordType("https://ical4j.org/record-types/RELEASE");

    public static final RecordType ASSUMPTION = new RecordType("https://ical4j.org/record-types/ASSUMPTION");

    public static final RecordType DECISION = new RecordType("https://ical4j.org/record-types/DECISION");

    public RecordType(String uri) {
        super(URI.create(uri));
    }
}
