package za.ac.cput.factoryTest;
/**
 * Name: Zusiphe
 * Surname: Mvovo
 * Student number: 230816851
 * Group: 3H
 * Description: TicketFactoryTest
 * Date: 27 March 2026
 **/

import org.junit.Test;
import za.ac.cput.domain.Ticket;
import za.ac.cput.factory.TicketFactory;

import static org.junit.Assert.*;


public class TicketFactoryTest {

    @Test
    public void createValidTicket() {
        Ticket ticket = TicketFactory.createTicket(
                1,
                101,
                20240101,
                99887
        );
        assertNotNull(ticket);
        assertEquals(1, ticket.getTicketId());
        assertEquals(101, ticket.getBookingId());
        assertEquals(20240101, ticket.getIssueDate());
        assertEquals(99887, ticket.getTicketCode());
        System.out.println("Created: " + ticket);
    }

    @Test
    public void createTicketWithInvalidTicketId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory.createTicket(
                    0,
                    101,
                    20240101,
                    99887
            );
        });
        assertEquals("Ticket ID must be greater than 0", exception.getMessage());
        System.out.println("Invalid ticket ID ");
    }

    @Test
    public void createTicketWithInvalidBookingId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory.createTicket(
                    1,
                    0,
                    20240101,
                    99887
            );
        });
        assertEquals("Booking ID must be greater than 0", exception.getMessage());
        System.out.println("Invalid booking ID ");
    }

    @Test
    public void createTicketWithInvalidIssueDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory.createTicket(
                    1,
                    101,
                    0,
                    99887
            );
        });
        assertEquals("Issue date must be greater than 0", exception.getMessage());
        System.out.println("Invalid issue date");
    }

    @Test
    public void createTicketWithInvalidTicketCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory.createTicket(
                    1,
                    101,
                    20240101,
                    0
            );
        });
        assertEquals("Ticket code must be greater than 0", exception.getMessage());
        System.out.println("Invalid ticket code ");
    }
}