package bddevlabs.com.bdunittestexample.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class PlaceTest {

    @Test
    public void nullStream() {
        Place place = Place.readFromStream(null);

        assertNull(place);
    }

    @Test
    public void disneyland() {
        InputStream stream = Place.class.getResourceAsStream("/disneyland.txt");
        Place place = Place.readFromStream(stream);

        assertNotNull(place);
        assertEquals("disneyland", place.id);
        assertEquals("Disneyland", place.name);
        assertEquals(
                "1313 Disneyland Dr\n" +
                "Anaheim, CA 92802\n" +
                "\n" +
                "Disneyland Park, originally Disneyland, is the first of two theme parks built at " +
                "the Disneyland Resort in Anaheim, California, opened on July 17, 1955. It is the " +
                "only theme park designed and built under the direct supervision of Walt Disney", place.description);
    }

}