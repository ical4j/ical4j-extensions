package net.fortuna.ical4j.extensions.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.WeekDay;
import net.fortuna.ical4j.model.property.ImmutableProperty;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.transform.recurrence.Frequency;
import org.threeten.extra.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.*;

/**
 * A Schedule is an immutable subclass of {@link RRule} to support common use-cases.
 *
 * @param <T> the temporal type to which this rule will be applied
 */
public class Schedule<T extends Temporal> extends RRule<T> implements ImmutableProperty {

    public static final Schedule<LocalDate> YEARLY = new Schedule<>(Years.ONE);

    public static final Schedule<LocalDate> HALF_YEARLY = new Schedule<>(Months.of(6));

    public static final Schedule<LocalDate> QUARTERLY = new Schedule<>(Months.of(3));

    public static final Schedule<LocalDate> MONTHLY = new Schedule<>(Months.ONE);

    public static final Schedule<LocalDate> FORTNIGHTLY = new Schedule<>(Weeks.of(2));

    public static final Schedule<LocalDate> WEEKLY = new Schedule<>(Weeks.ONE);

    public static final Schedule<LocalDate> DAILY = new Schedule<>(Days.ONE);

    public static final Schedule<LocalDate> TWICE_DAILY = new Schedule<>(Hours.of(12));

    public static final Schedule<LocalDate> HOURLY = new Schedule<>(Hours.of(1));

    public static final Schedule<LocalDate> MINUTELY = new Schedule<>(Minutes.of(1));

    public static final Schedule<LocalDate> SECONDLY = new Schedule<>(Seconds.of(1));

    public static final Schedule<LocalDate> WEEKDAYS = new Schedule<LocalDate>(Weeks.ONE)
            .on(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);

    public static final Schedule<LocalDate> WEEKENDS = new Schedule<LocalDate>(Weeks.ONE)
            .on(SATURDAY, SUNDAY);

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Years interval) {
        this(new Recur.Builder<>().frequency(Frequency.YEARLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Months interval) {
        this(new Recur.Builder<>().frequency(Frequency.MONTHLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Weeks interval) {
        this(new Recur.Builder<>().frequency(Frequency.WEEKLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Days interval) {
        this(new Recur.Builder<>().frequency(Frequency.DAILY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Hours interval) {
        this(new Recur.Builder<>().frequency(Frequency.HOURLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Minutes interval) {
        this(new Recur.Builder<>().frequency(Frequency.MINUTELY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     *
     * @param interval
     */
    public Schedule(Seconds interval) {
        this(new Recur.Builder<>().frequency(Frequency.SECONDLY)
                .interval(interval.getAmount()).build());
    }

    private Schedule(Recur<?> recur) {
        setRecur(recur);
    }

    @Override
    public <P extends Property> P add(Parameter parameter) {
        return ImmutableProperty.super.add(parameter);
    }

    @Override
    public <P extends Property> P remove(Parameter parameter) {
        return ImmutableProperty.super.remove(parameter);
    }

    @Override
    public <P extends Property> P removeAll(String... parameterName) {
        return ImmutableProperty.super.removeAll(parameterName);
    }

    @Override
    public <P extends Property> P replace(Parameter parameter) {
        return ImmutableProperty.super.replace(parameter);
    }

    /**
     * On which day of the week the recurrence repeats (BYDAY).
     *
     * @param day
     */
    public Schedule<T> on(DayOfWeek... day) {
        return new Schedule<>(new Recur.Builder<>(getRecur()).dayList(Arrays.stream(day).map(WeekDay::getWeekDay)
                .collect(Collectors.toList())).build());
    }

    /**
     * On which day of the month the recurrence repeats (BYMONTHDAY).
     *
     * @param dayOfMonth
     */
    public Schedule<T> on(Integer... dayOfMonth) {
        return new Schedule<>(new Recur.Builder<>(getRecur()).monthDayList(Arrays.asList(dayOfMonth)).build());
    }

    public Schedule<T> on(Month... month) {
        return new Schedule<>(new Recur.Builder<>(getRecur()).monthList(Arrays.stream(month)
                .map(m -> net.fortuna.ical4j.model.Month.valueOf(m.getValue()))
                .collect(Collectors.toList())).build());
    }

    /**
     * The end date of the recurrence (i.e. until).
     *
     * @param endDate
     * @return
     */
    public Schedule<T> until(T endDate) {
        return new Schedule<>(new Recur.Builder<>(getRecur()).until(endDate).build());
    }

    /**
     * The total number of occurrences (i.e. count).
     *
     * @param count
     * @return
     */
    public Schedule<T> times(int count) {
        return new Schedule<>(new Recur.Builder<>(getRecur()).count(count).build());
    }
}
