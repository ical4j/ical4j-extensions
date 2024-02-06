package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for note-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * notes.
 */
public class NoteType extends ImmutableConcept {

    public enum Urn {
        Note("urn:ical4j:concept:note"),

        DefinedTerm("urn:ical4j:concept:note:defined_term"),

        Article("urn:ical4j:concept:note:article"),

        DigitalDocument("urn:ical4j:concept:note:digital_document"),

        Release("urn:ical4j:concept:note:release"),

        Assumption("urn:ical4j:concept:note:assumption"),

        Decision("urn:ical4j:concept:note:decision"),

        Comment("urn:ical4j:concept:note:comment"),

        Timesheet("urn:ical4j:concept:note:timesheet"),

        Invoice("urn:ical4j:concept:note:invoice");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final NoteType NOTE = new NoteType(Urn.Note);

    /**
     * @see <a href="https://schema.org/DefinedTerm">schema.org</a>
     */
    public static final NoteType DEFINED_TERM = new NoteType(Urn.DefinedTerm);

    public static final NoteType ARTICLE = new NoteType(Urn.Article);

    /**
     * See: <a href="https://schema.org/DigitalDocument">schema.org: DigitalDocument</a>
     */
    public static final NoteType DIGITAL_DOCUMENT = new NoteType(Urn.DigitalDocument);

    /**
     * Capture release notes and changelog for published version.
     */
    public static final NoteType RELEASE = new NoteType(Urn.Release);

    public static final NoteType ASSUMPTION = new NoteType(Urn.Assumption);

    public static final NoteType DECISION = new NoteType(Urn.Decision);

    /**
     * See: <a href="https://schema.org/Comment">schema.org: Comment</a>
     */
    public static final NoteType COMMENT = new NoteType(Urn.Comment);


    public static final NoteType TIMESHEET = new NoteType(Urn.Timesheet);

    /**
     * See: <a href="https://schema.org/Invoice">schema.org: Invoice</a>
     */
    public static final NoteType INVOICE = new NoteType(Urn.Invoice);

    public NoteType(Urn urn) {
        super(urn.getUri());
    }
}
