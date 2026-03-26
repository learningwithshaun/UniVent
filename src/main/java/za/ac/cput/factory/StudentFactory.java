package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

import java.util.List;

/**Student name: Samukelo Ndlela
 * Student number: 231116144
 * Group: 3H
 * StudentFactory.java
 * Date: 22 March 2026
 * **/

public class StudentFactory {

    public static Student createStudent( String name,
                                         String email,
                                         String password,
                                         String phoneNumber,
                                         String studentNumber,
                                         String faculty,
                                         String department,
                                         int yearOfStudy,
                                         List<Booking> bookings){

        if (Helper.isNullOrEmpty(name))
            throw new IllegalArgumentException("Name is required");

        if (!Helper.isValidEmail(email))
            throw new IllegalArgumentException("Invalid email");

        if (Helper.isNullOrEmpty(password))
            throw new IllegalArgumentException("Password is required");

        if (!Helper.isValidPhone(phoneNumber))
            throw new IllegalArgumentException("Invalid phone number");

        if (Helper.isNullOrEmpty(studentNumber))
            throw new IllegalArgumentException("Student number is required");

        if (Helper.isNullOrEmpty(faculty))
            throw new IllegalArgumentException("Faculty is required");

        if (Helper.isNullOrEmpty(department))
            throw new IllegalArgumentException("Department is required");

        if (!Helper.isPositive(yearOfStudy))
            throw new IllegalArgumentException("Year must be greater than 0");

        return new Student.Builder().setName(name)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setStudentNumber(studentNumber)
                .setFaculty(faculty)
                .setDepartment(department)
                .setYearOfStudy(yearOfStudy)
                .setBookings(bookings)
                .build();
    }
}
