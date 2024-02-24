module ical4j.extensions {
    requires java.base;
    requires ical4j.core;
    requires ical4j.vcard;

    requires org.threeten.extra;
    requires static org.codehaus.groovy;

    exports net.fortuna.ical4j.extensions.alarm;
    exports net.fortuna.ical4j.extensions.caldav.parameter;
    exports net.fortuna.ical4j.extensions.caldav.property;
    exports net.fortuna.ical4j.extensions.concept;
    exports net.fortuna.ical4j.extensions.data;
    exports net.fortuna.ical4j.extensions.groupwise;
    exports net.fortuna.ical4j.extensions.link;
    exports net.fortuna.ical4j.extensions.location;
    exports net.fortuna.ical4j.extensions.lotus;
    exports net.fortuna.ical4j.extensions.outlook;
    exports net.fortuna.ical4j.extensions.parameter;
    exports net.fortuna.ical4j.extensions.participant;
    exports net.fortuna.ical4j.extensions.property;
    exports net.fortuna.ical4j.extensions.validate;
}
