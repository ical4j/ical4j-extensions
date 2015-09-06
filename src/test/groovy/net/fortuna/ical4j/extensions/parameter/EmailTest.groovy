package net.fortuna.ical4j.extensions.parameter

import spock.lang.Specification

/**
 * Created by fortuna on 6/09/15.
 */
class EmailTest extends Specification {

    def 'assert value stored correctly'() {
        given: 'an email address'
        String address = 'someone@example.com'

        when: 'an email object is constructed'
        Email email = [address]

        then: 'the object value matches the original address'
        email.value == address
    }
}
