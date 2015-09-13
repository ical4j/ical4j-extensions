package net.fortuna.ical4j.extensions.validate;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.validate.CalendarValidatorFactory;
import net.fortuna.ical4j.validate.Validator;

/**
 * Created by fortuna on 13/09/15.
 */
public class ExtensionsCalendarValidatorFactory implements CalendarValidatorFactory {
    @Override
    public Validator<Calendar> newInstance() {
        return new ExtensionsCalendarValidator();
    }
}
