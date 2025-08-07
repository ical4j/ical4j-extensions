package net.fortuna.ical4j.extensions.validate;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.validate.CalendarValidatorFactory;
import net.fortuna.ical4j.validate.ValidationRule;
import net.fortuna.ical4j.validate.Validator;

import static net.fortuna.ical4j.model.Property.*;
import static net.fortuna.ical4j.validate.ValidationRule.ValidationType.One;
import static net.fortuna.ical4j.validate.ValidationRule.ValidationType.OneOrLess;

/**
 * A factory for creating a validator for iCalendar extensions that includes additional properties such as
 * WrTimezone, WrRelCalId, CalStart, WrCalDesc, and WrCalName.
 * This class extends the CalendarValidatorFactory to provide a complete validation for extended calendar properties.
 *
 * Created by fortuna on 13/09/15.
 */
public class ExtensionsCalendarValidatorFactory implements CalendarValidatorFactory {
    @Override
    public Validator<Calendar> newInstance() {
        return new ExtensionsCalendarValidator(new ValidationRule<>(One, PRODID, VERSION),
                new ValidationRule<>(OneOrLess, CALSCALE, METHOD));
    }
}
