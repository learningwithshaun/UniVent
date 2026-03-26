package za.ac.cput.repositoryTest;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;

import java.util.List;

import static org.junit.Assert.*;
/**Student name: Samukelo Ndlela
 * Student number: 231116144
 * Group: 3H
 * StudentRepositoryTest.java
 * Date: 25 March 2026
 * **/

public class StudentRepositoryTest {
    private StudentRepository repository;
    private Student student;

    @Before
    public void setUp() {
        repository = StudentRepository.getRepository();

        student = StudentFactory.createStudent(
                "Samukelo",
                "sam@gmail.com",
                "1234",
                "0812345678",
                "220123456",
                "Informatics",
                "Applications Development",
                2,
                null
        );

        repository.create(student);
    }

    @Test
    public void testCreate() {
        Student created = repository.create(student);
        assertNotNull(created);
    }

    @Test
    public void testRead() {
        Student found = repository.read(student.getUserId());
        assertNotNull(found);
    }

    @Test
    public void testUpdate() {
        Student updated = new Student.Builder()
                .setUserId(student.getUserId())
                .setName("Updated")
                .setEmail(student.getEmail())
                .setPassword(student.getPassword())
                .setPhoneNumber(student.getPhoneNumber())
                .setStudentNumber(student.getStudentNumber())
                .setFaculty(student.getFaculty())
                .setDepartment(student.getDepartment())
                .setYearOfStudy(student.getYearOfStudy())
                .build();

        repository.update(updated);

        Student result = repository.read(student.getUserId());
        assertEquals("Updated", result.getName());
    }

    @Test
    public void testDelete() {
        boolean deleted = repository.delete(student.getUserId());
        assertTrue(deleted);
    }

    @Test
    public void testFindByStudentNumber() {
        Student found = repository.findByStudentNumber("220123456");
        assertNotNull(found);
    }

    @Test
    public void testFindByYearOfStudy() {
        Student student2 = StudentFactory.createStudent(
                "John",
                "john@gmail.com",
                "1234",
                "0823456789",
                "220999999",
                "Informatics",
                "Applications Development",
                2,
                null
        );

        repository.create(student2);

        List<Student> result = repository.findByYearOfStudy(2);

        assertFalse(result.isEmpty());
    }
    @Test
    public void testFindByFacultyCaseInsensitive() {
        List<Student> upper = repository.findByFaculty("INFORMATICS");
        List<Student> lower = repository.findByFaculty("informatics");

        assertFalse(upper.isEmpty());
        assertEquals(upper.size(), lower.size());
    }
    @Test
    public void testFindByDepartmentCaseInsensitive() {
        List<Student> upper = repository.findByDepartment("APPLICATIONS DEVELOPMENT");
        List<Student> lower = repository.findByDepartment("applications development");

        assertFalse(upper.isEmpty());
        assertEquals(upper.size(), lower.size());
    }


    @Test
    public void testFindByFaculty() {
        List<Student> students = repository.findByFaculty("Informatics");
        assertFalse(students.isEmpty());
    }
}
