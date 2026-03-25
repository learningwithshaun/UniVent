package za.ac.cput.repositoryTest;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Organizer;
import za.ac.cput.factory.OrganizerFactory;
import za.ac.cput.repository.OrganizerRepository;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**Student name: Amanda Msutu
 * Student number: 222428600
 * Group: 3H
 * OrganizerRepositoryTest.java
 * Date: 25 March 2026
 * **/

public class OrganizerRepositoryTest {
    private OrganizerRepository repository;
    private Organizer organizer;

    @Before
    public void setUp(){
        repository = OrganizerRepository.getRepository();
        organizer = OrganizerFactory.createOrganizer("Amanda", "amandamsutu02@gmail.com", "123", "0848882617", "Bitdevs", "NGO", new ArrayList<>(), "bitdevs@gmail.com");
        repository.create(organizer);
    }

    @Test
    public void testCreate(){
        Organizer created = repository.create(organizer);
        assertNotNull(created);
        assertEquals(organizer.getUserId(), created.getUserId());
    }

    @Test
    public void testRead() {
        Organizer found = repository.read(organizer.getUserId());
        assertNotNull(found);
        assertEquals(organizer.getUserId(), found.getUserId());
    }

    @Test
    public void testUpdate() {
        Organizer updatedOrganizer = new Organizer.Builder()
                .setUserId(organizer.getUserId())
                .setName("Updated Organizer")
                .setEmail(organizer.getEmail())
                .setPassword(organizer.getPassword())
                .setPhoneNumber(organizer.getPhoneNumber())
                .setOrganizationName(organizer.getOrganizationName())
                .setOrganizationType(organizer.getOrganizationType())
                .setEvents(new ArrayList<>())
                .setContactEmail(organizer.getContactEmail())
                .build();

        Organizer updated = repository.update(updatedOrganizer);
        assertNotNull(updated);
        assertEquals("Updated Organizer", updated.getName());
    }

    @Test
    public void testDelete() {
        boolean deleted = repository.delete(organizer.getUserId());
        assertTrue(deleted);
    }

    @Test
    public void testGetAll() {
        assertFalse(repository.getAll().isEmpty());
    }
}
