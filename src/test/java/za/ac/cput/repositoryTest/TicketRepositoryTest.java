package za.ac.cput.repositoryTest;
/**
 * Name: Zusiphe
 * Surname: Mvovo
 * Student number: 230816851
 * Group: 3H
 * Description: TicketRepositoryTest
 * Date: 27 March 2026
 **/

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.domain.Ticket;
import za.ac.cput.factory.TicketFactory;
import za.ac.cput.repository.TicketRepositoryImpl;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketRepositoryTest {

    private static TicketRepositoryImpl repository =
            TicketRepositoryImpl.getInstance();

    private static Ticket ticket = TicketFactory.createTicket(
            1,
            101,
            20240101,
            99887
    );

    @Test
    public void a_testCreate() {
        Ticket created = repository.create(ticket);
        assertNotNull(created);
        assertEquals(ticket.getTicketId(), created.getTicketId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_testRead() {
        Ticket read = repository.read(ticket.getTicketId());
        assertNotNull(read);
        assertEquals(ticket.getTicketId(), read.getTicketId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_testUpdate() {
        Ticket updated = TicketFactory.createTicket(
                1,
                101,
                20240201,
                11223
        );
        Ticket result = repository.update(updated);
        assertNotNull(result);
        assertEquals(11223, result.getTicketCode());
        System.out.println("Updated: " + result);
    }

    @Test
    public void d_testGetAll() {
        assertFalse(repository.getAll().isEmpty());
        System.out.println("All Tickets: " + repository.getAll());
    }

    @Test
    public void e_testDelete() {
        boolean deleted = repository.delete(ticket.getTicketId());
        assertTrue(deleted);
        assertNull(repository.read(ticket.getTicketId()));
        System.out.println("Deleted successfully");
    }
}
