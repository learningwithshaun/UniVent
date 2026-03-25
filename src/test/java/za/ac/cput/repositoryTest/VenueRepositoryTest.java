package za.ac.cput.repositoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Venue;
import za.ac.cput.factory.VenueFactory;
import za.ac.cput.repository.VenueRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VenueRepositoryTest {

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
    public void createVenueWithEmptyCampus() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> VenueFactory.createVenue(
                        3,
                        "Auditorium",
                        "",
                        "Block C",
                        400
                )
        );
        assertEquals("Campus cannot be empty", exception.getMessage());
    }

    @Test
    public void createVenueWithInvalidCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> VenueFactory.createVenue(
                        4,
                        "Conference Room",
                        "East Campus",
                        "Building D",
                        -50
                )
        );
        assertEquals("Capacity must be greater than 0", exception.getMessage());
    }

    @Test
    public void createVenueWithInvalidId() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> VenueFactory.createVenue(
                        0,
                        "Lecture Theatre",
                        "West Campus",
                        "Block E",
                        200
                )
        );
        assertEquals("Venue ID must be greater than 0", exception.getMessage());
    }

    @Test
    public void testCheckAvailability() {
        Venue venue = VenueFactory.createVenue(
                5,
                "Sports Hall",
                "South Campus",
                "Block F",
                500
        );

        assertTrue(venue.checkAvailability(300));   // within capacity
        assertFalse(venue.checkAvailability(600));  // exceeds capacity
    }

    @Test
    public void testUpdateVenueDetails() {
        Venue venue = VenueFactory.createVenue(
                6,
                "Old Hall",
                "North Campus",
                "Block G",
                200
        );

        venue.updateVenueDetails("New Hall", "East Campus", "Block H", 400);

        assertEquals("New Hall", venue.getVenueName());
        assertEquals("East Campus", venue.getCampus());
        assertEquals("Block H", venue.getLocationDetails());
        assertEquals(400, venue.getCapacity());
    }

    // ✅ Repository CRUD tests
    @Test
    public void testRepositoryCRUD() {
        VenueRepository repo = VenueRepository.getInstance();

        // Create
        Venue venue = VenueFactory.createVenue(
                7,
                "Library Hall",
                "Main Campus",
                "Block Z",
                250
        );
        repo.create(venue);

        // Read
        Venue found = repo.read(7);
        assertNotNull(found);
        assertEquals("Library Hall", found.getVenueName());

        // Update
        venue.updateVenueDetails("Updated Hall", "Updated Campus", "Updated Block", 300);
        repo.update(venue);
        Venue updated = repo.read(7);
        assertEquals("Updated Hall", updated.getVenueName());
        assertEquals(300, updated.getCapacity());

        // GetAll
        List<Venue> allVenues = repo.getAll();
        assertFalse(allVenues.isEmpty());

        // Delete
        boolean deleted = repo.delete(7);
        assertTrue(deleted);
        assertNull(repo.read(7));
    }
}

