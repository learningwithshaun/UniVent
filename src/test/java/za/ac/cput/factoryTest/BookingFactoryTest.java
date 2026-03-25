package za.ac.cput.factoryTest;

import org.junit.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.BookingStatusEnum;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Event;
import java.time.LocalDateTime;
import static org.junit.Assert.*;
import za.ac.cput.factory.BookingFactory;

public class BookingFactoryTest {

    @Test
    public void createValidBooking() {
        Student student = new Student.Builder()
                .setName("Samukelo") // IntelliJ may flag this as a typo, but it's fine
                .setEmail("sam@gmail.com")
                .setPassword("1234")
                .setPhoneNumber("0812345678")
                .setStudentNumber("320223456")
                .setFaculty("Informatics")
                .setDepartment("Applications Development")
                .yearOfStudy(2)
                .build();

        Event event = new Event.Builder()
                .setName("Tech Talk")
                .setDescription("Java Workshop")
                .setDateTime("2026-05-10 10:00")
                .setMaxAttendees(100)
                .build();

        Booking booking = BookingFactory.createBooking(
                1,
                LocalDateTime.now().plusDays(1),
                BookingStatusEnum.CONFIRMED,
                student,
                event
        );

        assertNotNull(booking);
        assertEquals(1, booking.getBookingId());
        assertEquals(BookingStatusEnum.CONFIRMED, booking.getStatus());

        // ✅ Use getters to clear warnings
        assertNotNull(booking.getBookingDate());
        assertEquals(student, booking.getStudent());
        assertEquals(event, booking.getEvent());
    }

    @Test
    public void createBookingWithInvalidId() {
        Student student = new Student.Builder().setName("Sam").setEmail("sam@gmail.com").setPassword("1234")
                .setPhoneNumber("0812345678").setStudentNumber("220123456").setFaculty("IT").setDepartment("ADP")
                .yearOfStudy(2).build();

        Event event = new Event.Builder().setName("Tech Talk").setDescription("Java Workshop")
                .setDateTime("2026-05-10 10:00").setMaxAttendees(100).build();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> BookingFactory.createBooking(
                        0, // invalid ID
                        LocalDateTime.now().plusDays(1),
                        BookingStatusEnum.CONFIRMED,
                        student,
                        event
                ));

        assertEquals("Booking ID must be greater than 0", exception.getMessage());
    }

    @Test
    public void createBookingWithNullStudent() {
        Event event = new Event.Builder().setName("Tech Talk").setDescription("Java Workshop")
                .setDateTime("2026-05-10 10:00").setMaxAttendees(100).build();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> BookingFactory.createBooking(
                        1,
                        LocalDateTime.now().plusDays(1),
                        BookingStatusEnum.CONFIRMED,
                        null, // invalid student
                        event
                ));

        assertEquals("Student is required", exception.getMessage());
    }

    @Test
    public void createBookingWithNullEvent() {
        Student student = new Student.Builder().setName("Sam").setEmail("sam@gmail.com").setPassword("1234")
                .setPhoneNumber("0812345678").setStudentNumber("220123456").setFaculty("IT").setDepartment("ADP")
                .yearOfStudy(2).build();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> BookingFactory.createBooking(
                        1,
                        LocalDateTime.now().plusDays(1),
                        BookingStatusEnum.CONFIRMED,
                        student,
                        null // invalid event
                ));

        assertEquals("Event is required", exception.getMessage());
    }
}
