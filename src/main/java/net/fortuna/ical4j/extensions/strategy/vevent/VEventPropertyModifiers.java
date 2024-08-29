package net.fortuna.ical4j.extensions.strategy.vevent;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.*;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.CalAdrUri;
import net.fortuna.ical4j.vcard.property.Fn;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;

public interface VEventPropertyModifiers {

    ParameterList ATT_REQUIRED_PARAMS = new ParameterList(Arrays.asList(
            CuType.INDIVIDUAL, Role.REQ_PARTICIPANT, PartStat.NEEDS_ACTION, Rsvp.TRUE));

    ParameterList ATT_OPTIONAL_PARAMS = new ParameterList(Arrays.asList(
            CuType.INDIVIDUAL, Role.OPT_PARTICIPANT, PartStat.NEEDS_ACTION));

    ParameterList ATT_CHAIR_PARAMS = new ParameterList(Arrays.asList(
            CuType.INDIVIDUAL, Role.CHAIR));

    BiFunction<VEvent, VCard, VEvent> ORGANIZER = (c, p) -> {
        if (p != null) {
            CalAdrUri uri = p.getRequiredProperty(PropertyName.CALADRURI);
            Fn name = p.getRequiredProperty(PropertyName.FN);
            c.add(new Organizer(new ParameterList(Collections.singletonList(new Cn(name.getValue()))),
                    uri.getUri()));
        }
        return c;
    };

    BiFunction<VEvent, Participant, VEvent> REQUIRED_ATTENDEE = (c, p) -> {
        if (p != null) {
            c.add(new Attendee(ATT_REQUIRED_PARAMS, p));
            c.add(p);
        }
        return c;
    };

    BiFunction<VEvent, Participant, VEvent> OPTIONAL_ATTENDEE = (c, p) -> {
        if (p != null) {
            c.add(new Attendee(ATT_OPTIONAL_PARAMS, p));
            c.add(p);
        }
        return c;
    };

    BiFunction<VEvent, Participant, VEvent> CHAIR = (c, p) -> {
        if (p != null) {
            c.replace(new Attendee(ATT_CHAIR_PARAMS, p));
            c.add(p);
        }
        return c;
    };
}
