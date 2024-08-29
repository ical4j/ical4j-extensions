module ical4j.extensions {
    requires java.base;
    requires ical4j.core;
    requires ical4j.vcard;

    requires org.threeten.extra;
    requires static org.codehaus.groovy;

    exports net.fortuna.ical4j.extensions.model.alarm;
    exports net.fortuna.ical4j.extensions.caldav.parameter;
    exports net.fortuna.ical4j.extensions.caldav.property;
    exports net.fortuna.ical4j.extensions.model.concept;
    exports net.fortuna.ical4j.extensions.data;
    exports net.fortuna.ical4j.extensions.groupwise;
    exports net.fortuna.ical4j.extensions.model.link;
    exports net.fortuna.ical4j.extensions.model.location;
    exports net.fortuna.ical4j.extensions.lotus;
    exports net.fortuna.ical4j.extensions.outlook;
    exports net.fortuna.ical4j.extensions.model.parameter;
    exports net.fortuna.ical4j.extensions.model.participant;
    exports net.fortuna.ical4j.extensions.model.property;
    exports net.fortuna.ical4j.extensions.validate;
}
