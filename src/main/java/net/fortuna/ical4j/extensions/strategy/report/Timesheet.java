package net.fortuna.ical4j.extensions.strategy.report;

import net.fortuna.ical4j.extensions.model.concept.ReportType;
import net.fortuna.ical4j.extensions.strategy.AbstractStrategy;
import net.fortuna.ical4j.model.ChangeManagementPropertyModifiers;
import net.fortuna.ical4j.model.RelationshipPropertyModifiers;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.util.RandomUidGenerator;

import java.time.Instant;

public class Timesheet extends AbstractStrategy<VJournal> {

    @Override
    public VJournal get() {
        VJournal timesheet = newInstance(VJournal::new).replace(ReportType.TIMESHEET);
        timesheet.with(ChangeManagementPropertyModifiers.DTSTAMP, Instant.now());
        timesheet.with(RelationshipPropertyModifiers.UID, new RandomUidGenerator().generateUid());
        return timesheet;
    }
}
