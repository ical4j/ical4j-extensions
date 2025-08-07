package net.fortuna.ical4j.extensions.validate;

import net.fortuna.ical4j.extensions.model.property.*;
import net.fortuna.ical4j.validate.CalendarValidatorImpl;
import net.fortuna.ical4j.validate.ValidationRule;

import java.util.Collections;

/**
 * A validator for iCalendar extensions that includes additional properties such as
 * WrTimezone, WrRelCalId, CalStart, WrCalDesc, and WrCalName.
 * This class extends the CalendarValidatorImpl to provide a complete validation for extended calendar properties.
 *
 * Created by fortuna on 13/09/15.
 */
public class ExtensionsCalendarValidator extends CalendarValidatorImpl {

    public ExtensionsCalendarValidator(ValidationRule... rules) {
        super(rules);

        Collections.addAll(calendarProperties, WrTimezone.class, WrRelCalId.class, CalStart.class, WrCalDesc.class,
                WrCalName.class);
    }
}
