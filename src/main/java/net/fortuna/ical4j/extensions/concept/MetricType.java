package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for metric-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * metrics.
 */
public class MetricType extends ImmutableConcept {

    public enum Urn {
        Metric("urn:ical4j:concept:metric"),

        Attendance("urn:ical4j:concept:metric:attendance"),

        TimeToRespond("urn:ical4j:concept:metric:time_to_respond"),

        TimeToResolve("urn:ical4j:concept:metric:time_to_resolve"),

        Diagnostic("urn:ical4j:concept:metric:diagnostic"),

        Presence("urn:ical4j:concept:metric:presence");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final MetricType METRIC = new MetricType(Urn.Metric);

    public static final MetricType ATTENDANCE = new MetricType(Urn.Attendance);

    public static final MetricType TIME_TO_RESPOND = new MetricType(Urn.TimeToRespond);

    public static final MetricType TIME_TO_RESOLVE = new MetricType(Urn.TimeToResolve);

    public static final MetricType DIAGNOSTIC = new MetricType(Urn.Diagnostic);

    /**
     * The Presence metric is used to record checkins by individuals at physical or virtual locations. The concept of
     * presence is typically associated with a `VJOURNAL` object that may be recurring (i.e. encapsulates multiple
     * checkins for an individual at a specific location).
     */
    public static final MetricType PRESENCE = new MetricType(Urn.Presence);

    public MetricType(Urn urn) {
        super(urn.getUri());
    }
}
