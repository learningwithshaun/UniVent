package za.ac.cput.factory;
/**
 * Name: Zusiphe
 * Surname: Mvovo
 * Student number: 230816851
 * Group: 3H
 * Description: TicketFactory
 * Date: 25 March 2026
 **/

import za.ac.cput.domain.Ticket;
import za.ac.cput.util.Helper;

public class TicketFactory {

    public static Ticket createTicket(int ticketId,
                                      int bookingId,
                                      int issueDate,
                                      int ticketCode) {

        if (!Helper.isPositive(ticketId)) {
            throw new IllegalArgumentException("Ticket ID must be valid");
        }

        if (!Helper.isPositive(bookingId)) {
            throw new IllegalArgumentException("Booking ID must be valid");
        }

        if (!Helper.isPositive(issueDate)) {
            throw new IllegalArgumentException("Issue date must be greater than 0");
        }

        if (!Helper.isPositive(ticketCode)) {
            throw new IllegalArgumentException("Ticket code must be valid");
        }

        return new Ticket.Builder()
                .setTicketId(ticketId)
                .setBookingId(bookingId)
                .setIssueDate(issueDate)
                .setTicketCode(ticketCode)
                .build();
    }
}