package za.ac.cput.domain;

import java.time.LocalDateTime;

public class Booking {
    // Attributes
    private final int bookingId;
    private final LocalDateTime bookingDate;
    private BookingStatusEnum status;  // remove final so it can be updated
    private final Student student;
    private final Event event;

    // Private constructor for Builder
    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.status = builder.status;
        this.student = builder.student;
        this.event = builder.event;
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public BookingStatusEnum getStatus() { return status; }
    public Student getStudent() { return student; }
    public Event getEvent() { return event; }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                ", student=" + student +
                ", event=" + event +
                '}';
    }

    // ✅ Correct setter
    public void setStatus(BookingStatusEnum status) {
        this.status = status;
    }

    // Builder class
    public static class Builder {
        private int bookingId;
        private LocalDateTime bookingDate;
        private BookingStatusEnum status;
        private Student student;
        private Event event;

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setBookingDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setStatus(BookingStatusEnum status) {
            this.status = status;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setEvent(Event event) {
            this.event = event;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
