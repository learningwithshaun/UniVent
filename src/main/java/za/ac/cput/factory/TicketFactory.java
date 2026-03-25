package za.ac.cput.factory;
/**
 *Name: Zusiphe
 *Surname: Mvovo
 *Student number: 230816851
 *Group: 3H
 *Description:TicketFactory
 * Date: 25 March 2026
 **/

import za.ac.cput.domain.Ticket;
import za.ac.cput.util.Helper;

public class TicketFactory {

    public static Ticket createTicket(//int bookingId,
                                      int issueDate,
                                      int ticketCode) {

        /*if (!Helper.isPositive(bookingId)) {
            throw new IllegalArgumentException("Booking ID must be greater than 0");
        }

         */

        if (!Helper.isPositive(issueDate)) {
            throw new IllegalArgumentException("Issue date must be greater than 0");
        }

        if (!Helper.isPositive(ticketCode)) {
            throw new IllegalArgumentException("Ticket code must be greater than 0");
        }

        return new Ticket.Builder()
                //.setBookingId(bookingId)
                .setIssueDate(issueDate)
                .setTicketCode(ticketCode)
                .build();
    }
}