package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * Concrete types for note-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * notes.
 */
public class NoteType extends ImmutableConcept {

    public enum Id {

        Article("semcal:concept:note:article"),
        Assumption("semcal:concept:note:assumption"),
        Comment("semcal:concept:note:comment"),
        Decision("semcal:concept:note:decision"),
        DefinedTerm("semcal:concept:note:defined_term"),
        DigitalDocument("semcal:concept:note:digital_document"),
        Invoice("semcal:concept:note:invoice"),
        Note("semcal:concept:note"),
        Objective("semcal:concept:note:objective"),
        Release("semcal:concept:note:release"),
        Risk("semcal:concept:note:risk"),
        Timesheet("semcal:concept:note:timesheet");


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

    public static final NoteType OBJECTIVE = new NoteType(Id.Objective);

    public static final NoteType RISK = new NoteType(Id.Risk);

    public NoteType(Id id) {
        super(id.getUri());
    }
}
