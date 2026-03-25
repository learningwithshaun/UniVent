
package za.ac.cput.domain;
/**
 *Name: Zusiphe
 *Surname: Mvovo
 *Student number: 230816851
 *Group: 3H
 *Description:Ticket
 * Date: 25 March 2026
 **/

public class Ticket {
    private int ticketId;
    //private int bookingId;
    private int issueDate;
    private int ticketCode;

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        //this.bookingId = builder.bookingId;
        this.issueDate = builder.issueDate;
        this.ticketCode = builder.ticketCode;
    }

    public int getTicketId() {
        return ticketId;
    }


   /* public int getBookingId() {
        return bookingId;
    }

    */
    public int getIssueDate() {
        return issueDate;
    }
    public int getTicketCode() {
        return ticketCode;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
               // ", bookingId=" + bookingId +
                ", issueDate=" + issueDate +
                ", ticketCode=" + ticketCode +
                '}';
    }

    public static class Builder {
        private int ticketId;
        //private int bookingId;
        private int issueDate;
        private int ticketCode;

        public Builder setTicketId(int ticketId) {
            this.ticketId = ticketId;
            return this;
        }
        /*public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

         */
        public Builder setIssueDate(int issueDate) {
            this.issueDate = issueDate;
            return this;
        }
        public Builder setTicketCode(int ticketCode) {
            this.ticketCode = ticketCode;
            return this;
        }

        public Ticket build() { return new Ticket(this); }
    }
}