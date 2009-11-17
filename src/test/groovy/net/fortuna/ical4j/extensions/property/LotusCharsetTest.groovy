package net.fortuna.ical4j.extensions.property



/**
 * @author fortuna
 *
 */
public class LotusCharsetTest extends GroovyTestCase {

    void testFactory() {
        def prop = LotusCharset.FACTORY.createProperty(null, null, "UTF-8")
        assert prop.value == LotusCharset.UTF8
    }
    
}
