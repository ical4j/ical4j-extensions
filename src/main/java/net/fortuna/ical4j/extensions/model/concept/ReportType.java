package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * Concrete types for report-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * reports.
 */
public class ReportType extends ImmutableConcept {

    public enum Id {
        Report("semcal:concept:report"),

        Attendance("semcal:concept:report:attendance"),

        TimeToRespond("semcal:concept:report:time_to_respond"),

        TimeToResolve("semcal:concept:report:time_to_resolve"),

        Diagnostic("semcal:concept:report:diagnostic"),

        Presence("semcal:concept:report:presence");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final ReportType REPORT = new ReportType(Id.Report);

    public static final ReportType ATTENDANCE = new ReportType(Id.Attendance);

    public static final ReportType TIME_TO_RESPOND = new ReportType(Id.TimeToRespond);

    public static final ReportType TIME_TO_RESOLVE = new ReportType(Id.TimeToResolve);

    public static final ReportType DIAGNOSTIC = new ReportType(Id.Diagnostic);

    /**
     * The Presence report is used to record checkins by individuals at physical or virtual locations. The concept of
     * presence is typically associated with a `VJOURNAL` object that may be recurring (i.e. encapsulates multiple
     * checkins for an individual at a specific location).
     */
    public static final ReportType PRESENCE = new ReportType(Id.Presence);

    public ReportType(Id id) {
        super(id.getUri());
    }
}
