package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * A concept typically applied to VRESOURCE objects when embedded metadata for assets is required.
 */
public class AssetType extends ImmutableConcept {


    public enum Urn {
        Asset("urn:ical4j:concept:asset"),

        Vehicle("urn:ical4j:concept:asset:vehicle"),

        Property("urn:ical4j:concept:asset:property"),

        ConfigurationItem("urn:ical4j:concept:asset:configuration_item");

        private final URI uri;

        Urn(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final AssetType VEHICLE = new AssetType(Urn.Vehicle);

    public static final AssetType PROPERTY = new AssetType(Urn.Property);

    public static final AssetType CONFIGURATION_ITEM = new AssetType(Urn.ConfigurationItem);

    public AssetType(Urn urn) {
        super(urn.getUri());
    }
}
