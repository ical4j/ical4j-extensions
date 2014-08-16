[![Build Status](https://drone.io/github.com/ical4j/ical4j-extensions/status.png)](https://drone.io/github.com/ical4j/ical4j-extensions/latest)

Extensions
==========

iCal4j Extensions is a Java library that provides support for widely used non-standard iCalendar objects (i.e. properties and parameters). These model extensions are implemented via the custom object registry support in iCal4j.

## Usage

To add support for extensions you may register the required factories with your CalendarBuilder instance:

        CalendarParser parser = CalendarParserFactory.getInstance().createParser();
        
        PropertyFactoryRegistry propertyFactoryRegistry = new PropertyFactoryRegistry();
        propertyFactoryRegistry.register(WrTimezone.PROPERTY_NAME, WrTimezone.FACTORY);
        propertyFactoryRegistry.register(WrCalName.PROPERTY_NAME, WrCalName.FACTORY);
        
        ParameterFactoryRegistry parameterFactoryRegistry = new ParameterFactoryRegistry();
        
        TimeZoneRegistry tzRegistry = TimeZoneRegistryFactory.getInstance().createRegistry();
        
        builder = new CalendarBuilder(parser, propertyFactoryRegistry, parameterFactoryRegistry, tzRegistry);
        
## Minimum requirements

iCal4j Extensions requires a minimum of Java 5 due to the use of features introduced in this version.
