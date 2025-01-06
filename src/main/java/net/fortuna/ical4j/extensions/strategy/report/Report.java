package net.fortuna.ical4j.extensions.strategy.report;

import net.fortuna.ical4j.extensions.model.concept.ReportType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.ChangeManagementPropertyModifiers;
import net.fortuna.ical4j.model.RelationshipPropertyModifiers;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.util.RandomUidGenerator;

import java.time.Instant;

public class Report extends AbstractStrategy<VJournal> {

    @Override
    public VJournal get() {
        VJournal report = newInstance(VJournal::new).replace(ReportType.REPORT);
        report.with(ChangeManagementPropertyModifiers.DTSTAMP, Instant.now());
        report.with(RelationshipPropertyModifiers.UID, new RandomUidGenerator().generateUid());
        return report;
    }
}
