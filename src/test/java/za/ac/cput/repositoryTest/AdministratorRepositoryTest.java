package za.ac.cput.repositoryTest;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Administrator;
import za.ac.cput.factory.AdministratorFactory;
import za.ac.cput.repository.AdministratorRepository;


import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Student name: Amanda Msutu
 * Student number: 222428600
 * Group: 3H
 * AdministratorRepositoryTest.java
 * Date: 25 March 2026
 *
 **/

public class AdministratorRepositoryTest {
    private AdministratorRepository repository;
    private Administrator administrator;

    @Before
    public void setUp() {
        repository = AdministratorRepository.getRepository();
        administrator = AdministratorFactory.createAdministrator("Amanda", "amandamsutu02@gmail.com", "123", "0614242618", "Super", new ArrayList<>(), new ArrayList<>());
        repository.create(administrator);
    }

    @Test
    public void testCreate() {
        Administrator created = repository.create(administrator);
        assertNotNull(created);
        assertEquals(administrator.getUserId(), created.getUserId());
    }

    @Test
    public void testRead() {
        Administrator found = repository.read(administrator.getUserId());
        assertNotNull(found);
        assertEquals(administrator.getUserId(), found.getUserId());
    }

    @Test
    public void testUpdate() {
        Administrator updatedAdministrator = new Administrator.Builder()
                .setUserId(administrator.getUserId())
                .setName("Updated Administrator")
                .setEmail(administrator.getEmail())
                .setPassword(administrator.getPassword())
                .setPhoneNumber(administrator.getPhoneNumber())
                .setAdminLevel(administrator.getAdminLevel())
                .setManagedUsers(new ArrayList<>())
                .setManagedEvents(new ArrayList<>())
                .build();

        Administrator updated = repository.update(updatedAdministrator);
        assertNotNull(updated);
        assertEquals("Updated Administrator", updated.getName());
    }

    @Test
    public void testDelete() {
        boolean deleted = repository.delete(administrator.getUserId());
        assertTrue(deleted);
    }

    @Test
    public void testGetAll() {
        assertFalse(repository.getAll().isEmpty());
    }

}
