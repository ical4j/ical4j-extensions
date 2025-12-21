package net.fortuna.ical4j.extensions.model.concept;

import java.net.URI;

/**
 * A concept typically applied to VJOURNAL objects representing resource links.
 */
public class ResourceType extends ImmutableConcept {

    public static final ResourceType APPLICATION = new ResourceType(Id.Application);

    public static final ResourceType ASSET = new ResourceType(Id.Asset);

    public static final ResourceType COLLECTION = new ResourceType(Id.Collection);

    public static final ResourceType CONFIGURATION_ITEM = new ResourceType(Id.ConfigurationItem);

    public static final ResourceType PROPERTY = new ResourceType(Id.Property);

    public static final ResourceType RESOURCE = new ResourceType(Id.Resource);

    public static final ResourceType VEHICLE = new ResourceType(Id.Vehicle);

    public static final ResourceType WEB_SITE = new ResourceType(Id.WebSite);

    public enum Id {
        Application("semcal:concept:resource:application"),
        Asset("semcal:concept:resource:asset"),
        Book("semcal:concept:resource:book"),
        Collection("semcal:concept:resource:collection"),
        ConfigurationItem("semcal:concept:resource:configuration_item"),
        Property("semcal:concept:resource:property"),
        Resource("semcal:concept:resource"),
        Vehicle("semcal:concept:resource:vehicle"),
        WebSite("semcal:concept:resource:web_site");

        private final URI uri;

        Id(String uri) {
            this.uri = URI.create(uri);
        }

        public URI getUri() {
            return uri;
        }
    }

    public ResourceType(Id id) {
        super(id.getUri());
    }
}
