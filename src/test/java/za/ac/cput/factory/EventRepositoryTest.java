package za.ac.cput.factory;

/**
 *Name: Uyathandwa
 *Surname: Ngomana
 *Student number: 231173229
 *Group: 3H
 *Description:EventRepositoryTest
 * Date: 25 March 2026
 **/


import org.junit.Test;
import za.ac.cput.domain.Event;
import za.ac.cput.domain.Organizer;
import za.ac.cput.repository.EventRepository;

import static org.junit.Assert.*;

    public class EventRepositoryTest {

        private EventRepository repository = EventRepository.getRepository();

        private Organizer organizer = new Organizer.Builder()
                .setOrganizationName("CPUT Events")
                .setOrganizationType("University")
                .setContactEmail("events@cput.ac.za")
                .build();

        private Event event = new Event.Builder()
                .setEventId(1)
                .setName("Tech Conference")
                .setDescription("Annual Tech Event")
                .setOrganizer(organizer)
                .setDateTime("2026-05-20 10:00")
                .setMaxAttendees(200)
                .build();

        @Test
        public void create() {
            Event created = repository.create(event);
            assertNotNull(created);
            assertEquals(1, created.getEventId());
        }

        @Test
        public void read() {
            repository.create(event);
            Event read = repository.read(1);
            assertNotNull(read);
        }

        @Test
        public void update() {

            Event updatedEvent = new Event.Builder()
                    .setEventId(1)
                    .setName("Updated Conference")
                    .setDescription("Updated Description")
                    .setOrganizer(organizer)
                    .setDateTime("2026-05-20 10:00")
                    .setMaxAttendees(300)
                    .build();

            repository.create(event);
            Event updated = repository.update(updatedEvent);

            assertNotNull(updated);
            assertEquals("Updated Conference", updated.getName());
        }

        @Test
        public void delete() {
            repository.create(event);
            boolean deleted = repository.delete(1);
            assertTrue(deleted);
        }

        @Test
        public void getAll() {
            repository.create(event);
            assertFalse(repository.getAll().isEmpty());
        }

        @Test
        public void findByName() {
            repository.create(event);
            Event found = repository.findByName("Tech Conference");
            assertNotNull(found);
        }

        @Test
        public void findByOrganizer() {
            repository.create(event);
            assertFalse(repository.findByOrganizer(organizer).isEmpty());
        }
    }

