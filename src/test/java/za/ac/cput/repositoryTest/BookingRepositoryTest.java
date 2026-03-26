package za.ac.cput.repositoryTest;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.BookingStatusEnum;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Event;
import za.ac.cput.repository.BookingRepository;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Student name: Nondumiso
 * Student number: 222703768
 * Group: 3H
 * BookingRepositoryTest.java
 * Date: 25 March 2026
 **/

public class BookingRepositoryTest {

    private BookingRepository repository;
    private Booking booking1, booking2;
    private Student student1, student2;
    private Event event1, event2;

    @Before
    public void setUp() {
        repository = BookingRepository.getRepository();

        // Use Builder pattern or Factory from domain classes
        student1 = new Student.Builder()
                .setUserId(101)
                .setName("Nondumiso")
                .setEmail("nondumiso@gmail.com")
                .setPassword("1234")
                .setPhoneNumber("0812345678")
                .setStudentNumber("220123456")
                .setFaculty("Informatics")
                .setDepartment("Applications Development")
                .setYearOfStudy(2)
                .build();

        student2 = new Student.Builder()
                .setUserId(102)
                .setName("John")
                .setEmail("john@gmail.com")
                .setPassword("1234")
                .setPhoneNumber("0823456789")
                .setStudentNumber("220654321")
                .setFaculty("Informatics")
                .setDepartment("Applications Development")
                .setYearOfStudy(2)
                .build();

        event1 = new Event.Builder()
                .setEventId(201)
                .setName("Tech Talk")
                .setDescription("Tech Event")
                .setOrganizer(null) // If you have an organizer, use Builder here
                .setDateTime("2026-03-25 10:00")
                .setMaxAttendees(100)
                .build();

        event2 = new Event.Builder()
                .setEventId(202)
                .setName("Workshop")
                .setDescription("Hands-on Event")
                .setOrganizer(null)
                .setDateTime("2026-03-26 14:00")
                .setMaxAttendees(50)
                .build();

        booking1 = new Booking.Builder()
                .setBookingId(301)
                .setStudent(student1)
                .setEvent(event1)
                .setStatus(BookingStatusEnum.valueOf("CONFIRMED"))
                .build();

        booking2 = new Booking.Builder()
                .setBookingId(302)
                .setStudent(student2)
                .setEvent(event2)
                .setStatus(BookingStatusEnum.valueOf("PENDING"))
                .build();

        repository.create(booking1);
        repository.create(booking2);
    }

    @Test
    public void testCreate() {
        Booking booking3 = new Booking.Builder()
                .setBookingId(303)
                .setStudent(student1)
                .setEvent(event2)
                .setStatus(BookingStatusEnum.valueOf("CONFIRMED"))
                .build();

        Booking created = repository.create(booking3);
        assertNotNull(created);
    }

    @Test
    public void testRead() {
        Booking readBooking = repository.read(301);
        assertNotNull(readBooking);
        assertEquals("CONFIRMED", readBooking.getStatus());
    }

    @Test
    public void testUpdate() {
        booking1.setStatus("CANCELLED");
        Booking updated = repository.update(booking1);
        assertNotNull(updated);
        assertEquals("CANCELLED", updated.getStatus());
    }

    @Test
    public void testDelete() {
        boolean deleted = repository.delete(302);
        assertTrue(deleted);
        assertNull(repository.read(302));
    }

    @Test
    public void testGetAll() {
        List<Booking> all = repository.getAll();
        assertFalse(all.isEmpty());
        assertTrue(all.size() >= 2);
    }

    @Test
    public void testFindByStatus() {
        List<Booking> confirmed = repository.findByStatus("CONFIRMED");
        assertFalse(confirmed.isEmpty());
        assertEquals(1, confirmed.size());
    }

    @Test
    public void testFindByStudentId() {
        List<Booking> studentBookings = repository.findByStudentId(101);
        assertFalse(studentBookings.isEmpty());
        assertEquals(1, studentBookings.size());
    }

    @Test
    public void testFindByEventId() {
        List<Booking> eventBookings = repository.findByEventId(201);
        assertFalse(eventBookings.isEmpty());
        assertEquals(1, eventBookings.size());
    }
}