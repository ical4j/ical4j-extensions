package net.fortuna.ical4j.extensions.strategy.entity

import net.fortuna.ical4j.vcard.ContentBuilder
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind
import spock.lang.Specification

class IndividualTest extends Specification {

    def 'test kind is set correctly'() {
        expect: 'kind == individual for new instances'
        new Individual().get().kind == ImmutableKind.INDIVIDUAL

        and: 'kind is updated correctly when using a prototype'
        def prototype = new ContentBuilder().entity {
            kind ImmutableKind.ORG
        }
        new Individual().withPrototype(prototype).get().kind == ImmutableKind.INDIVIDUAL

        and: 'kind is updated correctly for existing instances'
        def entity = new ContentBuilder().entity {
            kind ImmutableKind.ORG
        }
        new Individual().withPrototype(entity).get().kind == ImmutableKind.INDIVIDUAL
    }

    def 'test template with name creation'() {
        when: 'individual is created from inputs'
        def individual = new Individual().familyName(familyName)
                .givenName(givenName).additionalName(additionalNames).prefix(prefix)
                .suffix(suffix).get()

        then: 'N property matches expected string'
        individual.name as String == expectedNString

        where:
        familyName | givenName | additionalNames | prefix   | suffix | expectedNString
        'Bloggs'   | 'Joe'     | 'Xavier'        | 'Mr.'    | 'Esq.' | 'N:Bloggs;Joe;Xavier;Mr.;Esq.\r\n'
        'Fields'   | 'Sally'   | ['Rosemary', 'Lavender'] as String[]
                                                 | 'Dr.'    | 'Jr.'  | 'N:Fields;Sally;Rosemary,Lavender;Dr.;Jr.\r\n'
    }
}
