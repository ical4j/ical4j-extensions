package net.fortuna.ical4j.extensions.concept;

import java.net.URI;

/**
 * A concept typically applied to VRESOURCE objects when embedded metadata for assets is required.
 */
public class AssetType extends ImmutableConcept {


    public enum Id {
        Asset("ical4j:concept:asset"),

        Vehicle("ical4j:concept:asset:vehicle"),

        Property("ical4j:concept:asset:property"),

        ConfigurationItem("ical4j:concept:asset:configuration_item");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public static final AssetType VEHICLE = new AssetType(Id.Vehicle);

    public static final AssetType PROPERTY = new AssetType(Id.Property);

    public static final AssetType CONFIGURATION_ITEM = new AssetType(Id.ConfigurationItem);

    public AssetType(Id id) {
        super(id.getUri());
    }
}
