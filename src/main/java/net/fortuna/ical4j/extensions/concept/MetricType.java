package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * Concrete types for metric-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * metrics.
 */
public class MetricType extends ImmutableConcept {

    public static final MetricType METRIC = new MetricType("https://ical4j.org/extensions/concept/metric/METRIC");

    public static final MetricType ATTENDANCE = new MetricType("https://ical4j.org/extensions/concept/metric/ATTENDANCE");

    public static final MetricType TIME_TO_RESPOND = new MetricType("https://ical4j.org/extensions/concept/metric/TIME_TO_RESPOND");

    public static final MetricType TIME_TO_RESOLVE = new MetricType("https://ical4j.org/extensions/concept/metric/TIME_TO_RESOLVE");

    public static final MetricType DIAGNOSTIC = new MetricType("https://ical4j.org/extensions/concept/metric/DIAGNOSTIC");

    /**
     * The Presence metric is used to record checkins by individuals at physical or virtual locations. The concept of
     * presence is typically associated with a `VJOURNAL` object that may be recurring (i.e. encapsulates multiple
     * checkins for an individual at a specific location).
     */
    public static final MetricType PRESENCE = new MetricType("https://ical4j.org/extensions/concept/metric/PRESENCE");

    public MetricType(String uri) {
        super(URI.create(uri));
    }
}
