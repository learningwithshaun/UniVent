package za.ac.cput.domain;

public class Event {
    private int eventId;
    private String name;
    private String description;
    private Organizer organizer;
    private Venue venue;
    private String dateTime;
    private int maxAttendees;

    private Event(Builder builder) {
        this.eventId = builder.eventId;
        this.name = builder.name;
        this.description = builder.description;
        this.organizer = builder.organizer;
        this.venue = builder.venue;
        this.dateTime = builder.dateTime;
        this.maxAttendees = builder.maxAttendees;

    }

    public int getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

        @Override
        public String toString() {
            return "Event{" +
                    "eventId=" + eventId +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", organizer=" + organizer +
                    ", venue=" + venue +
                    ", dateTime='" + dateTime + '\'' +
                    ", maxAttendees=" + maxAttendees +
                    '}';
        }

    public static class Builder {
        private int eventId;
        private String name;
        private String description;
        private Organizer organizer;
        private Venue venue;
        private String dateTime;
        private int maxAttendees;

        public Builder setEventId(int eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setOrganizer(Organizer organizer) {
            this.organizer = organizer;
            return this;
        }

        public Builder setVenue(Venue venue) {
            this.venue = venue;
            return this;
        }

        public Builder setDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setMaxAttendees(int maxAttendees) {
            this.maxAttendees = maxAttendees;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}