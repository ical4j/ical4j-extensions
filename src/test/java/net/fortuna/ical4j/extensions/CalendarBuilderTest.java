/**
 * This file is part of Base Modules.
 *
 * Copyright (c) 2010, Ben Fortuna [fortuna@micronode.com]
 *
 * Base Modules is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Base Modules is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Base Modules.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.fortuna.ical4j.extensions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarParser;
import net.fortuna.ical4j.data.CalendarParserFactory;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.extensions.property.MSOlkOriginalEnd;
import net.fortuna.ical4j.extensions.property.MSOlkOriginalStart;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ParameterFactoryRegistry;
import net.fortuna.ical4j.model.PropertyFactoryRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * @author Ben
 *
 */
@RunWith(Parameterized.class)
public class CalendarBuilderTest {

    private CalendarBuilder builder;
    
    private String filename;
    
    private boolean expectedValid;
    
    public CalendarBuilderTest(String filename, boolean expectedValid) {
        this.filename = filename;
        this.expectedValid = expectedValid;
    }
    
    @Before
    public void setUp() {
        CalendarParser parser = CalendarParserFactory.getInstance().createParser();
        
        PropertyFactoryRegistry propertyFactoryRegistry = new PropertyFactoryRegistry();
        propertyFactoryRegistry.register(MSOlkOriginalStart.PROPERTY_NAME, MSOlkOriginalStart.FACTORY);
        propertyFactoryRegistry.register(MSOlkOriginalEnd.PROPERTY_NAME, MSOlkOriginalEnd.FACTORY);
        
        ParameterFactoryRegistry parameterFactoryRegistry = new ParameterFactoryRegistry();
        
        TimeZoneRegistry tzRegistry = TimeZoneRegistryFactory.getInstance().createRegistry();
        
        builder = new CalendarBuilder(parser, propertyFactoryRegistry, parameterFactoryRegistry, tzRegistry);
    }
    
    @Test
    public void testBuild() throws FileNotFoundException, IOException, ParserException, ValidationException {
        Calendar calendar = builder.build(getClass().getResourceAsStream(filename));
        try {
            calendar.validate();
            if (!expectedValid) {
                Assert.fail("Expected invalid calendar");
            }
        }
        catch (ValidationException e) {
            if (expectedValid) {
                Assert.fail(String.format("Expected valid calendar: %s", e.getMessage()));
            }
        }
    }
    
    @Parameters
    public static Collection<Object[]> parameters() {
        List<Object[]> params = new ArrayList<Object[]>();
        params.add(new Object[] { "/samples/Bodypart2.ics", true });
        return params;
    }
}
