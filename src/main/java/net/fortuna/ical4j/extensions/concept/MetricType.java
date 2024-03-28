package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for metric-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * metrics.
 */
public class MetricType extends ImmutableConcept {

    public enum Id {
        Metric("semcal:concept:metric"),

        Attendance("semcal:concept:metric:attendance"),

        TimeToRespond("semcal:concept:metric:time_to_respond"),

        TimeToResolve("semcal:concept:metric:time_to_resolve"),

        Diagnostic("semcal:concept:metric:diagnostic"),

        Presence("semcal:concept:metric:presence");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final MetricType METRIC = new MetricType(Id.Metric);

    public static final MetricType ATTENDANCE = new MetricType(Id.Attendance);

    public static final MetricType TIME_TO_RESPOND = new MetricType(Id.TimeToRespond);

    public static final MetricType TIME_TO_RESOLVE = new MetricType(Id.TimeToResolve);

    public static final MetricType DIAGNOSTIC = new MetricType(Id.Diagnostic);

    /**
     * The Presence metric is used to record checkins by individuals at physical or virtual locations. The concept of
     * presence is typically associated with a `VJOURNAL` object that may be recurring (i.e. encapsulates multiple
     * checkins for an individual at a specific location).
     */
    public static final MetricType PRESENCE = new MetricType(Id.Presence);

    public MetricType(Id id) {
        super(id.getUri());
    }
}
