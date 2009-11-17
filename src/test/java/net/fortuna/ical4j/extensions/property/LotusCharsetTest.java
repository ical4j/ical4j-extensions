/**
 * This file is part of Base Modules.
 *
 * Copyright (c) 2009, Ben Fortuna [fortuna@micronode.com]
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

package net.fortuna.ical4j.extensions.property;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import junit.framework.Assert;

import org.junit.Test;


/**
 * @author fortuna
 *
 */
public class LotusCharsetTest {

    @Test
    public void testFactoryUTF8() throws IOException, URISyntaxException, ParseException {
        LotusCharset property = (LotusCharset) LotusCharset.FACTORY.createProperty(null, null, "UTF-8");
        Assert.assertEquals(LotusCharset.UTF8, property);
    }
}
