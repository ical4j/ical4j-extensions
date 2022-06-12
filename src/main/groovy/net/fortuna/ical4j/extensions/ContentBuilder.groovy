/**
 * Copyright (c) 2012, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.extensions

import net.fortuna.ical4j.extensions.property.*
import net.fortuna.ical4j.model.PropertyFactoryWrapper

/**
 * @author fortuna
 *
 */
public class ContentBuilder extends net.fortuna.ical4j.model.ContentBuilder {

    public ContentBuilder(boolean init = true) {
        super(init)
    }
    
    def registerExtendedProperties() {
        // register property factories..
        registerFactory 'calstart', new PropertyFactoryWrapper(CalStart, new CalStart.Factory())
        registerFactory 'liclocation', new PropertyFactoryWrapper(LicLocation, new LicLocation.Factory())
        registerFactory 'wralarmid', new PropertyFactoryWrapper(WrAlarmId, new WrAlarmId.Factory())
        registerFactory 'wrcaldesc', new PropertyFactoryWrapper(WrCalDesc, new WrCalDesc.Factory())
        registerFactory 'wrcalname', new PropertyFactoryWrapper(WrCalName, new WrCalName.Factory())
        registerFactory 'wrtimezone', new PropertyFactoryWrapper(WrTimezone, new WrTimezone.Factory())
    }
}
