package za.ac.cput.factoryTest;

import org.junit.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**Student name: Samukelo Ndlela
 * Student number: 231116144
 * Group: 3H
 * StudentFactoryTest.java
 * Date: 22 March 2026
 * **/

public class StudentFactoryTest {
    @Test
    public void createValidStudent() {
        Student student = StudentFactory.createStudent(
                "Samukelo",
                "sam@gmail.com",
                "1234",
                "0615436768",
                "320223456",
                "Informatics & Design",
                "Applications Development",
                2,
                null

        );

        assertNotNull(student);
        assertEquals("Samukelo", student.getName());
        assertEquals("sam@gmail.com", student.getEmail());
    }

    @Test
     public void createStudentWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "Spitjo",
                    "invalidemail",
                    "1234",
                    "0812345678",
                    "220123456",
                    "IT",
                    "ADP",
                    2,
                    null
            );
        });

        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    public void createStudentWithBookings() {

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking.Builder().setBookingId(1).build());

        Student student = StudentFactory.createStudent(
                "Samukelo",
                "sam@gmail.com",
                "1234",
                "0812543678",
                "320223456",
                "IT",
                "ADP",
                2,
                bookings
        );

        assertNotNull(student.getBookings());
        assertEquals(1, student.getBookings().size());
    }

    @Test
    public void createStudentWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "",
                    "sam@gmail.com",
                    "1234",
                    "0812345678",
                    "220123456",
                    "IT",
                    "ADP",
                    2,
                    null
            );
        });

        assertEquals("Name is required", exception.getMessage());
    }

    @Test
    public void createStudentWithInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "Sam",
                    "sam@gmail.com",
                    "1234",
                    "123", // invalid
                    "220123456",
                    "IT",
                    "ADP",
                    2,
                    null
            );
        });

        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void createStudentWithInvalidYear() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "Sam",
                    "sam@gmail.com",
                    "1234",
                    "0812345678",
                    "220123456",
                    "IT",
                    "ADP",
                    0,
                    null
            );
        });

        assertEquals("Year must be greater than 0", exception.getMessage());
    }
}
