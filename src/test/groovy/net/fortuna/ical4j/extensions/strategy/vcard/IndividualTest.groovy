package net.fortuna.ical4j.extensions.strategy.vcard

import net.fortuna.ical4j.vcard.ContentBuilder
import net.fortuna.ical4j.vcard.VCard
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind
import spock.lang.Specification

class IndividualTest extends Specification {

    def 'test kind is set correctly'() {
        expect: 'kind == individual for new instances'
        new Individual().apply(new VCard()).kind.orElseThrow() == ImmutableKind.INDIVIDUAL

        and: 'kind is updated correctly when using a prototype'
        VCard prototype = new ContentBuilder().vcard {
            kind ImmutableKind.ORG
        }
        new Individual().apply(prototype).kind.orElseThrow() == ImmutableKind.INDIVIDUAL

        and: 'kind is updated correctly for existing instances'
        VCard card = new ContentBuilder().vcard {
            kind ImmutableKind.ORG
        }
        new Individual().apply(card).kind.orElseThrow() == ImmutableKind.INDIVIDUAL
    }

    def 'test template with name creation'() {
        when: 'individual is created from inputs'
        def individual = new Individual().familyName(familyName)
                .givenName(givenName).additionalName(additionalNames).prefix(prefix)
                .suffix(suffix).apply(new VCard())

        then: 'N property matches expected string'
        individual.n.orElseThrow() as String == expectedNString

        where:
        familyName | givenName | additionalNames | prefix   | suffix | expectedNString
        'Bloggs'   | 'Joe'     | 'Xavier'        | 'Mr.'    | 'Esq.' | 'N:Bloggs;Joe;Xavier;Mr.;Esq.\r\n'
        'Fields'   | 'Sally'   | ['Rosemary', 'Lavender'] as String[]
                                                 | 'Dr.'    | 'Jr.'  | 'N:Fields;Sally;Rosemary,Lavender;Dr.;Jr.\r\n'
    }
}
