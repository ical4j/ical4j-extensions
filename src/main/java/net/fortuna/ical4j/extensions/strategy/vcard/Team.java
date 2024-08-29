package net.fortuna.ical4j.extensions.strategy.vcard;

import net.fortuna.ical4j.vcard.GeneralPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.OrganizationalPropertyModifiers;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Member;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private final List<String> names = new ArrayList<>();

    private final List<URI> members = new ArrayList<>();

    public Team name(String... name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    public Team member(URI... member) {
        members.addAll(Arrays.asList(member));
        return this;
    }

    public VCard apply(VCard vCard) {
        vCard.with(GeneralPropertyModifiers.KIND, ImmutableKind.GROUP);
        names.forEach(name -> vCard.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        members.forEach(member -> vCard.with(OrganizationalPropertyModifiers.MEMBER, new Member(member)));
        return vCard;
    }
}
