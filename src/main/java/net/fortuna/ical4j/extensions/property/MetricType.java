package net.fortuna.ical4j.extensions.property;

import java.net.URI;

/**
 * Concrete types for metric-like components. Typically, this might be used with
 * {@link net.fortuna.ical4j.model.component.VJournal} components in order to group and/or filter similar
 * metrics.
 */
public class MetricType extends AbstractType {

    public static final MetricType ATTENDANCE = new MetricType("https://ical4j.org/metric-types/ATTENDANCE");

    public static final MetricType TIME_TO_RESPOND = new MetricType("https://ical4j.org/metric-types/TIME_TO_RESPOND");

    public static final MetricType TIME_TO_RESOLVE = new MetricType("https://ical4j.org/metric-types/TIME_TO_RESOLVE");

    public MetricType(String uri) {
        super(URI.create(uri));
    }
}
