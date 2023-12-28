package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for note-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * notes.
 */
public class NoteType extends ImmutableConcept {

    public static final NoteType NOTE = new NoteType("https://ical4j.org/extensions/concept/note/NOTE");

    /**
     * @see <a href="https://schema.org/DefinedTerm">schema.org</a>
     */
    public static final NoteType DEFINED_TERM = new NoteType("https://ical4j.org/extensions/concept/note/DEFINED_TERM");

    public static final NoteType ARTICLE = new NoteType("https://ical4j.org/extensions/concept/note/ARTICLE");

    /**
     * See: <a href="https://schema.org/DigitalDocument">schema.org: DigitalDocument</a>
     */
    public static final NoteType DIGITAL_DOCUMENT = new NoteType("https://ical4j.org/extensions/concept/note/DIGITAL_DOCUMENT");

    /**
     * Capture release notes and changelog for published version.
     */
    public static final NoteType RELEASE = new NoteType("https://ical4j.org/extensions/concept/note/RELEASE");

    public static final NoteType ASSUMPTION = new NoteType("https://ical4j.org/extensions/concept/note/ASSUMPTION");

    public static final NoteType DECISION = new NoteType("https://ical4j.org/extensions/concept/note/DECISION");

    /**
     * See: <a href="https://schema.org/Comment">schema.org: Comment</a>
     */
    public static final NoteType COMMENT = new NoteType("https://ical4j.org/extensions/concept/note/COMMENT");


    public static final NoteType TIMESHEET = new NoteType("https://ical4j.org/extensions/concept/note/TIMESHEET");

    /**
     * See: <a href="https://schema.org/Invoice">schema.org: Invoice</a>
     */
    public static final NoteType INVOICE = new NoteType("https://ical4j.org/extensions/concept/note/INVOICE");

    public NoteType(String uri) {
        super(URI.create(uri));
    }
}
