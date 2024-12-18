package net.fortuna.ical4j.extensions.data;

import net.fortuna.ical4j.data.CalendarParser;
import net.fortuna.ical4j.data.ContentHandler;
import net.fortuna.ical4j.data.ParserException;

import java.io.*;

/**
 * Support parsing CSV files to produce {@link net.fortuna.ical4j.model.Calendar} objects.
 */
public class CalendarCSVParser implements CalendarParser {

    private final String componentName;

    public CalendarCSVParser(String componentName) {
        this.componentName = componentName;
    }

    @Override
    public void parse(InputStream inputStream, ContentHandler contentHandler) throws IOException, ParserException {
        parse(new InputStreamReader(inputStream), contentHandler);
    }

    @Override
    public void parse(Reader reader, ContentHandler contentHandler) throws IOException, ParserException {
        try (BufferedReader in = new BufferedReader(reader)) {
            contentHandler.startCalendar();

            String[] properties = in.readLine().split(",");
            String line;
            while ((line = in.readLine()) != null) {
                contentHandler.startComponent(componentName);
                String[] values = line.split(",");
                for (int i = 0; i < properties.length; i++) {
                    contentHandler.startProperty(properties[i]);
                    contentHandler.propertyValue(values[i]);
                    contentHandler.endProperty(properties[i]);
                }
                contentHandler.endComponent(componentName);
            }

            contentHandler.endCalendar();
        }
    }
}
