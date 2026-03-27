package za.ac.cput.repositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.BookingStatusEnum;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Event;
import za.ac.cput.repository.BookingRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingRepositoryTest {

    private BookingRepository repo;
    private Booking booking1;
    private Student student;
    private Event event;

    @BeforeEach
    public void setUp() {
        repo = BookingRepository.getRepository();

        student = new Student.Builder()
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

        event = new Event.Builder()
                .setEventId(201)
                .setName("Tech Talk")
                .setDescription("Tech Event")
                .setOrganizer(null)
                .setDateTime("2026-03-25 10:00")
                .setMaxAttendees(100)
                .build();

        booking1 = new Booking.Builder()
                .setBookingId(301)
                .setStudent(student)
                .setEvent(event)
                .setStatus(BookingStatusEnum.CONFIRMED)
                .build();

        repo.create(booking1);
    }

    @Test
    public void testCreate() {
        Booking booking2 = new Booking.Builder()
                .setBookingId(302)
                .setStudent(student)
                .setEvent(event)
                .setStatus(BookingStatusEnum.PENDING)
                .build();

        Booking created = repo.create(booking2);
        assertNotNull(created);
        assertEquals(302, created.getBookingId());
    }

    @Test
    public void testRead() {
        Booking found = repo.read(301);
        assertNotNull(found);
        assertEquals(BookingStatusEnum.CONFIRMED, found.getStatus());
    }

    @Test
    public void testUpdate() {
        booking1.setStatus(BookingStatusEnum.CANCELLED);
        Booking updated = repo.update(booking1);
        assertNotNull(updated);
        assertEquals(BookingStatusEnum.CANCELLED, updated.getStatus());
    }

    @Test
    public void testDelete() {
        boolean deleted = repo.delete(301);
        assertTrue(deleted);
        assertNull(repo.read(301));
    }

    @Test
    public void testGetAll() {
        List<Booking> allBookings = repo.getAll();
        assertFalse(allBookings.isEmpty());
    }
}
