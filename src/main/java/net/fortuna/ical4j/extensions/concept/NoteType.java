package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for note-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * notes.
 */
public class NoteType extends ImmutableConcept {

    public enum Id {
        Note("ical4j:concept:note"),

        DefinedTerm("ical4j:concept:note:defined_term"),

        Article("ical4j:concept:note:article"),

        DigitalDocument("ical4j:concept:note:digital_document"),

        Release("ical4j:concept:note:release"),

        Assumption("ical4j:concept:note:assumption"),

        Decision("ical4j:concept:note:decision"),

        Comment("ical4j:concept:note:comment"),

        Timesheet("ical4j:concept:note:timesheet"),

        Invoice("ical4j:concept:note:invoice");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final NoteType NOTE = new NoteType(Id.Note);

    /**
     * @see <a href="https://schema.org/DefinedTerm">schema.org</a>
     */
    public static final NoteType DEFINED_TERM = new NoteType(Id.DefinedTerm);

    public static final NoteType ARTICLE = new NoteType(Id.Article);

    /**
     * See: <a href="https://schema.org/DigitalDocument">schema.org: DigitalDocument</a>
     */
    public static final NoteType DIGITAL_DOCUMENT = new NoteType(Id.DigitalDocument);

    /**
     * Capture release notes and changelog for published version.
     */
    public static final NoteType RELEASE = new NoteType(Id.Release);

    public static final NoteType ASSUMPTION = new NoteType(Id.Assumption);

    public static final NoteType DECISION = new NoteType(Id.Decision);

    /**
     * See: <a href="https://schema.org/Comment">schema.org: Comment</a>
     */
    public static final NoteType COMMENT = new NoteType(Id.Comment);


    public static final NoteType TIMESHEET = new NoteType(Id.Timesheet);

    /**
     * See: <a href="https://schema.org/Invoice">schema.org: Invoice</a>
     */
    public static final NoteType INVOICE = new NoteType(Id.Invoice);

    public NoteType(Id id) {
        super(id.getUri());
    }
}
