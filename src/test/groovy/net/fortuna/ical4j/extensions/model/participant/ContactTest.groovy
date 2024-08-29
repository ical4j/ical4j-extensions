package net.fortuna.ical4j.extensions.model.participant


import net.fortuna.ical4j.vcard.ContentBuilder
import spock.lang.Specification

class ContactTest extends Specification {

    def 'create new contact'() {
        when: 'a contact is created'
        def card = new ContentBuilder().vcard {
            uid '1234'
            fn 'A Contact'
            caladruri 'mailto:contact@example.com'
        }
        def contact = new Contact(card)

        then: 'result matches expected'
        contact as String == '''BEGIN:PARTICIPANT\r
PARTICIPANT-TYPE:CONTACT\r
UID:1234\r
CALENDAR-ADDRESS:mailto:contact@example.com\r
STRUCTURED-DATA;VALUE=BINARY;ENCODING=BASE64;FMTTYPE=text/vcard:QkVHSU46VkNBUkQ\
NClVJRDoxMjM0DQpGTjpBIENvbnRhY3QNCkNBTEFEUlVSSTptYWlsdG86Y29udGFjdEBleGFtcGxlLmNvbQ0KRU5EOlZDQVJEDQo=\r
END:PARTICIPANT\r\n'''
    }
}
