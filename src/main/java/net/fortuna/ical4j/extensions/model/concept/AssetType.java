package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * A concept typically applied to VRESOURCE objects when embedded metadata for assets is required.
 */
public class AssetType extends ImmutableConcept {


    public enum Id {
        Asset("semcal:concept:asset"),

        Vehicle("semcal:concept:asset:vehicle"),

        Property("semcal:concept:asset:property"),

        ConfigurationItem("semcal:concept:asset:configuration_item");

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
