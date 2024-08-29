package net.fortuna.ical4j.extensions.strategy.vcard;

import net.fortuna.ical4j.vcard.GeneralPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Organization {

    private final List<String> names = new ArrayList<>();

    public Organization name(String... name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    public VCard apply(VCard vCard) {
        vCard.with(GeneralPropertyModifiers.KIND, ImmutableKind.ORG);
        names.forEach(name -> vCard.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        return vCard;
    }
}
