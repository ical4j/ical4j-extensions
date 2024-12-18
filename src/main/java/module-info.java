module ical4j.extensions {
    requires java.base;
    requires ical4j.core;
    requires ical4j.vcard;

    requires org.threeten.extra;
    requires static org.codehaus.groovy;

    exports net.fortuna.ical4j.extensions.data;
    exports net.fortuna.ical4j.extensions.model.alarm;
    exports net.fortuna.ical4j.extensions.model.concept;
    exports net.fortuna.ical4j.extensions.model.link;
    exports net.fortuna.ical4j.extensions.model.location;
    exports net.fortuna.ical4j.extensions.model.parameter;
    exports net.fortuna.ical4j.extensions.model.participant;
    exports net.fortuna.ical4j.extensions.model.property;
    exports net.fortuna.ical4j.extensions.caldav.parameter;
    exports net.fortuna.ical4j.extensions.caldav.property;
    exports net.fortuna.ical4j.extensions.groupwise;
    exports net.fortuna.ical4j.extensions.lotus;
    exports net.fortuna.ical4j.extensions.outlook;
    exports net.fortuna.ical4j.extensions.validate;
    exports net.fortuna.ical4j.extensions.strategy;
    exports net.fortuna.ical4j.extensions.strategy.availability;
    exports net.fortuna.ical4j.extensions.strategy.action;
    exports net.fortuna.ical4j.extensions.strategy.entity;
    exports net.fortuna.ical4j.extensions.strategy.event;
    exports net.fortuna.ical4j.extensions.strategy.note;
    exports net.fortuna.ical4j.extensions.strategy.report;
    exports net.fortuna.ical4j.extensions.strategy.observance;
    exports net.fortuna.ical4j.extensions.strategy.issue;
    exports net.fortuna.ical4j.extensions.strategy.request;
}
