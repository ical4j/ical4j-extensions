# iCal4j Extensions

Java support for non-standard extensions to the iCalendar and vCard format specifications.

## Overview

iCal4j Extensions is a Java library that provides additional properties and parameters for iCalendar and vCard object models.
These model extensions are implemented via the custom registry support in iCal4j.

This library also includes a collection of strategies for object model construction using opinionated fields
designed to be more intuitive and easier to use.


## Usage

### Factory Support

To add support for extensions you may register the required factories with your CalendarBuilder instance:

        CalendarParser parser = CalendarParserFactory.getInstance().createParser();
        
        PropertyFactoryRegistry propertyFactoryRegistry = new PropertyFactoryRegistry();
        propertyFactoryRegistry.register(WrTimezone.PROPERTY_NAME, WrTimezone.FACTORY);
        propertyFactoryRegistry.register(WrCalName.PROPERTY_NAME, WrCalName.FACTORY);
        
        ParameterFactoryRegistry parameterFactoryRegistry = new ParameterFactoryRegistry();
        
        TimeZoneRegistry tzRegistry = TimeZoneRegistryFactory.getInstance().createRegistry();
        
        builder = new CalendarBuilder(parser, propertyFactoryRegistry, parameterFactoryRegistry, tzRegistry);

### Strategies

TBD.


## Minimum requirements

iCal4j Extensions requires a minimum of Java 11.


## References:

* [draft-ietf-calext-eventpub-extensions] - Event Publishing Extensions to iCalendar
* [draft-ietf-calext-valarm-extensions] - VALARM Extensions for iCalendar
* [draft-apthorp-ical-tasks] - Task Extensions to iCalendar
* [draft-ietf-calext-ical-relations] - Support for iCalendar Relationships
* [draft-ietf-calext-icalendar-series] - Support for Series in iCalendar

* [RFC6638] - Scheduling Extensions to CalDAV
* [RFC8607] - Calendaring Extensions to WebDAV (CalDAV): Managed Attachments

[draft-ietf-calext-eventpub-extensions]: https://datatracker.ietf.org/doc/html/draft-ietf-calext-eventpub-extensions-19

[draft-ietf-calext-valarm-extensions]: https://datatracker.ietf.org/doc/html/draft-ietf-calext-valarm-extensions-07

[draft-apthorp-ical-tasks]: https://datatracker.ietf.org/doc/html/draft-apthorp-ical-tasks-02

[draft-ietf-calext-ical-relations]: https://datatracker.ietf.org/doc/html/draft-ietf-calext-ical-relations-06

[draft-ietf-calext-icalendar-series]: https://datatracker.ietf.org/doc/html/draft-ietf-calext-icalendar-series-03

[RFC6638]: https://datatracker.ietf.org/doc/html/rfc6638

[RFC8607]: https://datatracker.ietf.org/doc/html/rfc8607
