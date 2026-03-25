package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Venue;
import za.ac.cput.factory.VenueFactory;

import static org.junit.jupiter.api.Assertions.*;

public class VenueFactoryTest {

    @Test
    public void createValidVenue() {
        Venue venue = VenueFactory.createVenue(
                1,
                "Main Hall",
                "Central Campus",
                "Building A, Floor 2",
                500
        );

        assertNotNull(venue);
        assertEquals(1, venue.getVenueId());
        assertEquals("Main Hall", venue.getVenueName());
        assertEquals("Central Campus", venue.getCampus());
        assertEquals("Building A, Floor 2", venue.getLocationDetails());
        assertEquals(500, venue.getCapacity());
    }

    @Test
    public void createVenueWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> VenueFactory.createVenue(
                        2,
                        "",
                        "North Campus",
                        "Block B",
                        300
                )
        );
        assertEquals("Venue name cannot be empty", exception.getMessage());
    }

    @Test
    public void createVenueWithInvalidCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> VenueFactory.createVenue(
                        3,
                        "Auditorium",
                        "South Campus",
                        "Block C",
                        -10
                )
        );
        assertEquals("Capacity must be greater than 0", exception.getMessage());
    }
}
