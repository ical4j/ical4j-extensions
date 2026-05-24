package net.fortuna.ical4j.extensions.lotus

import spock.lang.Specification

class CharsetSpec extends Specification {

    def 'factory creates UTF-8 charset property'() {
        expect:
        new Charset.Factory().createProperty(null, 'UTF-8') == ImmutableCharset.UTF8
    }
}
